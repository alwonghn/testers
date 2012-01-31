/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class MusicReceivable implements Receivable{

    private double[] sellingPrices;
    private double totalReceivable=0;

    public String generateInvoice(double[] sellingPrices){

        for(int i=0; i<sellingPrices.length; i++) {
            totalReceivable = totalReceivable+sellingPrices[i];
        }
        return "Total Receivable for Music Titles: Total Receivable: $"+totalReceivable;
    }
}
