package com.lotto;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds methods to generate tipping numbers for the 6 out of 49 Lotto game.
 *
 * @author Nicolas Harrje
 */
public class SixOutOfFortyNine implements NumberGenerator {
    List<Integer> tippingNumbers = new ArrayList<>();
    BadLuckNumberHandler badLuckNumberHandler;

    /**
     * This constructor generates tipping numbers for 6 out of 49 under exclusion of the bad luck numbers.
     * @param badLuckNumberHandler among other things holds the bad luck numbers
     */
    public SixOutOfFortyNine(BadLuckNumberHandler badLuckNumberHandler) {
        this.badLuckNumberHandler = badLuckNumberHandler;
        tippingNumbers = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.getBadLuckNumbers(), 6, 49);
    }

    /**
     * Getter for the tipping numbers.
     * @return the tipping numbers
     */
    public List<Integer> getTippingNumbers() {
        return tippingNumbers;
    }

    /**
     * {@inheritDoc}
     */
    public void regenerateTippingNumbers() {
        tippingNumbers = NumberGenerator.generateTippingNumbers(badLuckNumberHandler.badLuckNumbers, 6, 49);
        System.out.println("Generated tipping numbers for 6 out of 49:" + tippingNumbers);
    }
}
