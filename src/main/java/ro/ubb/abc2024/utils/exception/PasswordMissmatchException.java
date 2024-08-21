package ro.ubb.abc2024.utils.exception;

public class PasswordMissmatchException extends RuntimeException {
    public PasswordMissmatchException() {
    }

    public PasswordMissmatchException(String message) {
        super(message);
    }

    public PasswordMissmatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
