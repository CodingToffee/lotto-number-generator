package com.lotto;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds methods to generate tipping numbers for the Euro Jackpot Lotto game.
 *
 * @author Nicolas Harrje
 */
public class EuroJackpot implements NumberGenerator{
    List<Integer> twoOutOfTen = new ArrayList<>();
    List<Integer> fiveOutOfFifty = new ArrayList<>();
    BadLuckNumberHandler badLuckNumberHandler;

    /**
     * This constructor generates tipping numbers for Euro Jackpot under exclusion of the bad luck numbers and saves
     * them into the members of the class.
     * @param badLuckNumberHandler among other things holds the bad luck numbers
     */
    public EuroJackpot(BadLuckNumberHandler badLuckNumberHandler) {
        this.badLuckNumberHandler = badLuckNumberHandler;
        twoOutOfTen = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 2, 10);
        fiveOutOfFifty = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 5, 50);
    }

    /**
     * Getter for the twoOutOfTen tipping numbers.
     * @return the tipping numbers.
     */
    public List<Integer> getTwoOutOfTen() {
        return twoOutOfTen;
    }

    /**
     * Getter for the fiveOutOfFifty tipping numbers.
     * @return the tipping numbers.
     */
    public List<Integer> getFiveOutOfFifty() {
        return fiveOutOfFifty;
    }

    /**
     * {@inheritDoc}
     */
    public void regenerateTippingNumbers() {
        twoOutOfTen = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 2, 10);
        fiveOutOfFifty = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 5, 50);
        System.out.println("Generated tipping numbers for Eurojackpot (2 out of 10): " + getTwoOutOfTen());
        System.out.println("Generated tipping numbers for Eurojackpot (5 out of 50): " + getFiveOutOfFifty());
    }
}
