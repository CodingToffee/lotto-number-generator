package com.lotto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import com.google.gson.*;

public class BadLuckNumberHandler implements Serializable {
    List<Integer> badLuckNumbers;

    /**
     * Checks for each number if it is in the valid range of 0-50
     * @param numbers numbers to be evaluated
     * @throws Exception if a number is not valid, an exception will be thrown. Also if more than six numbers are given.
     */
    public BadLuckNumberHandler(String[] numbers) throws Exception {
        List<Integer> intNumbers = new ArrayList<>();
        if (numbers.length > 6) {
            throw new Exception("Too many bad luck numbers! Only six allowed.");
        }
        for (int i = 0; i < numbers.length; i++) {
            int intNumber = Integer.parseInt(numbers[i]);
            if (intNumber > 0 && intNumber < 50) {
                intNumbers.add(intNumber);
            } else {
                throw new Exception("Number " + intNumber + " out of valid range!");
            }
        }
        // Safe bad luck numbers if all are valid
        badLuckNumbers = intNumbers;
    }

    void setBadLuckNumbers(List<Integer> numbers) {
        this.badLuckNumbers = numbers;
    }

    List<Integer> getBadLuckNumbers() {
        return badLuckNumbers;
    }
}
