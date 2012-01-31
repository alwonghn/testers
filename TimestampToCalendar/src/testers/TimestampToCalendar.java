/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**http://stackoverflow.com/questions/230126/how-to-handle-calendar-timezones-using-java
 * http://stackoverflow.com/questions/230126/how-to-handle-calendar-timezones-using-java
 * @author alfred.wong
 */
public class TimestampToCalendar {

    
    public static Timestamp getATs(){
        Calendar calSomeDay = Calendar.getInstance();
        calSomeDay.set(Calendar.DAY_OF_MONTH,1);
        calSomeDay.set(Calendar.HOUR_OF_DAY, 0);
        calSomeDay.set(Calendar.MINUTE, 0);
        calSomeDay.set(Calendar.MILLISECOND, 0);
        Date dt = calSomeDay.getTime();
        Timestamp ts = new Timestamp(dt.getTime());
        return ts;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Timestamp ts = getATs();
        System.out.println("Timestamp obtained" + ts);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(ts.getTime());
        System.out.println("Calendar obtained from cal.setTimeInMillis(ts.getTime())" + cal);
        cal.add(Calendar.MONTH, -1);
        System.out.println("Abbrv Calendar obtained from cal.setTimeInMillis(ts.getTime()) with one month subtracted: " + cal );
    }

}
