package commandPattern;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<String, Command> commandMap = new HashMap<>();

    public void setCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void executeCommand(String commandName) {
        if (commandMap.containsKey(commandName)) {
            commandMap.get(commandName).execute();
        } else {
            System.out.println("Command not found: " + commandName);
        }
    }
}