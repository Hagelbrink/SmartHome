package model;

import java.time.Clock;

public class Lamp extends SmartDevice {

    public Lamp(int id, String name) {
        super(id, name);
    }
    public Lamp(int id, String name, Clock clock) {
        super(id, name, clock);
    }
}
