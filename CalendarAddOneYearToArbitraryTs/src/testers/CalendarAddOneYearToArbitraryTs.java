/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alfred.wong
 */
public class CalendarAddOneYearToArbitraryTs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar startDayArbitraryCal = Calendar.getInstance();
        startDayArbitraryCal.set(Calendar.YEAR, 1977);
        startDayArbitraryCal.set(Calendar.MONTH, 0);
        startDayArbitraryCal.set(Calendar.DAY_OF_MONTH, 1);
        startDayArbitraryCal.set(Calendar.HOUR_OF_DAY, 0);
        startDayArbitraryCal.set(Calendar.MINUTE, 0);
        startDayArbitraryCal.set(Calendar.MILLISECOND, 0);
        System.out.println(" startDateArbitraryCal : "+startDayArbitraryCal);
        Timestamp startDayArbitraryTs = new Timestamp(startDayArbitraryCal.getTime().getTime());
        System.out.println(" startDateArbitraryTs : "+startDayArbitraryTs);

        //get and add
        startDayArbitraryCal.set(Calendar.YEAR, startDayArbitraryCal.get(Calendar.YEAR)+1);
        System.out.println(" startDateArbitraryCal Plus One Year : "+startDayArbitraryCal);
        Timestamp startDayArbitraryTs2 = new Timestamp(startDayArbitraryCal.getTime().getTime());
        System.out.println(" startDateArbitraryTs : "+startDayArbitraryTs2);



        // start from a calendar
        Calendar cal = Calendar.getInstance();





        Date dateNow = new Date();


        cal.setTime(dateNow);
        System.out.println("cal.setTime(dateNow) is:" + cal);

    }

}
