package Task6;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class MusicTitle extends Title{
    private String title;
    private String artist;
    private double purchasePrice = 0;
    private double sellingPrice =0;

    public MusicTitle(String title, String artist, double purchasePrice){
        this.setTitle(title);
        this.setArtist(artist);
        this.purchasePrice = purchasePrice;
    }

    @Override
    public double getSellingPrice(){
        sellingPrice = purchasePrice*1.1;
        return sellingPrice;
    }

}
