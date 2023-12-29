package calculations.expressions;

import calculations.exceptions.NumeralException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralExpressionTest {

    RomanNumeralExpression expression;

    @BeforeEach
    public void initialize() {
        expression = new RomanNumeralExpression();
    }

    @Test
    public void decimalValue_testAllValues() {
        NumeralExpressionTest.decimalValue_testSetterAndGetter(expression, 1, 3999);
    }

    @Test
    public void setDecimalValue_testWithZero() {
        assertThrowsExactly(NumeralException.class, () -> expression.setDecimalValue(0));
    }

    @Test
    public void setDecimalValue_testWith4000() {
        assertThrowsExactly(NumeralException.class, () -> expression.setDecimalValue(4000));
    }

}