package Task5;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class MusicTitle {
    private String title = "noname";
    private String artist = "noname";

    public MusicTitle(){
        
    }

    public MusicTitle(String title, String artist){
        this.title = title;
        this.artist = artist;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        title = this.title;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        artist = this.artist;
    }
}
