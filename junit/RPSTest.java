package fst.rock_paper_scissors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RPSTest {
    private static RPS rps;

    @BeforeAll
    public static void setUp() {
        rps = new RPS();
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    public void testValidUserInput(int userInput) {
        assertDoesNotThrow(() -> {
            rps.validateUserInput(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = { 4, 8 })
    public void testInvalidUserInput(int userInput) {
        assertThrows(Exception.class, () -> {
            rps.validateUserInput(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "abc", "xyz" })
    public void testInvalidStringUserInput(String userInput) {
        assertThrows(Exception.class, () -> {
            rps.validateUserInput(Integer.parseInt(userInput));
        });
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2 })
    public void testValidCompInput(int compInput) {
        assertDoesNotThrow(() -> {
            rps.validateCompInput(compInput);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = { 3, 9 })
    public void testInvalidCompInput(int compInput) {
        assertThrows(Exception.class, () -> {
            rps.validateCompInput(compInput);
        });
    }

    @ParameterizedTest
    @CsvSource({ "0 , 1",
            "1 , 2",
            "2 , 0" })
    public void validateWin(int userInput, int compInput) {
        assertEquals("You Win", rps.calculateResult(userInput, compInput));
    }

    @ParameterizedTest
    @CsvSource({ "1 , 0",
            "2 , 1",
            "0 , 2" })
    public void validateLose(int userInput, int compInput) {
        assertEquals("You Lose", rps.calculateResult(userInput, compInput));
    }

    @ParameterizedTest
    @CsvSource({ "0 , 0",
            "1 , 1",
            "2 , 2" })
    public void validateDraw(int userInput, int compInput) {
        assertEquals("Match Draw", rps.calculateResult(userInput, compInput));
    }

    @ParameterizedTest
    @CsvSource({
            "0 , 1 , You Win",
            "1 , 0 , You Lose",
            "1 , 1, Match Draw"
    })
    public void validateResultsWritten(String userSelection, String compSelection, String result) {
        assertTrue(rps.writeResults(userSelection, compSelection, result));
    }

    @ParameterizedTest
    @CsvSource({
            "0 , 1 , You Win",
            "1 , 0 , You Lose",
            "1 , 1, Match Draw"
    })
    public void validateCorrectResultsWritten(String userSelection, String compSelection, String result) {
        rps.writeResults(userSelection, compSelection, result);
        String writtenData = rps.getHistoryData();
        String[] records = writtenData.strip().split("\\R");
        String lastLine = records[records.length - 1];

        assertEquals(lastLine, "You Selected ->" + userSelection + " ,Opponent Selected->" + compSelection
                + " ,Result is ->" + result);
    }

}
