/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

import java.util.Calendar;

/**
 *
 * @author alfred.wong
 */
public class SwitchCaseStatement {

    /**
     * @param args the command line arguments
     */
//    case: switch is an int
//    public static void main(String[] args) {
//        Calendar calTday = Calendar.getInstance();
//        int calDay = calTday.get(Calendar.DAY_OF_WEEK_IN_MONTH);
//        int service_days;
//        switch(calDay){
//            case 1: service_days = 62; break;
//            case 2: service_days = 62; break;
//            case 3: service_days = 62; break;
//            case 4: service_days = 62; break;
//            case 5: service_days = 62; break;
//            case 6: service_days = 1; break;
//            case 7: service_days = 64; break;
//            default: service_days = 62; break;
//        }
//        System.out.println("calTday.get(Calendar.DAY_OF_WEEK_IN_MONTH) :"+calDay+"result is : service_days = "+service_days);
//    }

    public enum Blkids{
        se, sw
    }

    //// case: switch is a string?
    public static void main(String[] args) {
        Blkids blkids = Blkids.se; //switch
        switchBlkIdCode(blkids);
    }

    public static void switchBlkIdCode(Blkids blkids){
        int blkidxx = 0;
        switch(blkids){
            case se: blkidxx = 97; break;//case
            case sw: blkidxx = 98; break;
            default: blkidxx = 98; break;
        }
        System.out.println("when blkids is se,  blkidi should be :"+blkidxx);
    }


}
