package exception;

public class DeviceAlreadyActiveException extends RuntimeException {

    public DeviceAlreadyActiveException() {
        super("Enhet är redan aktiverad.");
    }
}
