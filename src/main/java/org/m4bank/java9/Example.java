package org.m4bank.java9;

import java.util.List;

import static org.m4bank.java9.Streams.takeWhile;

@SuppressWarnings("unused")
public class Example {

    public static final List<Example> EXAMLE_LIST = List.of(
            new Example("test", null),
            new Example("test2", List.of(1)),
            new Example("test3", takeWhile())
    );

    private String name;

    private List<Integer> integers;

    public Example(String name, List<Integer> integers) {
        this.name = name;
        this.integers = integers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }
}
