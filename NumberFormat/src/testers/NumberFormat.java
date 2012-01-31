/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.text.DecimalFormat;

/**
 *
 * @author alfred.wong
 */
public class NumberFormat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat decifmtr = new DecimalFormat("00");
//        String fmNoStr = decifmtr.format(0);
        String fmNoStr = decifmtr.format(3);
        System.out.println(fmNoStr);
    }

}
