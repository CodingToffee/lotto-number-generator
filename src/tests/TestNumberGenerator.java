package tests;

import static org.junit.jupiter.api.Assertions.*;

import com.lotto.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestNumberGenerator {
    List<Integer> badLuckNumbers_1;
    List<Integer> badLuckNumbers_2;
    int numberOfBadLuckNumbers = 6;

    List<Integer> generateRandomBadLuckNumbers() {
        List<Integer> badLuckNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfBadLuckNumbers; i++) {
            while (true) {
                int randInt = (int) (Math.random() * 50);
                // Check if badLuckNumber already exists
                if (!badLuckNumbers.contains(randInt)) {
                    badLuckNumbers.add(randInt);
                    break;
                }
            }
        }
        return badLuckNumbers;
    }

    @BeforeEach
    void init() {
        // Generate random badLuckNumbers
        badLuckNumbers_1 = generateRandomBadLuckNumbers();
        badLuckNumbers_2 = generateRandomBadLuckNumbers();
    }

    @Test
    void badLuckNumbersNotTheSame() {
        assertNotEquals(badLuckNumbers_1, badLuckNumbers_2);
    }

    @Test
    void BadLuckNumbersNotInTippingNumbers() {
        List<Integer> tippingNumbers_1 = NumberGenerator.generateTippingNumbers(badLuckNumbers_1, 6, 49);
        assertFalse(tippingNumbers_1.containsAll(badLuckNumbers_1));
        List<Integer> tippingNumbers_2 = NumberGenerator.generateTippingNumbers(badLuckNumbers_2, 6, 49);
        assertFalse(tippingNumbers_2.containsAll(badLuckNumbers_2));
    }

    @Test
    @DisplayName("No number should be contained twice in the tipping numbers")
    void noDoubleNumbers() {
        List<Integer> tippingNumbers_1 = NumberGenerator.generateTippingNumbers(badLuckNumbers_1, 6, 49);
        System.out.println("tippingsNumbers: " + tippingNumbers_1);
        boolean twice = false;
        for (int i = 0; i < tippingNumbers_1.size(); i++) {
            List<Integer> tippingNumbersWithoutTippingNumber = new ArrayList<>(tippingNumbers_1);
            System.out.println(tippingNumbersWithoutTippingNumber.remove(i));
            System.out.println(tippingNumbersWithoutTippingNumber);
            if (tippingNumbersWithoutTippingNumber.contains(tippingNumbers_1.get(i))) {
                twice = true;
                break;
            }
        }
        assertFalse(twice);
    }
}
