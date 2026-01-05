package com.lotto;

import java.util.ArrayList;
import java.util.List;

public class EuroJackpot implements NumberGenerator{
    List<Integer> twoOutOfTen = new ArrayList<>();
    List<Integer> fiveOutOfFifty = new ArrayList<>();
    BadLuckNumberHandler badLuckNumberHandler;

    public EuroJackpot(BadLuckNumberHandler badLuckNumberHandler) {
        this.badLuckNumberHandler = badLuckNumberHandler;
        twoOutOfTen = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 2, 10);
        fiveOutOfFifty = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 5, 50);
    }

    public List<Integer> getTwoOutOfTen() {
        return twoOutOfTen;
    }

    public List<Integer> getFiveOutOfFifty() {
        return fiveOutOfFifty;
    }

    public void regenerateTippingNumbers() {
        twoOutOfTen = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 2, 10);
        fiveOutOfFifty = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 5, 50);
        System.out.println("Generated tipping numbers for Eurojackpot (2 out of 10): " + getTwoOutOfTen());
        System.out.println("Generated tipping numbers for Eurojackpot (5 out of 50): " + getFiveOutOfFifty());
    }
}
