package Playlist;

public class RegularBehavior implements UserBehavior{

    private int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner) {
        throw new InvalidOperationException("Upgrade to premium to create playlists.");
    }

    @Override
    public void playMusic(Music music) {
        if(playingLimit <= 0){
           throw new InvalidOperationException("Limit reached.Upgrade to get more!");
        }
        playingLimit--;
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(owner,month));
    }
}
