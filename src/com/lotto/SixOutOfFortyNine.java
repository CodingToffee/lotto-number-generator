package com.lotto;

import java.util.ArrayList;
import java.util.List;

public class SixOutOfFortyNine implements NumberGenerator {

    /**
     * {@inheritDoc}
     * @param invalidNumbers
     * @return random integer number between 1 and 49.
     */
    public int generateValidRandomNumber(List<Integer> invalidNumbers) {
        while (true) {
            int randInt = (int)(Math.random() * 50);
            if (NumberGenerator.validateRandomNumber(invalidNumbers, randInt)) {
                return randInt;
            }
        }
    }

    /**
     * {@inheritDoc}
     * @param invalidNumbers
     * @return 6 valid numbers within the range of 1 to 49.
     */
    public List<Integer> generateTippingNumbers(List<Integer> invalidNumbers) {
        List<Integer> tippNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int randInt = generateValidRandomNumber(invalidNumbers);
            tippNumbers.add(randInt);
            invalidNumbers.add(randInt);
        }
        tippNumbers.sort(Integer::compareTo);
        return tippNumbers;
    }
}
