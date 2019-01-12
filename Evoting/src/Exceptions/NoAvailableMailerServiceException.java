package Exceptions;

public class NoAvailableMailerServiceException extends Exception {
    public NoAvailableMailerServiceException(String msg) {
        super(msg);
    }
}
