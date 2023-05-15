package org.m4bank;

import lombok.AllArgsConstructor;

import java.util.Calendar;

@AllArgsConstructor
public enum Day {

    MONDAY(Calendar.MONDAY),
    TUESDAY(Calendar.TUESDAY),
    WEDNESDAY(Calendar.WEDNESDAY), //да-да, отсылка на Вэнсдэй
    THURSDAY(Calendar.THURSDAY),
    FRIDAY(Calendar.FRIDAY),
    SATURDAY(Calendar.SATURDAY),
    SUNDAY(Calendar.SUNDAY);

    private final int javaCalendarDay;
}
