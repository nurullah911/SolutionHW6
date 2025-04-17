package CommandPattern;

import java.util.*;

interface Command {
    void execute();
    void undo();
}

class Light {
    void on()  { System.out.println("[Light] turning ON");  }
    void off() { System.out.println("[Light] turning OFF"); }
}

class Thermostat {
    private int last;
    void set(int temp) {
        last = temp;
        System.out.println("[Thermostat] " + temp + "°C");
    }
    void undo() {
        System.out.println("[Thermostat] revert to " + last + "°C");
    }
}

class TurnOnLight implements Command {
    private Light light;
    TurnOnLight(Light light) { this.light = light; }
    public void execute() { light.on(); }
    public void undo()    { light.off(); }
}

class SetTemp implements Command {
    private Thermostat thermo;
    private int temp;
    SetTemp(Thermostat t, int temp) { this.thermo = t; this.temp = temp; }
    public void execute() { thermo.set(temp); }
    public void undo()    { thermo.undo(); }
}

class Remote {
    private Map<Integer,Command> slots = new HashMap<>();
    private Command last;

    void bind(int slot, Command cmd) { slots.put(slot, cmd); }
    void press(int slot) {
        Command cmd = slots.get(slot);
        if (cmd != null) {
            cmd.execute();
            last = cmd;
        }
    }
    void undo() {
        if (last != null) last.undo();
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Remote remote = new Remote();
        Light light = new Light();
        Thermostat thermo = new Thermostat();

        remote.bind(1, new TurnOnLight(light));
        remote.bind(2, new SetTemp(thermo, 22));

        remote.press(1);
        remote.undo();
        remote.press(2);
        remote.undo();
    }
}
