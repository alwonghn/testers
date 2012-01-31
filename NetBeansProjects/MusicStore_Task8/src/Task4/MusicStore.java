package Task4;

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
    public String string;

    public MusicStore() {

    }

    public MusicStore(String owner) {
        ownerName = owner;
    }

    public String getFrequency() {
        return frequency;
    }
    
    public int getOpen() {
        return openTime;
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
    
    public String displayHoursOfOperation() {
        toString();
        return string;
    }
        
    @Override
    public String toString(){
        string = "[owner = "+ownerName+", "+"opens = "+openTime+", "+"closes = "+closeTime+"]";
        return(string);
    }
}
