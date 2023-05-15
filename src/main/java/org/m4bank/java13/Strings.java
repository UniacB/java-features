package org.m4bank.java13;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Strings {

    public static String jsonTextBlock() {
        return """
                {
                    name: "John",
                    surname: "Doe",
                    age: 30
                }
                """.stripIndent();
    }
}
