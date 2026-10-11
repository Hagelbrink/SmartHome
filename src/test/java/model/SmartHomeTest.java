package service;

import exception.DeviceIdAlreadyExistsException;
import exception.DeviceIdDoesNotExistException;
import model.Lamp;
import model.SmartDevice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SmartHomeTest {

    @Test
    void addDeviceShouldMakeItSearchable() {
        SmartHome smartHome = new SmartHome();
        Lamp lamp = new Lamp(1, "Vardagsrum");

        smartHome.addDevice(lamp);

        assertSame(lamp, smartHome.searchDeviceById(1));
    }

    @Test
    void addingDuplicateIdShouldThrowException() {
        SmartHome smartHome = new SmartHome();
        smartHome.addDevice(new Lamp(1, "Lampa 1"));

        assertThrows(DeviceIdAlreadyExistsException.class,
                () -> smartHome.addDevice(new Lamp(1, "Lampa 2")));
    }

    @Test
    void searchingForMissingIdShouldThrowException() {
        SmartHome smartHome = new SmartHome();

        assertThrows(DeviceIdDoesNotExistException.class,
                () -> smartHome.searchDeviceById(99));
    }

    @Test
    void searchByNameShouldIgnoreCase() {
        SmartHome smartHome = new SmartHome();
        Lamp lamp = new Lamp(1, "Vardagsrum");
        smartHome.addDevice(lamp);

        assertSame(lamp, smartHome.searchDeviceByName("VARDAGSRUM"));
    }

    @Test
    void shouldWorkWithMockedDevice() {
        SmartHome smartHome = new SmartHome();

        SmartDevice mockDevice = mock(SmartDevice.class);
        when(mockDevice.getId()).thenReturn(10);
        when(mockDevice.getName()).thenReturn("Mockad lampa");

        smartHome.addDevice(mockDevice);

        assertSame(mockDevice, smartHome.searchDeviceById(10));
        assertSame(mockDevice, smartHome.searchDeviceByName("Mockad lampa"));

        verify(mockDevice, atLeastOnce()).getId();
        verify(mockDevice).getName();
    }
}