package Playlist;

import java.util.ArrayList;

public class Music {
    final String title;
    final User singer;
    private int numberOfStream;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer){
        this.title = title;
        this.singer = singer;
        this.numberOfStream = 0;
        allMusics.add(this);
    }
    private void play(){
        System.out.println("Music: " + this.title + "\nSinger: " + this.singer + "\nPlayed: " + this.numberOfStream);
        this.numberOfStream++;
    }
    private Music search(String name){
        for(Music music : allMusics){
            if(music.title.equalsIgnoreCase(name)){
                return music;
            }
        }
        return null;
    }
    private Music search(String name, String singer){
        for(Music music : allMusics){
            if(music.title.equalsIgnoreCase(name) && music.singer.getUsername().equalsIgnoreCase(singer)){
                return music;
            }
        }
        return null;
    }
}
