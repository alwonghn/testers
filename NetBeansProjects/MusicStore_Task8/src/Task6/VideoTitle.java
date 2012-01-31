package Task6;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class VideoTitle extends Title {
    private String title;
    private String artist;
    private double purchasePrice;
    private double sellingPrice;
    private String director = "noname";

    public VideoTitle(){

    }

    public VideoTitle(String title, String director, double purchasePrice){
        this.setTitle(title);
        setArtist("Dont quite know");
        this.setDirector(director);
        this.purchasePrice = purchasePrice;
    }

    public VideoTitle(String title, String artist, String director, double purchasePrice){
        this.setTitle(title);
        this.setArtist(artist);
        this.setDirector(director);
        this.purchasePrice = purchasePrice;
    }

    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }

    @Override
    public double getSellingPrice(){
        sellingPrice = purchasePrice*1.2;
        return sellingPrice;
    }
}
