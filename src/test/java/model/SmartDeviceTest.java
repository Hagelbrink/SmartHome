package model;

import exception.DeviceAlreadyActiveException;
import exception.DeviceAlreadyInactiveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.mockito.Mockito.*;

class SmartDeviceTest {

    @Test
    void activateShouldSetDeviceToActive() {
        Lamp lamp = new Lamp(1, "Testlampa");

        lamp.activate();

        assertTrue(lamp.isActive());
        assertNotNull(lamp.getLastActivationDate());
    }

    @Test
    void deactivateShouldSetDeviceToInactive() {
        Lamp lamp = new Lamp(1, "Testlampa");
        lamp.activate();

        lamp.deactivate();

        assertFalse(lamp.isActive());
        assertNotNull(lamp.getLastDeactivationDate());
    }

    @Test
    void activatingAlreadyActiveDeviceShouldThrowException() {
        Lamp lamp = new Lamp(1, "Testlampa");
        lamp.activate();

        assertThrows(DeviceAlreadyActiveException.class, lamp::activate);
    }

    @Test
    void deactivatingInactiveDeviceShouldThrowException() {
        Lamp lamp = new Lamp(1, "Testlampa");

        assertThrows(DeviceAlreadyInactiveException.class, lamp::deactivate);
    }

    @Test
    void activationShouldUseInjectedClock() {
        Clock clock = mock(Clock.class);

        Instant testTime = Instant.parse("2026-10-11T12:00:00Z");
        ZoneId zone = ZoneId.of("Europe/Stockholm");

        when(clock.instant()).thenReturn(testTime);
        when(clock.getZone()).thenReturn(zone);

        Lamp lamp = new Lamp(1, "Testlampa", clock);
        lamp.activate();

        LocalDateTime expectedTime = LocalDateTime.ofInstant(testTime, zone);

        assertEquals(expectedTime, lamp.getInstallationTime());
        assertEquals(expectedTime, lamp.getLastActivationDate());

        verify(clock, atLeast(2)).instant();
    }
}