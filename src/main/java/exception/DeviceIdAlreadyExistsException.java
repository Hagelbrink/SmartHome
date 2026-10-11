package exception;

public class DeviceIdAlreadyExistsException extends RuntimeException {

    public DeviceIdAlreadyExistsException() {
        super("EnhetsID finns redan.");
    }
}
