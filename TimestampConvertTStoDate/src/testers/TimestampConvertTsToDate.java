/*
 * http://www.coderanch.com/t/394408/java/java/convert-timestamp-date
 * 
 */

package testers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * http://www.coderanch.com/t/394408/java/java/convert-timestamp-date
 * @author alfred.wong
 */
public class TimestampConvertTsToDate {
    
    public static Date convertTsToDate(Timestamp ts){
       Date date = new Date(ts.getTime());
       return date;
    }

    public static String formatADate(Date dt){
        String dateStr = "";
        SimpleDateFormat ddmmyyyyDF = new SimpleDateFormat("dd/MM/yyyy");
//        Date tdayDt = new Date();
        dateStr = ddmmyyyyDF.format(dt);
        return dateStr;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timestamp ts = new Timestamp(Calendar.getInstance().getTime().getTime());
        System.out.println("today's timestamp converted to Date object is: "+ convertTsToDate(ts));
        System.out.println("today's timestamp converted to Date object and formatted by SDF is: "+ formatADate(convertTsToDate(ts)));
    }

}
