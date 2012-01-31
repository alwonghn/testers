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
        MusicStore store = new MusicStore("Carlos Valderrama");
        String output = store.displayHoursOfOperation();
        System.out.println(output);
    }
}
