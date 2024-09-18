package commandPattern;

public class PlaySong implements Command {
    private MusicPlayer musicPlayer;
    private String song;

    public PlaySong(MusicPlayer musicPlayer, String song) {
        this.musicPlayer = musicPlayer;
        this.song = song;
    }

    @Override
    public void execute() {
        musicPlayer.playSong(song);
    }
}