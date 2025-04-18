package Playlist;
import java.time.LocalDate;

public class PremiumBehavior implements UserBehavior{

    private int month;
    LocalDate today = LocalDate.now();
    LocalDate endDate = today.plusMonths(month);

    @Override
    public void createPlaylist(String Title, User Owner) {
        //Owner.addPlaylist(new Playlist());
    }

    @Override
    public void playMusic(Music music) {

    }

    @Override
    public void buyPremium(User owner, int month) {
        endDate.plusMonths(month);
    }
}
