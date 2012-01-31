package Task7;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
        
        MusicReceivable musicInv = new MusicReceivable();
        String musicStatement = musicInv.generateInvoice(musicSellingPrices);
        System.out.println(musicStatement);
        VideoReceivable videoInv = new VideoReceivable();
        String videoStatement = videoInv.generateInvoice(videoSellingPrices);
        System.out.println(videoStatement);
        System.exit(0);
    }
}
