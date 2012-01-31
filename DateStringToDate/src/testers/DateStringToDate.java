/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;
import java.util.*;
import java.text.*;
/**
 * http://www.theserverside.com/discussions/thread.tss?thread_id=5085
 *http://www.roseindia.net/java/java-conversion/StringToDate.shtml
 * @author alfred.wong
 */
public class DateStringToDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {  
//            String str_date="11-June-07";
            String str_date="25/07/2011";
//            String str_date="2011/07/25";

//          SimpleDateFormat stringDateFormat = new SimpleDateFormat("dd-MMM-yy");
          SimpleDateFormat stringDateFormat = new SimpleDateFormat("dd/M/yyyy");
//            SimpleDateFormat stringDateFormat = new SimpleDateFormat("yyyy/mm/dd");
            Date convertedDate = stringDateFormat.parse(str_date);
            System.out.println("Today is " +convertedDate );
            
            String str_date_yearonly = str_date.substring(str_date.length()-4);
            System.out.println("year (last 4 characters) of today : " + str_date_yearonly );
            System.out.println("date and month (first 6 characters) of today : " + str_date.substring(0,(str_date.length()-4)) );
            Integer intyearplusone = Integer.parseInt(str_date_yearonly)+1;
            String stryearplusone = intyearplusone.toString();
            System.out.println("date of today plus a year : " + str_date.substring(0,(str_date.length()-4))+ stryearplusone );
        } catch (ParseException e)
            {System.out.println("Exception :"+e);
        }
    }

}
