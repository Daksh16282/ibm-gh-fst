package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class Activity4_Test {

    @Test
    public void testMethod() {
        String text = "ABC";
        assertEquals(text, "ABC");
    }
}
