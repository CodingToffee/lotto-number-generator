import java.util.List;

public interface NumberGenerator {
    /**
     * Generates the numbers to be used for tipping. Ignores numbers that are defined as bad luck numbers.
     * @return A list of integer numbers
     */
    public List<Integer> generateNumbers(List<Integer> badLuckNumbers);


    public static boolean validateRandomNumber(List<Integer> badLuckNumbers, int randomNumber) {
        // validate number against badLuckNumbers
        for (int i = 0; i < badLuckNumbers.size(); i++) {
            if (randomNumber == badLuckNumbers.get(i)) {
                return false;
            }
        }
        return true;
    }

    
}