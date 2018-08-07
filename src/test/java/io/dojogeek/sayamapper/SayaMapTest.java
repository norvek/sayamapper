package io.dojogeek.sayamapper;

import io.dojogeek.dtos.UserDto;
import io.dojogeek.models.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SayaMapTest {

    private BridgeMap<UserDto, User> map = new SayaMapBridge<>();

    @Test
    public void shouldReturnANotNullTargetInstance() {
        UserDto userDto = new UserDto();

        User user = map.inner().from(userDto).to(User.class).build();

        assertNotNull(user);
    }

    @Test
    public void shouldMapFieldWithTheSameTypeAndName() {
        UserDto userDto = new UserDto();
        userDto.setName("Jacob");
        userDto.setJob("Programmer");

        User user = map.inner().from(userDto).to(User.class).build();

        assertEquals("Jacob", user.getName());
        assertEquals("Programmer", user.getJob());
    }

    @Test
    public void shouldIgnoreFields() {
        UserDto userDto = new UserDto();
        userDto.setName("Jacob");
        userDto.setJob("Programmer");

        User user = map.inner().from(userDto).to(User.class).ignoring(target ->
            target.ignore("name").ignore("job")
        ).build();

        assertNull(user.getName());
        assertNull(user.getJob());
    }

}
