

public class InternalErrorException extends Exception {
    public InternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }
    public InternalErrorException(String message) {
        super(message);
    }
}
