package app;

import exception.DeviceAlreadyActiveException;
import model.Lamp;
import model.Camera;
import model.Radiator;
import model.SmartDevice;
import service.SmartHome;

public class Main {
    public static void main(String[] args) {
        SmartHome smartHome = new SmartHome();

        Lamp lamp = new Lamp(1, "Lampa vardagsrum");
        Camera camera = new Camera(2, "Kamera entré");
        Radiator radiator = new Radiator(3, "Radiator sovrum");

        smartHome.addDevice(lamp);
        smartHome.addDevice(camera);
        smartHome.addDevice(radiator);

        lamp.activate();
        camera.activate();
        radiator.activate();
        IO.println(lamp.getName()  + " - aktiv: " +  lamp.isActive());

        lamp.deactivate();
        IO.println(lamp.getName()  + " - aktiv: " +  lamp.isActive());

        SmartDevice foundDevice = smartHome.searchDeviceById(2);
        IO.println("Hittade enhet: " + foundDevice.getName());

        SmartDevice foundDevice2 = smartHome.searchDeviceByName("kamera entré");
        IO.println("Hittade enhet: " + foundDevice2.getId());

        for (SmartDevice device : smartHome.getAllDevices()) {
            IO.println(device.getName() + " - aktiv: " + device.isActive());
            }

        try {
            camera.activate();
        }
        catch (DeviceAlreadyActiveException e) {
            IO.println(e.getMessage());
        }

        smartHome.removeDevice(3);
        IO.println("Antal enheter efter borttagning: " + smartHome.getAllDevices().size());


    }

}
