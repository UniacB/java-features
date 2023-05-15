package org.m4bank.java17;

public sealed class Teacher extends Person permits MathTeacher, LanguageTeacher {

    @Override
    String doingInCollege() {
        return "Teach";
    }
}
