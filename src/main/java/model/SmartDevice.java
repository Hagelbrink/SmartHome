package model;

import exception.DeviceAlreadyActiveException;
import exception.DeviceAlreadyInactiveException;

import java.time.LocalDateTime;

public abstract class SmartDevice {
    private final int id;
    private final String name;
    private final LocalDateTime installationTime;
    private LocalDateTime lastActivationDate;
    private LocalDateTime lastDeactivationDate;
    private boolean active;

    public SmartDevice(int id, String name) {
        this.id = id;
        this.name = name;
        this.installationTime = LocalDateTime.now();
        this.active = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getInstallationTime() {
        return installationTime;
    }

    public LocalDateTime getLastActivationDate() {
        return lastActivationDate;
    }

    public LocalDateTime getLastDeactivationDate() {
        return lastDeactivationDate;
    }

    public boolean isActive() {
        return active;
    }


    public void activate() {
        if (active) {
            throw new DeviceAlreadyActiveException();
        }
        active = true;
        lastActivationDate = LocalDateTime.now();
    }

    public void deactivate() {
        if (!active) {
            throw new DeviceAlreadyInactiveException();
        }
        active = false;
        lastDeactivationDate = LocalDateTime.now();
    }
}
