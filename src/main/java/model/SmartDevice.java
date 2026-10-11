package model;

import exception.DeviceAlreadyActiveException;
import exception.DeviceAlreadyInactiveException;

import java.time.LocalDateTime;
import java.time.Clock;

public abstract class SmartDevice implements Activatable {
    private final int id;
    private final String name;
    private final LocalDateTime installationTime;
    private LocalDateTime lastActivationDate;
    private LocalDateTime lastDeactivationDate;
    private boolean active;
    private final Clock clock;

    public SmartDevice(int id, String name) {
        this(id, name, Clock.systemDefaultZone());
    }

    protected SmartDevice(int id, String name, Clock clock) {
        this.id = id;
        this.name = name;
        this.clock = clock;
        this.installationTime = LocalDateTime.now(clock);
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


    @Override
    public void activate() {
        if (active) {
            throw new DeviceAlreadyActiveException();
        }
        active = true;
        lastActivationDate = LocalDateTime.now(clock);
    }

    @Override
    public void deactivate() {
        if (!active) {
            throw new DeviceAlreadyInactiveException();
        }
        active = false;
        lastDeactivationDate = LocalDateTime.now(clock);
    }
}
