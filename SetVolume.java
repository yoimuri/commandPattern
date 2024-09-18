package commandPattern;

public class SetVolume implements Command {
    private MusicPlayer musicPlayer;
    private int volume;

    public SetVolume(MusicPlayer musicPlayer, int volume) {
        this.musicPlayer = musicPlayer;
        this.volume = volume;
    }

    @Override
    public void execute() {
        musicPlayer.setVolume(volume);
    }
}