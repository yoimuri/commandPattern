package commandPattern;

public class SetTemperature implements Command {
    private Thermostat thermostat;
    private int temperatureLevel;

    public SetTemperature(Thermostat thermostat, int temperatureLevel) {
        this.thermostat = thermostat;
        this.temperatureLevel = temperatureLevel;
    }

    public void execute() {
        thermostat.setTemperature(temperatureLevel);
    }
}