/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author alfred.wong
 */
public class TestMusicStore {
    
    private double musicSubTtl;
    private double videoSubTtl;
    public static double[] musicSellingPrices = {3.85};
    public static double[] videoSellingPrices = {36.6};

    public static void main(String[] Args){    
        
        ArrayList<MusicTitle> mTitlesListNew = new ArrayList<MusicTitle>();

        MusicTitle mTitle1 = new MusicTitle("Las Cosas Que Vives","Laura Pausini",2.2/1.1);
        mTitlesListNew.add(mTitle1);
        MusicTitle mTitle2 = new MusicTitle("Luna Nueva","Diego Torres",1.65/1.1);
        mTitlesListNew.add(mTitle2);
        MusicTitle mTitle3 = new MusicTitle("Bitter Heart","Zee Avi", 3.3/1.1);
        mTitlesListNew.add(mTitle3);

        ArrayList<VideoTitle> vTitlesListNew = new ArrayList<VideoTitle>();

        VideoTitle vTitle1 = new VideoTitle("Flags of our father", "Clint Eastwood", 22.50/1.2);
        vTitlesListNew.add(vTitle1);
        VideoTitle vTitle2 = new VideoTitle("Letter from Iwo Jima","Ken Watanabe", "Clint Eastwood", 51.90/1.2);
        vTitlesListNew.add(vTitle2);
        VideoTitle vTitle3 = new VideoTitle("The Gauntlet", "Sondra Locke", "Clint Eastwood", 31.60/1.2);
        vTitlesListNew.add(vTitle3);

        MusicStore store = new MusicStore();

        store.setMusicTitles(mTitlesListNew);
        store.displayMusicTitles();

        store.setVideoTitles(vTitlesListNew);
        store.displayVideoTitles();

        System.exit(0);
    }
}
