package com.lotto;

import java.util.ArrayList;
import java.util.List;

public class EuroJackpot implements NumberGenerator{
    List<Integer> twoOutOfTen = new ArrayList<>();
    List<Integer> fiveOutOfFifty = new ArrayList<>();

    public EuroJackpot(List<Integer> badLuckNumbers) {
        twoOutOfTen = NumberGenerator.generateTippingNumbers(badLuckNumbers, 2, 10);
        fiveOutOfFifty = NumberGenerator.generateTippingNumbers(badLuckNumbers, 5, 50);
    }

    public List<Integer> getTwoOutOfTen() {
        return twoOutOfTen;
    }

    public List<Integer> getFiveOutOfFifty() {
        return fiveOutOfFifty;
    }
}
