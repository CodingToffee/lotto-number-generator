package com.lotto;

import java.util.ArrayList;
import java.util.List;

public class SixOutOfFortyNine implements NumberGenerator {
    List<Integer> sixOutOfFortyNine = new ArrayList<>();

    public SixOutOfFortyNine(List<Integer> badLuckNumbers) {
        sixOutOfFortyNine = NumberGenerator.generateTippingNumbers(badLuckNumbers, 6, 49);
    }
}
