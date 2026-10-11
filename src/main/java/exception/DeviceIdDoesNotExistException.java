package exception;

public class DeviceIdDoesNotExistException extends RuntimeException {

    public DeviceIdDoesNotExistException() {
        super("EnhetsID finns inte.");
    }
}
