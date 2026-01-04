package com.lotto;

import java.util.ArrayList;
import java.util.List;

public class SixOutOfFortyNine implements NumberGenerator {
    List<Integer> tippingNumbers = new ArrayList<>();

    public SixOutOfFortyNine(List<Integer> badLuckNumbers) {
        tippingNumbers = NumberGenerator.generateTippingNumbers(badLuckNumbers, 6, 49);
    }

    public List<Integer> getTippingNumbers() {
        return tippingNumbers;
    }
}
