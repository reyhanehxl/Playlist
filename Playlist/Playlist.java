package Playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist ;
    private User owner;
    Scanner scn = new Scanner(System.in);

    public Playlist(String title, User owner){
        this.setTitle(title);
        this.owner = owner;
        this.playlist = new ArrayList<>();
        owner.addPlaylist(this);
    }
    private void editTitle(String password, String title){
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        this.setTitle(title);
    }
    private void addMusic(String password, Music music){
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }

        for (Music musicX : playlist) {
            if (musicX.equals(music))
                throw new InvalidOperationException(music.title + " by " + music.singer + " already exists in the playlist.");
        }
        playlist.add(music);
        }

    private void removeMusic(String password, Music music){
            if (!owner.getPassword().equals(password)) {
                throw new InvalidOperationException("Invalid password");
            }
            for (Music musicX : playlist) {
                if (musicX.equals(music))
                    playlist.remove(musicX);
            }
    }

    private Music searchInPlaylist(String name){
        for(Music music: playlist){
            if(music.title.equalsIgnoreCase(name)){
                return music;
            }
        }
        return null;
    }
    private Music searchInPlaylist(String name, String singer){
        for(Music music: playlist){
            if(music.title.equalsIgnoreCase(name) && music.singer.getUsername().equalsIgnoreCase(singer)){
                return music;
            }
        }
        return null;
    }
    private void playPlaylist(){
        for(Music music: playlist){
            music.play();
        }
    }
    private void shufflePLayPLaylist(){
        ArrayList<Music> shuffled = new ArrayList<>(playlist);
        Collections.shuffle(shuffled);
        for (Music music : shuffled) {
            music.play();
        }
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new InvalidOperationException("playlist title cannot be empty.");
        }
        this.title = title;
    }
}
