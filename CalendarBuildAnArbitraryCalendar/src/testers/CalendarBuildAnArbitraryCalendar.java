/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alfred.wong
 */
public class CalendarBuildAnArbitraryCalendar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println("cal get.Instance is:" + cal);



        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.AM_PM, 0);
        System.out.println("cal.set(Calendar.HOUR, 0) and MINUTE AND SECOND is:" + cal);
    }

}
