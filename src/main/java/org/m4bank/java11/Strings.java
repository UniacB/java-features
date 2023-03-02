package org.m4bank.java11;

import java.util.stream.Stream;

@SuppressWarnings("unused")
public final class Strings {

    private Strings() {
    }

    public static final String STRING_WITH_SPACES = "\t  string with spaces   \t";

    /**
     * strip лучше понимает пробелы по Unicode, чем trim()
     */
    public static String strip() {
        return STRING_WITH_SPACES.strip();
    }

    public static String stripLeading() {
        return STRING_WITH_SPACES.stripLeading();
    }

    public static String stringTrailing() {
        return STRING_WITH_SPACES.stripTrailing();
    }

    public static Stream<String> streamFromString() {
        return STRING_WITH_SPACES.lines();
    }
}
