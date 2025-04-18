package Playlist;
import java.time.LocalDate;

public class PremiumBehavior implements UserBehavior{

    private int month;
    LocalDate today = LocalDate.now();
    LocalDate endDate = today.plusMonths(month);

    @Override
    public void createPlaylist(String title, User Owner) {
        Playlist playlist = new Playlist(title, Owner);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        endDate.plusMonths(month);
    }
}
