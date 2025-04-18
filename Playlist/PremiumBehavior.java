package Playlist;
import java.time.LocalDate;

public class PremiumBehavior implements UserBehavior{

    private int month;
    LocalDate today = LocalDate.now();
    LocalDate endDate = today.plusMonths(month);

    @Override
    public void createPlaylist(String Title, User Owner) {
        Playlist playlist = new Playlist(title, Owner);
        Owner.addPlaylist(playlist);
    }

    @Override
    public void playMusic(Music music) {

    }

    @Override
    public void buyPremium(User owner, int month) {
        endDate.plusMonths(month);
    }
}
