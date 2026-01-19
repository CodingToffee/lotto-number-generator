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
            if (intNumber > 0 && intNumber < 51) {
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
        String[] seperateNumbers = numbers.split("\\s+");
        List<Integer> intNumbers = new ArrayList<>();
        if (seperateNumbers.length > 6) {
            logger.log(Level.WARNING, "Too many bad luck numbers given.");
            throw new IllegalArgumentException("Too many bad luck numbers! Only six allowed.");
        }
        for (String number : seperateNumbers) {
            int intNumber;
            try {
                intNumber = Integer.parseInt(number);
            } catch (Exception e) {
                logger.log(Level.WARNING, "Wrong number format for method setBadLuckNumbers.");
                throw new NumberFormatException("Wrong number format!");
            }
            if (intNumber > 0 && intNumber < 51) {
                intNumbers.add(Integer.parseInt(number));
            }
            else {
                logger.log(Level.WARNING, "Bad luck number out of range.");
                throw new IllegalArgumentException("Number out of Range. Only 1-50 allowed.");
            }
        }
        this.badLuckNumbers = intNumbers;
    }

    /**
     * Getter for bad luck numbers.
     * @return the bad luck numbers.
     */
    public List<Integer> getBadLuckNumbers() {
        return badLuckNumbers;
    }

    /**
     * Erases the bad luck numbers.
     */
    public void eraseBadLuckNumbers() {
        badLuckNumbers.clear();
    }
}
