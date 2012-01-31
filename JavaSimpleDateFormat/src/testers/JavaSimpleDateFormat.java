/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alfred.wong
 */
public class JavaSimpleDateFormat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date dateTd = new Date();
        SimpleDateFormat sdfYr = new SimpleDateFormat("yyyy");
        System.out.println("today's year is " + sdfYr.format(dateTd));
        String strYr = sdfYr.format(dateTd);
        System.out.println("today's year is " + strYr);
        SimpleDateFormat sdfyyMMdd = new SimpleDateFormat("yyyyMMdd");
        System.out.println("today's year is " + sdfyyMMdd.format(dateTd));
//        SimpleDateFormat sdfMMM = new SimpleDateFormat("MMM");
//        System.out.println("today's MMM is " + sdfMMM.format(date));
        SimpleDateFormat sdfdd = new SimpleDateFormat("d");
        System.out.println("today's MMM is " + sdfdd.format(dateTd));
        SimpleDateFormat sdfMMM = new SimpleDateFormat("MMM");
        SimpleDateFormat sdfd = new SimpleDateFormat("d");
        String booking_id = sdfMMM.format(dateTd)+sdfd.format(dateTd)+" ";
        System.out.println("generated booking_id is " + booking_id);
    }

}
