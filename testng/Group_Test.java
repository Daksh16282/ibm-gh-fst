package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class Group_Test {

    @Test(groups = { "ABC" })
    public void runTest() {
        assertEquals("ABC", "ABC");
    }
}
