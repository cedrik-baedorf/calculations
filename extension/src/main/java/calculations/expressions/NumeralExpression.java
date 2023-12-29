package calculations.expressions;

public interface NumeralExpression {

    String MSG_OUT_OF_RANGE = "%s of %s exceed the applicable range [%s; %s] of %s";

    double getDecimalValue();

    void setDecimalValue(double decimalValue);

}