package commandPattern;


import java.util.Scanner;

public class ViewerApp {
    public static void main(String[] args) {
        Controller controller = new Controller();

        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        MusicPlayer musicPlayer = new MusicPlayer();

        controller.setCommand("light_on", new TurnOnLight(light));
        controller.setCommand("light_off", new TurnOffLight(light));

        controller.setCommand("thermostat_set", new SetTemperature(thermostat, 3)); 

        controller.setCommand("music_on", new TurnOnMusic(musicPlayer));
        controller.setCommand("music_off", new TurnOffMusic(musicPlayer));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Current Status ---");
            System.out.println("Light: " + (light.isOn() ? "On" : "Off"));
            System.out.println("Thermostat: " + (thermostat.isOn() ? "On, Level " + thermostat.getTemperatureLevel() : "Off"));
            System.out.println("Music Player: " + (musicPlayer.isOn() ? "On, Playing: " + musicPlayer.getCurrentSong() + ", Volume: " + musicPlayer.getVolume() : "Off"));
            System.out.println("-----------------------");

            System.out.println("Smart Home Automation System");
            System.out.println("Choose device: 1 for Light, 2 for Thermostat, 3 for Music Player");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Turn lights on or off? (on/off):");
                    String lightAction = scanner.nextLine();
                    if (lightAction.equalsIgnoreCase("on")) {
                        controller.executeCommand("light_on");
                    } else if (lightAction.equalsIgnoreCase("off")) {
                        controller.executeCommand("light_off");
                    }
                    break;

                case "2":
                    System.out.println("Turn thermostat on or off? (on/off):");
                    String thermostatAction = scanner.nextLine();
                    if (thermostatAction.equalsIgnoreCase("on")) {
                        thermostat.turnOn();
                        System.out.println("Set temperature level (1 - Coldest, 2 Cold, 3 Room Temperature, 4 Hot 5 - Hottest):");
                        int level = scanner.nextInt();
                        scanner.nextLine(); 
                        controller.setCommand("thermostat_set", new SetTemperature(thermostat, level));
                        controller.executeCommand("thermostat_set");
                    } else if (thermostatAction.equalsIgnoreCase("off")) {
                        thermostat.turnOff();
                    }
                    break;

                case "3":
                    System.out.println("Turn music player on or off? (on/off):");
                    String musicAction = scanner.nextLine();
                    if (musicAction.equalsIgnoreCase("on")) {
                        controller.executeCommand("music_on");
                        System.out.println("Would you like to play a song or set volume? (song/volume):");
                        String musicControl = scanner.nextLine();
                        if (musicControl.equalsIgnoreCase("song")) {
                            System.out.println("Enter the song name:");
                            String song = scanner.nextLine();
                            controller.setCommand("play_song", new PlaySong(musicPlayer, song));
                            controller.executeCommand("play_song");
                        } else if (musicControl.equalsIgnoreCase("volume")) {
                            System.out.println("Set volume (0-100):");
                            int volume = scanner.nextInt();
                            scanner.nextLine();
                            controller.setCommand("set_volume", new SetVolume(musicPlayer, volume));
                            controller.executeCommand("set_volume");
                        }
                    } else if (musicAction.equalsIgnoreCase("off")) {
                        controller.executeCommand("music_off");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("Continue using? (yes/no):");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                System.out.println("Shutting down.");
                break;
            }
        }
        scanner.close();
    }
}