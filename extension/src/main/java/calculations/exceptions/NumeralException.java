package calculations.exceptions;

public class NumeralException extends RuntimeException {

    /**
     * Default constructor of {@link NumeralException} calling the constructor
     * <code>super()</code> of {@link RuntimeException}
     */
    public NumeralException() {
        super();
    }

    /**
     * Overloaded constructor of {@link NumeralException} calling the constructor
     * <code>super(message: {@link String})</code> of {@link RuntimeException}
     */
    public NumeralException(String message) {
        super(message);
    }

    /**
     * Overloaded constructor of {@link NumeralException} calling the constructor
     * <code>super(message: {@link String}, cause: {@link Throwable})</code> of {@link RuntimeException}
     */
    public NumeralException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Overloaded constructor of {@link NumeralException} calling the constructor
     * <code>super(cause: {@link Throwable})</code> of {@link RuntimeException}
     */
    public NumeralException(Throwable cause) {
        super(cause);
    }


}