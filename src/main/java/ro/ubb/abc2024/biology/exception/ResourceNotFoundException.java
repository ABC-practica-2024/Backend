package ro.ubb.abc2024.biology.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public ResourceNotFoundException(final String message, Throwable cause) {
        super(message, cause);
    }
}