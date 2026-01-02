import java.util.List;

public interface NumberGenerator {

    /**
     * Generates a random number and checks it against the bad luck numbers.
     * @param badLuckNumbers numbers that shall not be generated.
     * @return A valid random number within the valid range of numbers.
     */
    int generateValidRandomNumber(List<Integer> badLuckNumbers);

    /**
     * Generates the numbers to be used for tipping. Ignores numbers that are defined as bad luck numbers.
     * @return A list of integer numbers within the implemented range. Excludes bad luck numbers.
     */
    List<Integer> generateTippingNumbers(List<Integer> badLuckNumbers);

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