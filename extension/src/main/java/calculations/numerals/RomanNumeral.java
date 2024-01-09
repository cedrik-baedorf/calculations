package calculations.numerals;

import calculations.exceptions.NumeralException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum RomanNumeral {

    I('I', 1), V('V', 5), X('X', 10), L('L', 50), C('C', 100), D('D', 500), M('M', 1000);

    public final char CHARACTER;

    public final int VALUE;

    private static final String
        MSG_INVALID_NUMERAL = "%s %s does not match any of the valid values for %s : %s.";

    RomanNumeral(char character, int value) {
        this.CHARACTER = character;
        this.VALUE = value;
    }

    /**
     * This method returns a collection of the symbols of the roman numerals
     * @return {@link Set} of {@link Character} objects
     */
    public static Set<Character> characters() {
        return Arrays.stream(values())
                .map(numeral -> numeral.CHARACTER)
                .collect(Collectors.toSet());
    }

    /**
     * This method returns a collection of the values of the roman numerals
     * @return {@link Set} of {@link Integer} objects
     */
    public static Set<Integer> numericValues() {
        return Arrays.stream(values())
                .map(numeral -> numeral.VALUE)
                .collect(Collectors.toSet());
    }

    /**
     * This static method returns a {@link RomanNumeral} of the <code>character: {@link Character}</code> parameter.
     * If no such {@link RomanNumeral} exists, a {@link NumeralException} shall be thrown.
     * @param character {@link Character} of the {@link RomanNumeral} in question.
     * @return {@link RomanNumeral} of the {@link Character} provided.
     * @throws NumeralException Exception if no corresponding {@link RomanNumeral} is found.
     */
    public static RomanNumeral of(char character) throws NumeralException {
        try {
            return Arrays.stream(values())
                    .filter(numeral -> numeral.CHARACTER == character)
                    .toList()
                    .get(0);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new NumeralException(String.format(MSG_INVALID_NUMERAL, "Numeral", character, "characters", characters()), exception);
        }
    }

    /**
     * This static method returns a {@link RomanNumeral} of the <code>value: {@link Integer}</code> parameter.
     * If no such {@link RomanNumeral} exists, a {@link NumeralException} shall be thrown.
     * @param value {@link Integer} of the {@link RomanNumeral} in question.
     * @return {@link RomanNumeral} of the {@link Integer} provided.
     * @throws NumeralException Exception if no corresponding {@link RomanNumeral} is found.
     */
    public static RomanNumeral of(int value) throws NumeralException {
        try {
            return Arrays.stream(values())
                    .filter(numeral -> numeral.VALUE == value)
                    .toList()
                    .get(0);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new NumeralException(String.format(MSG_INVALID_NUMERAL, "Value", value, "numeric values", numericValues()), exception);
        }
    }

    public static boolean greater(RomanNumeral numeral1, RomanNumeral numeral2) {
        return numeral1.greater(numeral2);
    }

    public boolean greater(RomanNumeral numeral) {
        return this.VALUE > numeral.VALUE;
    }

    public static boolean lesser(RomanNumeral numeral1, RomanNumeral numeral2) {
        return numeral1.lesser(numeral2);
    }

    public boolean lesser(RomanNumeral numeral) {
        return this.VALUE < numeral.VALUE;
    }

    public static boolean equal(RomanNumeral numeral1, RomanNumeral numeral2) {
        return numeral1.equal(numeral2);
    }

    public boolean equal(RomanNumeral numeral) {
        return this.VALUE == numeral.VALUE;
    }

    public static boolean greaterOrEqual(RomanNumeral numeral1, RomanNumeral numeral2) {
        return numeral1.greaterOrEqual(numeral2);
    }

    public boolean greaterOrEqual(RomanNumeral numeral) {
        return this.greater(numeral) || this.equal(numeral);
    }

    public static boolean lesserOrEqual(RomanNumeral numeral1, RomanNumeral numeral2) {
        return numeral1.lesserOrEqual(numeral2);
    }

    public boolean lesserOrEqual(RomanNumeral numeral) {
        return this.lesser(numeral) || this.equal(numeral);
    }

    public static boolean between(RomanNumeral numeral1, RomanNumeral numeral2, RomanNumeral numeral3) {
        return numeral1.between(numeral2, numeral3);
    }

    public boolean between(RomanNumeral numeral1, RomanNumeral numeral2) {
        return
            this.greater(numeral1.greater(numeral2) ? numeral2 : numeral1) &&
            this.lesser(numeral1.lesser(numeral2) ? numeral2 : numeral1);
    }

    public static boolean betweenOrEqual(RomanNumeral numeral1, RomanNumeral numeral2, RomanNumeral numeral3) {
        return numeral1.betweenOrEqual(numeral2, numeral3);
    }

    public boolean betweenOrEqual(RomanNumeral numeral1, RomanNumeral numeral2) {
        return this.between(numeral1, numeral2) || this.equal(numeral1) || this.equal(numeral2);
    }

}
