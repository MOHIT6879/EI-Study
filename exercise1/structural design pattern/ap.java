// Old Media Player Interface
interface OldMediaPlayer {
    void playOldMedia(String file);
}

// New Media Player Interface
interface NewMediaPlayer {
    void play(String filename);
}

// Adapter Class
class MediaAdapter implements NewMediaPlayer {
    private OldMediaPlayer oldPlayer;

    public MediaAdapter(OldMediaPlayer oldPlayer) {
        this.oldPlayer = oldPlayer;
    }

    @Override
    public void play(String filename) {
        oldPlayer.playOldMedia(filename);
    }
}

// Old Media Player Implementation
class OldMediaPlayerImpl implements OldMediaPlayer {
    @Override
    public void playOldMedia(String file) {
        System.out.println("Playing old media file: " + file);
    }
}

// Usage
public class ap {
    public static void main(String[] args) {
        OldMediaPlayer oldPlayer = new OldMediaPlayerImpl();
        NewMediaPlayer adapter = new MediaAdapter(oldPlayer);

        adapter.play("song.mp3"); // Playing old media file: song.mp3
    }
}
