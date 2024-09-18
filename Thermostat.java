package commandPattern;

public class Thermostat {
    private int temperatureLevel = 3; 
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Thermostat is turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Thermostat is turned off.");
    }

    public void setTemperature(int level) {
        if (level >= 1 && level <= 5) {
            temperatureLevel = level;
            System.out.println("Thermostat set to level: " + temperatureLevel);
        } else {
            System.out.println("Invalid level. Please select a level between 1 and 5.");
        }
    }

    public int getTemperatureLevel() {
        return temperatureLevel;
    }

    public boolean isOn() {
        return isOn;
    }
}