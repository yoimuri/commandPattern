package commandPattern;

public class TurnOffMusic implements Command {
    private MusicPlayer musicPlayer;

    public TurnOffMusic(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.turnOff();
    }
}