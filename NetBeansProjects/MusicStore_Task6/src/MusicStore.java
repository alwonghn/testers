/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.*;
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

    private MusicTitle[] titles = new MusicTitle[2];

    private VideoTitle[] vtitles = new VideoTitle[2];


    public MusicStore(MusicTitle[] titles) {
        this.titles = titles;
    }
    
    public MusicStore(VideoTitle[] vtitles){
        this.vtitles = vtitles;
    }

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

    public MusicTitle[] getTitles() {
        return titles;
    }

    public void setTitles(MusicTitle[] titles) {
        this.titles = titles;
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
        for (int i =0; i<titles.length; i++){
            System.out.println("Music Title "+(i+1)+":");
            System.out.println("Title: "+ titles[i].getTitle());
            System.out.println("Artist: "+ titles[i].getArtist());
            System.out.println("Price: $"+titles[i].getSellingPrice());            
        }
    }

    public void displayVideoTitles() {
        DecimalFormat formatter = new DecimalFormat("$###,###.00");
        for (int i=0; i<vtitles.length; i++){
            System.out.println("Video "+(i+1)+":");
            System.out.println("Title : "+vtitles[i].getTitle());
            System.out.println("Artist : "+vtitles[i].getArtist());
            System.out.println("Director :"+vtitles[i].getDirector());
            //System.out.println("Price: $"+vtitles[i].getSellingPrice());
            System.out.println("Price: "+formatter.format(vtitles[i].getSellingPrice()));
        }
    }
}
