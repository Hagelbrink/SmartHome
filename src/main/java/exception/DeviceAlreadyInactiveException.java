package exception;

public class DeviceAlreadyInactiveException extends RuntimeException {

    public DeviceAlreadyInactiveException() {
        super("Enhet är redan inaktiverad.");
    }
}
