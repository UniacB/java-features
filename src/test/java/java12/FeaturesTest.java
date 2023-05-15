package java12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.m4bank.Day;
import org.m4bank.java12.Features;

import java.util.List;

class FeaturesTest {

    @Test
    void switchStatement() {
        System.out.println("old switch");
        int dayCounter = Features.oldSwitch(Day.FRIDAY);
        System.out.println(dayCounter);
        Assertions.assertEquals(6, dayCounter);

        System.out.println("new switch");
        dayCounter = Features.newSwitch(Day.SATURDAY);
        System.out.println(dayCounter);
        Assertions.assertEquals(8, dayCounter);
    }

    @Test
    void teeCollector() {
        Features.EventParticipation eventParticipation = Features.teeCollector();
        System.out.println(eventParticipation.toString());

        Assertions.assertEquals(
                new Features.EventParticipation(
                        List.of("Behemoth", "Lucifer"),
                        30),
                eventParticipation);
    }
}
