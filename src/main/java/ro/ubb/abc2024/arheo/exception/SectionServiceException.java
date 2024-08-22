package ro.ubb.abc2024.arheo.exception;

public class SectionServiceException extends RuntimeException {
    public SectionServiceException(String message) {
        super(message);
    }

    public SectionServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
