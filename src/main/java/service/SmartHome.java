package service;

import exception.DeviceIdAlreadyExistsException;
import exception.DeviceIdDoesNotExistException;
import exception.DeviceNameDoesNotExistException;
import model.SmartDevice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SmartHome {
    private final Map<Integer, SmartDevice> devices = new HashMap<>();

    public void addDevice(SmartDevice device) {
        if (devices.containsKey(device.getId())) {
            throw new DeviceIdAlreadyExistsException();
        }
        devices.put(device.getId(), device);
    }

    public void removeDevice(int id) {
        if (!devices.containsKey(id)) {
            throw new DeviceIdDoesNotExistException();
        }
        devices.remove(id);
    }

    public SmartDevice searchDeviceById(int id) {
        if (!devices.containsKey(id)) {
            throw new DeviceIdDoesNotExistException();
        }
        return devices.get(id);
    }

    public SmartDevice searchDeviceByName(String name) {
        for (SmartDevice device : devices.values()) {
            if (device.getName().equalsIgnoreCase(name)) {
                return device;
            }
        }
        throw new DeviceNameDoesNotExistException();
    }

    public Collection<SmartDevice> getAllDevices() {
            return devices.values();
    }
}
