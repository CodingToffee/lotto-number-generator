import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class badLuckNumberHandler {
    List<Integer> badLuckNumbers;

    void setBadLuckNumbers(List<Integer> numbers) {
        this.badLuckNumbers = numbers;
    }

    List<Integer> getBadLuckNumbers() {
        return badLuckNumbers;
    }


    /**
     * Checks for each number if it is in the valid range of 0-50
     * @param numbers
     * @throws Exception
     */
    public void validateBadLuckNumbers(String numbers) throws Exception {
        List<Integer> intNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            int intNumber = Integer.parseInt(numbers);
            if (intNumber < 0 || intNumber > 50) {
                intNumbers.add(intNumber);
            } else {
                throw new Exception("Number out of valid range!");
            }
        }
        // Safe bad luck numbers if all are valid
        badLuckNumbers = intNumbers;
        return;
    }

    void eraseBadLuckNumbers() {
        setBadLuckNumbers(new ArrayList<>());
    }

    void persistBadLuckNumbers() {

    }


}
