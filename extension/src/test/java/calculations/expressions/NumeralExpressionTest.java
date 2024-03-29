package calculations.expressions;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public interface NumeralExpressionTest {

    private static void decimalValue_testSetterAndGetter(RomanNumeralExpression expression, double value) {
        assertDoesNotThrow(() -> expression.setDecimalValue(value));
        assertDoesNotThrow(() -> assertEquals(value, expression.getDecimalValue()));
    }

    static void decimalValue_testSetterAndGetter(RomanNumeralExpression expression, int min, int max) {
        for(int i = min; i <= max; i++)
            decimalValue_testSetterAndGetter(expression, i);
    }

    static void decimalValue_testSetterAndGetter(RomanNumeralExpression expression, Set<Integer> values) {
        for(int i : values)
            decimalValue_testSetterAndGetter(expression, i);
    }

    static void setDecimalValue_throwsException(
        RomanNumeralExpression expression,
        Class<? extends Exception> exception,
        int value
    ) {
        assertThrowsExactly(exception, () -> expression.setDecimalValue(value));
    }

    @Test
    void decimalValue_testAllAllowedValues();

    @Test
    void setDecimalValue_testBelowRange();

    @Test
    void setDecimalValue_testAboveRange();

}