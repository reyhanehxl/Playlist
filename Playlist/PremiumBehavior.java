package Playlist;
import java.time.LocalDate;

public class PremiumBehavior implements UserBehavior{
    private LocalDate endDate;
    private User owner;

    public PremiumBehavior(User owner, int month){
        this.owner = owner;
        this.endDate = LocalDate.now().plusMonths(month);
    }
    private void checkPremiumStatus() {
        if (LocalDate.now().isAfter(endDate)) {
            owner.setBehavior(new RegularBehavior());
            throw new InvalidOperationException("Premium expired. Switched back to Regular behavior.");
        }
    }
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
