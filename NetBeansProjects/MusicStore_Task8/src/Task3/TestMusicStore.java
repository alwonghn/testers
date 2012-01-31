package Task3;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class TestMusicStore {
    public static void main(String[] Args){
        MusicStore store = new MusicStore("Roberto Baggio");
        String message = store.getOpenClosedMessage();
        String storeHours = store.displayHoursOfOperation();
        String ownerDetails = store.displayOwnerDetails();

        // output
        System.out.println(message);
        System.out.println("Store Hours:");
        System.out.println(storeHours);
        System.out.println(ownerDetails);
    }
}
