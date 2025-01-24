package extended.testdata;

import extended.models.User;

public class Constants {
    public static final User DEFAULT_USER = User.builder()
            .id(0)
            .username("username")
            .firstName("name")
            .lastName("surname")
            .email("test@gmail.com")
            .password("p@ssw)rd")
            .phone("1234567890")
            .userStatus(0)
            .build();
}
