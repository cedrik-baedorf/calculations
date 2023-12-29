package calculations.exceptions;

public class NumeralException extends RuntimeException {

    public NumeralException() {
        super();
    }

    public NumeralException(String message) {
        super(message);
    }

    public NumeralException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumeralException(Throwable cause) {
        super(cause);
    }


}