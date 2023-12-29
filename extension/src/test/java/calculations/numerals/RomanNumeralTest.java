package calculations.numerals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralTest {

    private static void testCharacterPassing(RomanNumeral numeral, char expectedChar) {
        int actualChar = numeral.CHARACTER;

        assertEquals(expectedChar, actualChar);
    }

    private static void testNumericValuePassing(RomanNumeral numeral, int expectedValue) {
        int actualValue = numeral.VALUE;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void constructor_testCharacterPassing() {
        testCharacterPassing(RomanNumeral.I, 'I');
        testCharacterPassing(RomanNumeral.V, 'V');
        testCharacterPassing(RomanNumeral.X, 'X');
        testCharacterPassing(RomanNumeral.L, 'L');
        testCharacterPassing(RomanNumeral.C, 'C');
        testCharacterPassing(RomanNumeral.D, 'D');
        testCharacterPassing(RomanNumeral.M, 'M');
    }

    @Test
    public void constructor_testNumericValuePassing() {
        testNumericValuePassing(RomanNumeral.I, 1);
        testNumericValuePassing(RomanNumeral.V, 5);
        testNumericValuePassing(RomanNumeral.X, 10);
        testNumericValuePassing(RomanNumeral.L, 50);
        testNumericValuePassing(RomanNumeral.C, 100);
        testNumericValuePassing(RomanNumeral.D, 500);
        testNumericValuePassing(RomanNumeral.M, 1000);
    }

    @Test
    public void characters_testCorrectCharacters() {
        Set<Character> expectedSet = Set.of('I', 'V', 'X', 'L', 'C', 'D', 'M');

        Set<Character> actualSet = RomanNumeral.characters();

        assertEquals(expectedSet, actualSet);
    }

    @Test
    public void characters_testCorrectNumericValues() {
        Set<Integer> expectedSet = Set.of(1, 5, 10, 50, 100, 500, 1000);

        Set<Integer> actualSet = RomanNumeral.numericValues();

        assertEquals(expectedSet, actualSet);
    }

    @Test
    public void testCorrectNumeralValueMapping() {
        Map<Character, Integer> expectedMap = Map.of(
            'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        Map<Character, Integer> actualMap = Arrays.stream(RomanNumeral.values())
            .collect(Collectors.toMap(
                numeral -> numeral.CHARACTER,
                numeral -> numeral.VALUE
            ));

        assertEquals(expectedMap, actualMap);
    }

}