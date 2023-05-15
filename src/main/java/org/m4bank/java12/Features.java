package org.m4bank.java12;

import lombok.*;
import org.m4bank.Day;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Features {

    public static int oldSwitch(Day day) {
        final int numLetters;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Huh? " + day);
        }

        return numLetters;
    }

    public static int newSwitch(Day day) {
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Huh? " + day);
        };
    }

    public static EventParticipation teeCollector() {
        return Stream.of(new Guest("Asmodeus", false, 15),
                        new Guest("Behemoth", true, 5),
                        new Guest("Lucifer", true, 10))
                .collect(Collectors.teeing(
                        Collectors.filtering(
                                Guest::isParticipating,
                                // мы хотим взять только имя в списке
                                Collectors.mapping(o -> o.name, Collectors.toList())
                        ),
                        // второй коллектор, мы хотим найти общее количество участников
                        Collectors.summingInt(Guest::getParticipantsNumber),
                        // мы объединяем коллекторы в новый объект,
                        // значения передаются неявно
                        EventParticipation::new
                ));
    }

    public static List<List<String>> filterByNames() {
        return Stream.of("Devoxx", "Voxxed Days", "Code One", "Basel One", "Angular Connect")
                .collect(Collectors.teeing(
                        // первый коллектор
                        Collectors.filtering(n -> n.contains("xx"), Collectors.toList()),
                        // второй коллектор
                        Collectors.filtering(n -> n.endsWith("One"), Collectors.toList()),
                        // слияние - автоматический вывод типа здесь не работает
                        List::of
                ));
    }

    @Getter
    @AllArgsConstructor
    static class Guest {
        private String name;
        private boolean participating;
        private Integer participantsNumber;
    }

    @Getter
    @ToString
    @EqualsAndHashCode
    @AllArgsConstructor
    public static class EventParticipation {
        private List<String> guestNameList;
        private Integer totalNumberOfParticipants;
    }
}
