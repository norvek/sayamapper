package io.dojogeek.sayamapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InspectableObject {

    private Object object;

    public InspectableObject(Object object) {
        this.object = object;
    }

    public List<FlexibleField> getDeclaredFields() {
        List<FlexibleField> fields = new ArrayList<>();

        Stream.of(this.object.getClass().getDeclaredFields()).forEach(field -> {
            if (this.isAJavaType(field)) {
                fields.add(new JavaField(field, this.object));
                return;
            }

            fields.add(new ForeignField(field, this.object));
        });

        return fields;
    }

    protected boolean isAJavaType(Field field) {
        return field.getType().isPrimitive() ||
                field.getType().isAssignableFrom(Byte.class) ||
                field.getType().isAssignableFrom(Short.class) ||
                field.getType().isAssignableFrom(Integer.class) ||
                field.getType().isAssignableFrom(Long.class) ||
                field.getType().isAssignableFrom(Float.class) ||
                field.getType().isAssignableFrom(Double.class) ||
                field.getType().isAssignableFrom(String.class);
    }

}