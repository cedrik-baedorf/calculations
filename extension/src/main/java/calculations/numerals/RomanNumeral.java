package calculations.numerals;

import calculations.exceptions.NumeralException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum RomanNumeral {

    I('I', 1), V('V', 5), X('X', 10), L('L', 50), C('C', 100), D('D', 500), M('M', 1000);

    public final char CHARACTER;

    public final int VALUE;

    private final String
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

    public static RomanNumeral of(char character) {
        try {
            return Arrays.stream(values())
                    .filter(numeral -> numeral.CHARACTER == character)
                    .toList()
                    .get(0);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new NumeralException(String.format("Numeral", character, "characters", characters()), exception);
        }
    }

    public static RomanNumeral of(int value) {
        try {
            return Arrays.stream(values())
                    .filter(numeral -> numeral.VALUE == value)
                    .toList()
                    .get(0);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new NumeralException(String.format("Value", value, "numeric values", numericValues()), exception);
        }
    }

}
