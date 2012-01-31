/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * http://www.roseindia.net/java/java-conversion/DateToTimestamp.shtml
 * @author alfred.wong
 */
public class DateConvertDateToTimestamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // input a string date
            String str_date="11-June-07";
            DateFormat formatter ;

            // make a date object from string using sdf specified date pattern
            Date date ; 
            formatter = new SimpleDateFormat("dd-MMM-yy");
            date = (Date)formatter.parse(str_date);

            // pass the date object (date.getTime) into the timestamp constructor
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
            System.out.println("Today is " +timeStampDate);
        } catch (ParseException e) {
            System.out.println("Exception :"+e);

            /// output:    Today is 2007-06-11 00:00:00.0

        }
        
    }

}
