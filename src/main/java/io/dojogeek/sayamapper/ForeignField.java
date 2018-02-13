package io.dojogeek.sayamapper;

import java.lang.reflect.Field;

public class ForeignField extends FlexibleField {

    public ForeignField(Field field, Object declaringObject) {
        super(field, declaringObject);
    }

    @Override
    protected void setValue(FlexibleField flexibleField) {
        this.populateFrom(new SourceObject(flexibleField.getValue()));
    }

    @Override
    protected InspectableObject getReferenceToManageableObject() {
        Object reference = null;

        try {
            this.field.setAccessible(true);
            reference = this.field.get(declaringObject);

            if (reference != null) {
                return new InspectableObject(reference);
            }

            reference = this.field.getType().newInstance();
            this.field.set(declaringObject, reference);

        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return new InspectableObject(reference);
    }

}