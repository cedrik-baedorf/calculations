package calculations.expressions;

import calculations.exceptions.NumeralException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralExpressionTest implements NumeralExpressionTest {

    RomanNumeralExpression expression;

    @BeforeEach
    public void initialize() {
        expression = new RomanNumeralExpression();
    }

    private Map<String, Double> createTestData() {
        return Map.ofEntries(
            Map.entry("I", 1.0),
            Map.entry("V", 5.0),
            Map.entry("X", 10.0),
            Map.entry("L", 50.0),
            Map.entry("C", 100.0),
            Map.entry("D", 500.0),
            Map.entry("M", 1000.0),
            Map.entry("III", 3.0),
            Map.entry("IV", 4.0),
            Map.entry("VI", 6.0),
            Map.entry("IX", 9.0),
            Map.entry("XII", 12.0),
            Map.entry("XIV", 14.0),
            Map.entry("XIX", 19.0),
            Map.entry("XXVII", 27.0),
            Map.entry("XXXIV", 34.0),
            Map.entry("XXXIX", 39.0),
            Map.entry("XL", 40.0),
            Map.entry("VL", 45.0),
            Map.entry("VLII", 47.0),
            Map.entry("IL", 49.0),
            Map.entry("LXI", 61.0),
            Map.entry("LXXVII", 77.0),
            Map.entry("LXXXIX", 89.0),
            Map.entry("XCIV", 94.0),
            Map.entry("CXIII", 113.0),
            Map.entry("CCXLIV", 244.0),
            Map.entry("CDXX", 420.0),
            Map.entry("DCCXLVII", 747.0),
            Map.entry("CMLXXX", 980.0),
            Map.entry("MCCL", 1250.0),
            Map.entry("MMVM", 2995.0),
            Map.entry("MMMDCLXXVIII", 3678.0),
            Map.entry("MMMIM", 3999.0)
        );
    }

    @Test
    public void decimalValue_testAllAllowedValues() {
        NumeralExpressionTest.decimalValue_testSetterAndGetter(expression, RomanNumeralExpression.MIN, RomanNumeralExpression.MAX);
    }

    @Test
    public void setDecimalValue_testBelowRange() {
        NumeralExpressionTest.setDecimalValue_throwsException(expression, NumeralException.class, RomanNumeralExpression.MIN - 1);
    }

    @Test
    public void setDecimalValue_testAboveRange() {
        NumeralExpressionTest.setDecimalValue_throwsException(expression, NumeralException.class, RomanNumeralExpression.MAX + 1);
    }

    @Test
    public void setValue_String_validNumerals() {
        Map<String, Double> testData = createTestData();

        for(Map.Entry<String, Double> entry : testData.entrySet()) {
            expression.setValue(entry.getKey());
            assertEquals(entry.getValue(), expression.getDecimalValue());
        }
    }

    @Test
    public void setValue_String_invalidNumerals() {

    }

    @Test
    public void setValue_RomanNumeralArray_validNumerals() {
        Map<String, Double> testData = createTestData();

        for(Map.Entry<String, Double> entry : testData.entrySet()) {
            expression.setValue(entry.getKey());
            assertEquals(entry.getValue(), expression.getDecimalValue());
        }
    }

    @Test
    public void setValue_RomanNumeralArray_invalidNumerals() {

    }

    @Test
    public void setValue_charArray_validNumerals() {

    }

    @Test
    public void setValue_charArray_invalidNumerals() {

    }

}