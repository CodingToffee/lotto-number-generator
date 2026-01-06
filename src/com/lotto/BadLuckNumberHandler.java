package com.lotto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.google.gson.*;

public class BadLuckNumberHandler implements Serializable {
    List<Integer> badLuckNumbers;
    private static final Logger logger = Logger.getLogger(BadLuckNumberHandler.class.getName());

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
                throw new Exception("Number " + intNumber + " out of valid range! Valid range is between 1 and 50.");
            }
        }
        // Safe bad luck numbers if all are valid
        badLuckNumbers = intNumbers;
    }

    /**
     * Takes a string of space seperated numbers and converts them into a list of integers which is then saved in the badLuckNumbers attribute.
     * @param numbers to be set as bad luck numbers.
     * @throws Exception if the number format isn't correct
     */
    public void setBadLuckNumbers(String numbers) throws Exception {
        try {
            String[] seperateNumbers = numbers.split("\\s+");
            List<Integer> intNumbers = new ArrayList<>();
            for (String number : seperateNumbers) {
                intNumbers.add(Integer.parseInt(number));
            }
            this.badLuckNumbers = intNumbers;
        } catch (Exception e) {
            logger.log(Level.WARNING, "Wrong number format for method setBadLuckNumbers.");
            throw new Exception("Wrong number format!");
        }
    }

    public List<Integer> getBadLuckNumbers() {
        return badLuckNumbers;
    }

    public void eraseBadLuckNumbers() {
        badLuckNumbers.clear();
    }
}
