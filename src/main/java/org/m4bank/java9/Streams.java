package org.m4bank.java9;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.m4bank.java9.Example.EXAMLE_LIST;

public final class Streams {

    private Streams() {
    }

    public static Set<Integer> newSetInit() {
        return Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    }

    public static Set<Integer> expectedNull() {
        try {
            Set<Integer> integer = newSetInit();
            integer.add(11);
            return integer;
        } catch (UnsupportedOperationException e) {
            System.out.println("We expected this!");
        }

        return Set.of();
    }

    public static List<Integer> newListInit() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    }

    public static Map<Integer, String> newMapInit() {
        return Map.of(1, "one",
                2, "two",
                3, "three",
                4, "four",
                5, "five",
                6, "six",
                7, "seven",
                8, "eight",
                9, "nine",
                0, "zero");
    }

    /**
     * будет удалять элементы из стрима, до тех пор, пока не найдется элемент, подходящий под предикат
     */
    public static List<Integer> dropWhile() {
        return Stream.of(1, 2, 3, 4)
                .dropWhile(val -> val != 3)
                .collect(Collectors.toList());
    }

    /**
     * будет брать элементы стрима, до тех пор пока не встретится элемент, подходящий под предикат
     */
    public static List<Integer> takeWhile() {
        return Stream.of(1, 2, 3, 4)
                .dropWhile(val -> val != 3)
                .collect(Collectors.toList());
    }

    public static List<Integer> iterateDefault() {
        return IntStream.iterate(0, i -> i + 1)
                .takeWhile(i -> i < 10)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> iterateWithPredicate() {
        return IntStream.iterate(0, i -> i < 10, i -> ++i)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> nullableStreamJava8() {
        return EXAMLE_LIST.stream()
                .flatMap(example ->
                        example.getIntegers() != null
                                ? example.getIntegers().stream()
                                : Stream.of())
                .collect(Collectors.toList());
    }

    public static List<Integer> nullableStreamJava9() {
        return EXAMLE_LIST.stream()
                .flatMap(example -> Stream.ofNullable(example.getIntegers()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
