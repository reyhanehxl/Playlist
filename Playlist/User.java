package Playlist;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList;
    private ArrayList<User> followingList;
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists;
    static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password, UserBehavior behavior){
        this.setUsername(username);
        this.setPassword(password);
        this.behavior = new RegularBehavior();
        this.playlists = new ArrayList<>();
        this.followerList = new ArrayList<>();
        this.followingList = new ArrayList<>();
        allUsers.add(this);
    }
    void addPlaylist(Playlist playlist){
        playlists.add(playlist);
    }
    private void follow (User user){
        this.followingList.add(user);
        user.followerList.add(this);
    }
    public void createPlaylist(String title){
        this.behavior.createPlaylist(title,this);
    }
    public void playMusic(Music music){
        this.behavior.playMusic(music);
    }
    public void buyPremium( int month){
        this.behavior.buyPremium(this, month);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username == null || username.isEmpty()){
            throw new InvalidOperationException("Username cannot be empty.");
        }
        if(username.length() <= 2){
            throw new InvalidOperationException("Username must be at least 3 characters long.");
        }
        for(User user: allUsers){
            if(user.username.equals(username))
                throw new InvalidOperationException("This username is already taken.");
        }
        boolean hasLetter = false;
        for(char c : username.toCharArray()){
            if(Character.isLetter(c)){
                hasLetter = true;
                break;
            }
        }
        if(hasLetter == false){
            throw new InvalidOperationException("Username must contain at least one letter and cannot be all numbers.");
        }
        this.username = username;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        if(password.length() < 8){
            throw new InvalidOperationException("Password must be at least 8 characters long.");
        }
        boolean hasLetter = false;
        boolean hasDigit = false;
        for(char c : password.toCharArray()){
            if(Character.isLetter(c))
                hasLetter = true;
            else if(Character.isDigit(c))
                hasDigit = true;
        }
        if(hasLetter == false || hasDigit == false)
            throw new InvalidOperationException("Password must contain both letters and numbers.");

        this.password = password;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }
}