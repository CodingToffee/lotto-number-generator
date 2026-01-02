import java.util.ArrayList;
import java.util.List;

public class SixOutOfFourtyNine implements NumberGenerator {

    /**
     * {@inheritDoc}
     * @param badLuckNumbers
     * @return random integer number between 1 and 49.
     */
    public int generateValidRandomNumber(List<Integer> badLuckNumbers) {
        while (true) {
            int randInt = (int)(Math.random() * 50);
            if (NumberGenerator.validateRandomNumber(badLuckNumbers, randInt)) {
                return randInt;
            }
        }
    }

    /**
     * {@inheritDoc}
     * @param badLuckNumbers
     * @return 6 valid numbers within the range of 1 to 49.
     */
    public List<Integer> generateTippingNumbers(List<Integer> badLuckNumbers) {
        List<Integer> tippNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int randInt = generateValidRandomNumber(badLuckNumbers);
            tippNumbers.add(randInt);
        }
        tippNumbers.sort(Integer::compareTo);
        return tippNumbers;
    }
}
