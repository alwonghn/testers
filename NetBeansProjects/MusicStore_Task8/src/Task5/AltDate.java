package Task5;

import java.util.Calendar;
//import java.text.SimpleDateFormat;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class AltDate {

    public int hourInt;
            
    public int getHourInt(){
        Calendar now = Calendar.getInstance();
        hourInt = now.get(Calendar.HOUR_OF_DAY);
        return(hourInt);
    }   
}
