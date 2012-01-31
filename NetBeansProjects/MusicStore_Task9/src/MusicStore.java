/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.*;
import java.util.ArrayList;
/**
 *
 * @author alfred.wong
 */
public class MusicStore {
    private String frequency = "Daily";
    private int openTime = 9;
    private int closeTime = 21;
    private String ownerName = "No owner";
    public String operatingHours;
    public String ownerDetails;
    public int hourIntNow;
    public String statusMsg = null;


    private ArrayList<MusicTitle> musicTitles = new ArrayList<MusicTitle>();
    private ArrayList<VideoTitle> videoTitles = new ArrayList<VideoTitle>();
    

//    public MusicStore(String owner) {
//        ownerName = owner;
//    }

    public String getFrequency() {
        return frequency;
    }

    public void setOpen(int open) {
        openTime = open;
    }
    
    public int getOpen() {
        return openTime;
    }
    
    public void setClose(int close) {
        closeTime = close;
    }

    public int getClose() {
        return closeTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public ArrayList<MusicTitle> getMusicTitles() {
        return musicTitles;
    }

    public void setMusicTitles(ArrayList<MusicTitle> musicTitles) {
        this.musicTitles = musicTitles;
    }

    public ArrayList<VideoTitle> getVideoTitles() {
        return videoTitles;
    }

    public void setVideoTitles(ArrayList<VideoTitle> videoTitles) {
        this.videoTitles = videoTitles;
    }
    
    

    public String displayHoursOfOperation() {
        operatingHours = "Store Hours:"+frequency+":    "+openTime+" AM - "+closeTime+" PM";
        return operatingHours;
    }
    
    public String displayOwnerDetails(){
        ownerDetails = ownerName+", Proprietor";
        return ownerDetails;
    }

    private void isOpen() {
        AltDate dateObj = new AltDate();
        hourIntNow = dateObj.getHourInt();
        if(hourIntNow>openTime && hourIntNow<closeTime){
            statusMsg = "We're Open!";
        }
    }
    
    public String getOpenClosedMessage() {
        isOpen();
        if(statusMsg !=null){
            return statusMsg;
        }else{
            return "We're Closed!";
        }
    }
    
    public void displayMusicTitles(){
        for(int i=0; i<musicTitles.size(); i++){
            System.out.println("Music Title "+(i+1)+":");
            System.out.println("Title: "+ musicTitles.get(i).getTitle());
            System.out.println("Artist: "+ musicTitles.get(i).getArtist());
            System.out.println("Price: $"+ musicTitles.get(i).getSellingPrice());
        }
    }

    public void displayVideoTitles() {
        DecimalFormat formatter = new DecimalFormat("$###,###.00");
        for (int i=0; i<videoTitles.size(); i++){
            System.out.println("Video "+(i+1)+":");
            System.out.println("Title : "+videoTitles.get(i).getTitle());
            System.out.println("Artist : "+videoTitles.get(i).getArtist());
            System.out.println("Director :"+videoTitles.get(i).getDirector());
            System.out.println("Price: "+formatter.format(videoTitles.get(i).getSellingPrice()));
        }
    }


}
