package ro.ubb.abc2024.biology.exception;

public class DataBaseOperationException extends RuntimeException {
    public DataBaseOperationException(String message) {
        super(message);
    }
}