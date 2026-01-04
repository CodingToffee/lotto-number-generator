package com.lotto;

import java.util.ArrayList;
import java.util.List;

public interface NumberGenerator {

    /**
     * Generates a random number and checks it against the bad luck numbers.
     * @param invalidNumbers numbers that shall not be generated.
     * @param range The valid range to generate a random number from.
     * @return A valid random number within the valid range of numbers.
     */
    static int generateValidRandomNumber(List<Integer> invalidNumbers, int range) {
        while (true) {
            int randInt = (int)(Math.random() * range);
            if (NumberGenerator.validateRandomNumber(invalidNumbers, randInt)) {
                return randInt;
            }
        }
    }

    /**
     * Generates the numbers to be used for tipping. Ignores numbers that are defined as bad luck numbers.
     * @param invalidNumbers
     * @param amount The amount of numbers to be generated.
     * @param range The upper limit of the range to draw the numbers from. Starting at 1.
     * @return A list of integer numbers within the implemented range. Excludes bad luck numbers.
     */
    static List<Integer> generateTippingNumbers(List<Integer> invalidNumbers, int amount, int range) {
        List<Integer> tippingNumbers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int randInt = NumberGenerator.generateValidRandomNumber(invalidNumbers, range+1);
            tippingNumbers.add(randInt);
            invalidNumbers.add(randInt);
        }
        tippingNumbers.sort(Integer::compareTo);
        return tippingNumbers;
    }
    /**
     * Validates that a given number is not part of the given bad luck numbers.
     * @param badLuckNumbers numbers that shall not be generated.
     * @param randomNumber the number to be validated.
     * @return True if number is not part of the bad luck numbers. False otherwise.
     */
    static boolean validateRandomNumber(List<Integer> badLuckNumbers, int randomNumber) {
        // validate number against badLuckNumbers
        for (int badLuckNumber : badLuckNumbers) {
            if (randomNumber == badLuckNumber) {
                return false;
            }
        }
        return true;
    }
}