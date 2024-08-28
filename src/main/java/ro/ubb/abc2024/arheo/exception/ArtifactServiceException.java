package ro.ubb.abc2024.arheo.exception;

public class ArtifactServiceException extends RuntimeException{
    public ArtifactServiceException(String message) {
        super(message);
    }

    public ArtifactServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
