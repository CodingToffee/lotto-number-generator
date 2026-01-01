import java.util.ArrayList;
import java.util.List;

public class SixOutOfFourtyNine {


    public int generateValidRandomNumber(List<Integer> badLuckNumbers) {
        while (true) {
            int randInt = (int)(Math.random() * 50);
            if (NumberGenerator.validateRandomNumber(badLuckNumbers, randInt)) {
                return randInt;
            }
        }
    }

    public List<Integer> generateNumbers(List<Integer> badLuckNumbers) {
        List<Integer> tippNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int randInt = generateValidRandomNumber(badLuckNumbers);
            tippNumbers.add(randInt);
        }
        tippNumbers.sort(Integer::compareTo);
        return tippNumbers;
    }

}
