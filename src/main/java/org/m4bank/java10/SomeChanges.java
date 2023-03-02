package org.m4bank.java10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public final class SomeChanges {

    private SomeChanges() {
    }

    public static List<Integer> collectToList() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toUnmodifiableList());
    }

    public static Set<Integer> collectToSet() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Map<String, Integer> collectToUnmodifiableMap() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toUnmodifiableMap(String::valueOf, Function.identity()));
    }

    public static Map<String, Integer> collectToUnmodifiableMapWithBinaryOperator() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toUnmodifiableMap(
                        i -> String.valueOf(Math.pow(i, 2)),
                        Function.identity(),
                        Integer::max));
    }

    public static String vars() {
        var a = List.of(1, 2, 3, 4);
        var b = a.stream();
        return b.map(String::valueOf).collect(Collectors.joining(", "));
    }
}
