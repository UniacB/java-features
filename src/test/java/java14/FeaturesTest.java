package java14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.m4bank.java14.Features;

class FeaturesTest {

    @Test
    void records() {
        Features.User user = Features.getUser();
        System.out.println(user);
        Assertions.assertEquals("User[name=Ivan, surname=Ivanov, age=30]", user.toString());

        Features.User userInfo2 = Features.userWithDefaultName();
        System.out.println(userInfo2);
        Assertions.assertEquals("User[name=John, surname=Doe, age=30]", userInfo2.toString());
    }

    @Test
    void instanceOfTest() {
        String string = Features.instanceOf("asd");
        System.out.println(string);
        Assertions.assertEquals("asd", string);

        String string2 = Features.instanceOf(new Object());
        System.out.println(string2);
        Assertions.assertEquals("Object is not instance of String", string2);
    }

    @Test
    void helpfulNPE() {
        Features.User user = null;
        Assertions.assertNull(user);
        try {
            int age = user.age();
            System.out.println(age);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
