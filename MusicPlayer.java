package commandPattern;

public class MusicPlayer {
    private int volume = 50; 
    private String currentSong = "None";
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Music player is turned on.");
    }

    public void turnOff() {
        isOn = false;
        currentSong = "None";
        System.out.println("Music player is turned off.");
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            volume = 0;
        } else if (volume > 100) {
            volume = 100;
        }
        this.volume = volume;
        System.out.println("Music player volume set to: " + this.volume);
    }

    public void playSong(String song) {
        if (isOn) {
            currentSong = song;
            System.out.println("Playing song: " + song);
        } else {
            System.out.println("Music player is off. Turn it on to play a song.");
        }
    }

    public String getCurrentSong() {
        return currentSong;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return isOn;
    }
}