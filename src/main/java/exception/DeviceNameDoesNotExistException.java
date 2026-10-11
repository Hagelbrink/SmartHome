package exception;

public class DeviceNameDoesNotExistException extends RuntimeException {

    public DeviceNameDoesNotExistException() {
        super("Enhetens namn finns inte.");
    }
}
