package Task7;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class VideoReceivable implements Receivable{

    double[] sellingPrices;
    double totalReceivable;
    
    public String generateInvoice(double[] sellingPrices){
        
        for(int i=0; i<sellingPrices.length; i++) {
            totalReceivable = totalReceivable+sellingPrices[i];
        }
        return "Total Receivable for Video Titles: Total Receivable: $"+totalReceivable;
    }

}
