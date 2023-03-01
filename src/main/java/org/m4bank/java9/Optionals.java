package org.m4bank.java9;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.m4bank.java9.Example.EXAMLE_LIST;

public final class Optionals {

    private Optionals() {
    }

    private static final Map<String, String> humans = Map.of(
            "John", "Doe",
            "Test", "Testov",
            "Ivan", "Ivanov"
    );

    private static Optional<String> getSurname(String name) {
        return Optional.ofNullable(humans.get(name));
    }

    public static Stream<String> optionalStream() {
        return Optional.of("val").stream();
    }

    private static Stream<Optional<String>> example(List<String> names) {
        return names.stream()
                .map(Optionals::getSurname);
    }

    public static List<String> optionalStreamExample() {
        return example(List.of("John", "Test"))
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }

    public static void isPresentOrElse() {
        example(List.of())
                .forEach(s ->
                s.ifPresentOrElse(System.out::println, () -> System.out.println("not found")));
    }

    public static String optionalOr() {
        return Optional.empty()
                .or(() -> Optional.of("test"))
                .map(String.class::cast)
                .orElse(null);
    }
}
