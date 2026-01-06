package tests;

import static org.junit.jupiter.api.Assertions.*;
import com.lotto.BadLuckNumberHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBadLuckNumberHandler {
    BadLuckNumberHandler badLuckNumberHandler;

    @BeforeEach
    void init() {
        String[] initBadLuckNumbers = {"1", "10", "15", "20", "50"};
        try {
            badLuckNumberHandler = new BadLuckNumberHandler(initBadLuckNumbers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("The constructor shall throw an exception when given numbers are out of range.")
    void numbersOutOfRange() {
        String[] badLuckNumbers = {"1", "10", "15", "20", "50"};
        assertDoesNotThrow(() -> {new BadLuckNumberHandler(badLuckNumbers);});
        String[] invalidBadLuckNumbers = {"1", "10", "15", "20", "30", "51"};
        assertThrows(Exception.class, () -> {new BadLuckNumberHandler(invalidBadLuckNumbers);});
    }

    @Test
    @DisplayName("The constructor shall throw an exception when the numbers are given in the wrong format.")
    void numberFormat() {
        String[] invalidBadLuckNumbers = {"1", "a", "a", "10"};
        assertThrows(Exception.class, () -> {new BadLuckNumberHandler(invalidBadLuckNumbers);});
    }

    @Test
    @DisplayName("The constructor shall throw an exception when more than six numbers are given.")
    void tooManyNumbers() {
        String[] invalidBadLuckNumbers = {"1", "2", "3", "4", "5", "6", "7"};
        assertThrows(Exception.class, () -> {new BadLuckNumberHandler(invalidBadLuckNumbers);});
    }

    @Test
    @DisplayName("The setBadLuckNumbers method shall throw an exception when given numbers are out of range.")
    void numbersOutOfRange_setBadLuckNumbers() {
        String badLuckNumbers = "1 10 15 20 25";
        assertDoesNotThrow(() -> {badLuckNumberHandler.setBadLuckNumbers(badLuckNumbers);});
        String invalidBadLuckNumbers = "10 30 40 50 51";
        assertThrows(IllegalArgumentException.class, () -> {badLuckNumberHandler.setBadLuckNumbers(invalidBadLuckNumbers);});
    }

    @Test
    @DisplayName("The setBadLuckNumbers method shall throw an exception when the numbers are given in the wrong format.")
    void numberFormat_setBadLuckNumbers() {
        String invalidBadLuckNumbers = "1 a b c 2";
        assertThrows(NumberFormatException.class, () -> {badLuckNumberHandler.setBadLuckNumbers(invalidBadLuckNumbers);});
    }

    @Test
    @DisplayName("The setBadLuckNumbers method shall throw an exception when more than six numbers are given.")
    void tooManyNumbers_setBadLuckNumbers() {
        String invalidBadLuckNumbers = "1 2 3 4 5 6 7";
        assertThrows(IllegalArgumentException.class, () -> {badLuckNumberHandler.setBadLuckNumbers(invalidBadLuckNumbers);});
    }

    @Test
    @DisplayName("After the method eraseBadLuckNumbers was invoked, the badLuckNumbers should be empty.")
    void emptyBadLuckNumbers() {
        badLuckNumberHandler.eraseBadLuckNumbers();
        assertEquals(0, badLuckNumberHandler.getBadLuckNumbers().size());
    }
}
