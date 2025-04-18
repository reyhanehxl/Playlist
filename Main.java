import Playlist.InvalidOperationException;
import Playlist.Music;
import Playlist.RegularBehavior;
import Playlist.User;



        public class Main {
            public static void main(String[] args) {
                try {
                    User user1 = new User("reyhane", "passWord1", new RegularBehavior());
                    System.out.println("Created user: " + user1.getUsername());

                    Music song1 = new Music("Symphony No.5", user1);
                    Music song2 = new Music("Moonlight Sonata", user1);
                    user1.playMusic(song1);
                    user1.playMusic(song2);
                    user1.playMusic(song1);
                    user1.playMusic(song2);
                    user1.playMusic(song1);
                    user1.buyPremium(user1, 2);
                    System.out.println("Upgraded to premium");

                    user1.playMusic(song2);

                    user1.createPlaylist("Sisi's Hits", user1);
                    System.out.println("Playlist created.");

                } catch (InvalidOperationException e) {
                    System.out.println("Operation failed: " + e.getMessage());
                }
            }
        }
