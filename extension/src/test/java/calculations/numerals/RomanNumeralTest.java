package calculations.numerals;

import calculations.exceptions.NumeralException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
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

    private static Map<Character, RomanNumeral> createCharacterMap() {
        return Map.of(
            'I', RomanNumeral.I,
            'V', RomanNumeral.V,
            'X', RomanNumeral.X,
            'L', RomanNumeral.L,
            'C', RomanNumeral.C,
            'D', RomanNumeral.D,
            'M', RomanNumeral.M
        );
    }

    private static Map<Integer, RomanNumeral> createValueMap() {
        return Map.of(
                1, RomanNumeral.I,
                5, RomanNumeral.V,
                10, RomanNumeral.X,
                50, RomanNumeral.L,
                100, RomanNumeral.C,
                500, RomanNumeral.D,
                1000, RomanNumeral.M
        );
    }

    @Test
    public void constructor_testCharacterPassing() {
        for(Map.Entry<Character, RomanNumeral> entry : createCharacterMap().entrySet())
            testCharacterPassing(entry.getValue(), entry.getKey());
    }

    @Test
    public void constructor_testNumericValuePassing() {
        for(Map.Entry<Integer, RomanNumeral> entry : createValueMap().entrySet())
            testNumericValuePassing(entry.getValue(), entry.getKey());
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

    @Test
    public void of_char_testWithValidCharacter() {
        for(Map.Entry<Character, RomanNumeral> entry : createCharacterMap().entrySet())
            assertEquals(entry.getValue(), RomanNumeral.of(entry.getKey()));
    }

    @Test
    public void of_char_testWithInvalidCharacter() {
        Set<Character> characters = new HashSet<>();
        for(int i = 0; i < 200; i++) {
            characters.add((char) i);
        }
        characters.removeAll(RomanNumeral.characters());
        for(char character : characters)
            assertThrowsExactly(NumeralException.class, () -> RomanNumeral.of(character));
    }

    @Test
    public void of_int_testWithValidCharacter() {
        for(Map.Entry<Integer, RomanNumeral> entry : createValueMap().entrySet())
            assertEquals(entry.getValue(), RomanNumeral.of(entry.getKey()));
    }

    @Test
    public void of_int_testWithInvalidCharacter() {
        Set<Integer> values = new HashSet<>();
        for(int i = 0; i < 1000; i++) {
            values.add(i);
        }
        values.removeAll(RomanNumeral.numericValues());
        for(int value : values)
            assertThrowsExactly(NumeralException.class, () -> RomanNumeral.of(value));
    }

}