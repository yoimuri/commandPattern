package commandPattern;

public class TurnOffLight implements Command {
    private Light light;

    public TurnOffLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}