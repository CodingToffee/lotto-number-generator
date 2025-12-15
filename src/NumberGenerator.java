public interface NumberGenerator {
    /**
     * Generates the numbers to be used for tipping. Ignores numbers that are defined as bad luck numbers.
     * @return A list of integer numbers
     */
    public List<Integer> generateNumbers();

    public boolean validateBadLuckNumbers(String numbers);
}