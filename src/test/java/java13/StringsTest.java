package java13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.m4bank.java13.Strings;

class StringsTest {

    @Test
    void textBlocks() {
        String textBlock = Strings.jsonTextBlock();
        System.out.println(textBlock);
        Assertions.assertNotNull(textBlock);
    }
}
