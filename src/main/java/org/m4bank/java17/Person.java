package org.m4bank.java17;

public sealed class Person permits Student, Teacher, Curator {

    @SuppressWarnings("unused")
    String doingInCollege() {
        return "locate";
    }
}
