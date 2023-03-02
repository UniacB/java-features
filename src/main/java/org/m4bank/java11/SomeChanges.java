package org.m4bank.java11;

import org.m4bank.FileResourceUtils;
import org.m4bank.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

@SuppressWarnings("unused")
public final class SomeChanges {

    private SomeChanges() {
    }

    public static List<String> streamVars() {
        return Stream.of("one", "two", "three")
                .map((@NotNull var s) -> s.toUpperCase())
                .collect(Collectors.toList());
    }

    public static String stringFromFile() throws URISyntaxException, IOException {
        return Files.readString(FileResourceUtils.getFileFromResource("test.txt").toPath());
    }

    public static List<String> notPredicate() {
        return Stream.of("", "  ", "1")
                .filter(not(String::isBlank))
                .collect(Collectors.toList());
    }

    public static boolean isEmpty() {
        String nullable = null;
        return Optional.ofNullable(nullable).isEmpty();
    }
}
