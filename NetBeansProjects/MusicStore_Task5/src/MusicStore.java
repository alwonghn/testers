/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

    public MusicStore(MusicTitle[] titles) {
        this.titles = titles;
    }

    public MusicStore(String owner) {
        ownerName = owner;
    }

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

    public MusicTitle[] getTitles(){
        return titles;
    }

    public MusicTitle[] setTitles(MusicTitle[] titles){
        titles = this.titles;
        return titles;
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
            System.out.println("Title "+(i+1)+":");
            System.out.println("Title: "+ titles[i].getTitle());
            System.out.println("Artist: "+ titles[i].getArtist());
        }
    }
}
