package com.lotto;

import java.util.ArrayList;
import java.util.List;

public class SixOutOfFortyNine implements NumberGenerator {
    List<Integer> tippingNumbers = new ArrayList<>();
    BadLuckNumberHandler badLuckNumberHandler;

    public SixOutOfFortyNine(BadLuckNumberHandler badLuckNumberHandler) {
        this.badLuckNumberHandler = badLuckNumberHandler;
        tippingNumbers = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.getBadLuckNumbers(), 6, 49);
    }

    public List<Integer> getTippingNumbers() {
        return tippingNumbers;
    }

    public void regenerateTippingNumbers() {
        tippingNumbers = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 6, 49);
        System.out.println("Generated tipping numbers for 6 out of 49:" + tippingNumbers);
    }
}
