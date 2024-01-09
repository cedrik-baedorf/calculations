package calculations.expressions;

import calculations.exceptions.NumeralException;
import calculations.numerals.RomanNumeral;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public RomanNumeralExpression() {
        this.decimalValue = 0;
    }

    /**
     * This constructor shall set the value of the {@link RomanNumeralExpression}
     * to the value of the <code>numeralExpression: {@link String}</code> parameter by calling the
     * method <code>setValue(numeralExpression: {@link String}): void</code>.
     * If the {@link String} does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numeralExpression expression of a roman numeral
     * @throws NumeralException exception if the expression is falsely
     */
    public RomanNumeralExpression(String numeralExpression) throws NumeralException {
        this.setValue(numeralExpression);
    }

    /**
     * This method shall set the value of the {@link RomanNumeralExpression}
     * to the value of the <code>numerals: {@link Character}[]</code> parameter by calling the
     * method <code>setValue(numerals: {@link RomanNumeral}[]): void</code>.
     * If the {@link Character}[] does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numerals array of roman numerals
     * @throws NumeralException exception if the array is falsely
     */
    public RomanNumeralExpression(RomanNumeral... numerals) throws NumeralException {
        this.setValue(numerals);
    }

    /**
     * This method shall set the value of the {@link RomanNumeralExpression}
     * to the value of the <code>numerals: {@link Character}[]</code> parameter by calling the
     * method <code>setValue(numerals: {@link Character}[]): void</code>.
     * If the {@link Character}[] does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numerals array of roman numerals
     * @throws NumeralException exception if the array is falsely
     */
    public RomanNumeralExpression(char... numerals) throws NumeralException {
        this.setValue(numerals);
    }

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
     * to the value of the <code>numeralExpression: {@link String}</code> parameter.
     * If the {@link String} does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numeralExpression expression of a roman numeral
     * @throws NumeralException exception if the expression is falsely
     */
    public void setValue(String numeralExpression) throws NumeralException {
        this.setValue(numeralExpression.chars()
            .mapToObj(character -> RomanNumeral.of((char) character))
            .toArray(RomanNumeral[]::new)
        );
    }

    /**
     * This method shall set the value of the {@link RomanNumeralExpression}
     * to the value of the <code>numerals: {@link Character}[]</code> parameter.
     * If the {@link Character}[] does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numerals array of roman numerals
     * @throws NumeralException exception if the array is falsely
     */
    public void setValue(RomanNumeral... numerals) throws NumeralException {
        if(! RomanNumeralExpression.isValidExpression(numerals))
            throw new NumeralException("invalid expression");

        List<Integer> values = Arrays.stream(numerals).map(numeral -> numeral.VALUE).collect(Collectors.toList());

        this.decimalValue = evaluate(values);
    }

    private static int evaluate(List<Integer> values) {
        if(values.size() == 1)
            return values.get(0);
        if(inOrder(values))
            return sum(values);
        IntStream.range(0, values.size() - 1)
            .filter(i -> values.get(i) < values.get(i + 1))
            .findFirst()
            .ifPresent(i -> {
                values.set(i, values.get(i + 1) - values.get(i));
                values.remove(i + 1);
            });
        return evaluate(values);
    }

    private static boolean inOrder(List<Integer> values) {
        return values == null || values.isEmpty() ||
                IntStream.range(0, values.size() - 1)
                    .allMatch(i -> values.get(i) >= values.get(i + 1));
    }

    private static int sum(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * This method shall set the value of the {@link RomanNumeralExpression}
     * to the value of the <code>numerals: {@link Character}[]</code> parameter.
     * If the {@link Character}[] does not match the rules of roman numerals,
     * a {@link NumeralException} shall be thrown
     * @param numerals array of roman numerals
     * @throws NumeralException exception if the array is falsely
     */
    public void setValue(char... numerals) throws NumeralException {
        this.setValue(new String(numerals));
    }

    /**
     * This method shall check the provided {@link String} if it fulfills the
     * rules for a valid {@link RomanNumeralExpression}
     * @param numeralExpression expression to be checked
     * @return <code>true</code> if the expression provided is valid
     */
    public static boolean isValidExpression(String numeralExpression) {
        //TODO
        //check if no expression is provided
        if(numeralExpression == null || numeralExpression.isEmpty())
            return false;

        //check if more than three numerals of the same type in a row
        if(numeralExpression.matches(".*(.)\\1\\1\\1.*"))
            return false;

        //check that all numerals match the accepted roman numerals
        if(! numeralExpression.chars().allMatch(c -> RomanNumeral.characters().contains((char) c)))
            return false;

        List<Integer> values = numeralExpression.chars()
                .mapToObj(c -> RomanNumeral.of((char) c).VALUE)
                .collect(Collectors.toList());

        //check if the numerals are in descending order
        if(inOrder(values))
            return true;

        //check if subtracting numerals are in correct order
        for(int i = 0; i < values.size() - 1; i++) {
            if(values.get(i) >= values.get(i + 1))
                continue;
            else if(! RomanNumeral.numericValues().containsAll(Set.of(values.get(i), values.get(i + 1))))
                return false;
            values.set(i, values.get(i + 1) - values.get(i));
            values.remove(i + 1);
            i = -1;
        }

        return true;
    }

    /**
     * This method shall check the provided {@link RomanNumeral}[] if it fulfills the
     * rules for a valid {@link RomanNumeralExpression}
     * @param numerals expression to be checked
     * @return <code>true</code> if the expression provided is valid
     */
    public static boolean isValidExpression(RomanNumeral... numerals) {
        return isValidExpression(
            Arrays.stream(numerals)
                .map(numeral -> String.valueOf(numeral.CHARACTER))
                .collect(Collectors.joining())
        );
    }

    /**
     * This method shall check the provided {@link Character}[] if it fulfills the
     * rules for a valid {@link RomanNumeralExpression}
     * @param numerals expression to be checked
     * @return <code>true</code> if the expression provided is valid
     */
    public static boolean isValidExpression(char... numerals) {
        return isValidExpression(new String(numerals));
    }

}
