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
        
        // Part1
        MusicTitle[] mtitlesNew = new MusicTitle[2];
        mtitlesNew[0] = new MusicTitle("Las Cosas Que Vives","Laura Pausini",1.50/1.1);
        mtitlesNew[1] = new MusicTitle("Luna Nueva","Diego Torres",1.00/1.1);
        MusicStore store1 = new MusicStore(mtitlesNew);
        store1.displayMusicTitles();
        // Part2
        VideoTitle[] vtitlesNew = new VideoTitle[2];
        vtitlesNew[0] =  new VideoTitle("Flags of our father", "Clint Eastwood", 20.50/1.2);
        vtitlesNew[1] =  new VideoTitle("Letter from Iwo Jima","Ken Watanabe", "Clint Eastwood", 31.90/1.2);
        MusicStore store2 = new MusicStore(vtitlesNew);
        store2.displayVideoTitles();
        System.exit(0);
    }
}
