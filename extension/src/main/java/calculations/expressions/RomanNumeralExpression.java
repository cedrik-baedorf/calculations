package calculations.expressions;

import calculations.exceptions.NumeralException;
import calculations.numerals.RomanNumeral;

public class RomanNumeralExpression implements NumeralExpression {

    /**
     * These constants represent the allowed range derived from the rules of roman numerals
     */
    public static final int
        MIN = 1,
        MAX = 3999;

    /**
     * This {@link Integer} stores the numeric value of this roman numeral
     */
    private int decimalValue;

    @Override
    public double getDecimalValue() {
        return decimalValue;
    }

    @Override
    public void setDecimalValue(double decimalValue) {
        if(decimalValue < MIN || decimalValue > MAX)
            throw new NumeralException(String.format(NumeralExpression.MSG_OUT_OF_RANGE,
                "decimalValue",
                decimalValue,
                MIN,
                MAX,
                this.getClass()
            ));

        this.decimalValue = (int) decimalValue;
    }

    /**
     * This method shall set the value of the {@link RomanNumeralExpression}
     * to the value of the <code>numeral: {@link String}</code> parameter.
     * If the {@link String} does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numeral expression of a roman numeral
     * @throws NumeralException exception if the expression is falsely
     */
    public void setValue(String numeral) throws NumeralException {
        //TODO
    }

    /**
     * This method shall set the value of the {@link RomanNumeralExpression}
     * to the value of the <code>numerals: {@link Character}[]</code> parameter.
     * If the {@link Character}[] does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numerals array of roman numerals
     * @throws NumeralException exception if the array is falsely
     */
    public void setValue(RomanNumeral[] numerals) throws NumeralException {
        //TODO
    }

    /**
     * This method shall set the value of the {@link RomanNumeralExpression}
     * to the value of the <code>numerals: {@link Character}[]</code> parameter.
     * If the {@link Character}[] does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numerals array of roman numerals
     * @throws NumeralException exception if the array is falsely
     */
    public void setValue(char[] numerals) throws NumeralException {
        //TODO
    }

}
