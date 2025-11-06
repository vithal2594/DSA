package InterviewPrep.OOPS.workings;


public class UncheckedCustomException extends RuntimeException {
    public UncheckedCustomException() {
        super();
    }
    public UncheckedCustomException(String message) {
        super(message);
    }
    public UncheckedCustomException(String message, Throwable cause) {
        super(message, cause);
    }
    public UncheckedCustomException(Throwable cause) {
        super(cause);
    }
}