package calculations.expressions;

public interface NumeralExpression {

    String MSG_OUT_OF_RANGE = "%s of %s exceed the applicable range [%s; %s] of %s";

    public double getDecimalValue();

    public void setDecimalValue(double decimalValue);

}