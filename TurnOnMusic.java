package commandPattern;

public class TurnOnMusic implements Command {
    private MusicPlayer musicPlayer;

    public TurnOnMusic(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.turnOn();
    }
}