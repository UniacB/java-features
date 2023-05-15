package org.m4bank.java14;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Features {

    public static User getUser() {
        return new User("Ivan", "Ivanov", 30);
    }

    public static User userWithDefaultName() {
        return new User("Doe", 30);
    }

    public record User(String name, String surname, int age) {
        private static final String DEFAULT_NAME = "John";

        public User(String surname, int age) {
            this(DEFAULT_NAME, surname, age);
        }
    }

    public static String instanceOf(final Object obj) {
        if (obj instanceof String stringValue) {
            return stringValue;
        } else {
            return "Object is not instance of String";
        }
    }
}
