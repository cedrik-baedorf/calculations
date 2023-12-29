package calculations.numerals;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum RomanNumeral {

    I('I', 1), V('V', 5), X('X', 10), L('L', 50), C('C', 100), D('D', 500), M('M', 1000);

    public final char CHARACTER;

    public final int VALUE;

    private RomanNumeral(char character, int value) {
        this.CHARACTER = character;
        this.VALUE = value;
    }

    public static Set<Character> characters() {
        return Arrays.stream(values())
                .map(numeral -> numeral.CHARACTER)
                .collect(Collectors.toSet());
    }

    public static Set<Integer> numericValues() {
        return Arrays.stream(values())
                .map(numeral -> numeral.VALUE)
                .collect(Collectors.toSet());
    }

}
