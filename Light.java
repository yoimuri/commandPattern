package commandPattern;

public class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("The light is turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("The light is turned off.");
    }

    public boolean isOn() {
        return isOn;
    }
}