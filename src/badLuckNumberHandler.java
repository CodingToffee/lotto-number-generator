import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class badLuckNumberHandler implements {
    List<Integer> badLuckNumbers;

    void setBadLuckNumbers(List<Integer> numbers) {
        this.badLuckNumbers = numbers;
    }

    List<Integer> getBadLuckNumbers() {
        return badLuckNumbers;
    }

    void eraseBadLuckNumbers() {
        setBadLuckNumbers(new ArrayList<>());
    }

    void persistBadLuckNumbers() {

    }


}
