package testdateclass;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class AltDate {

    public String hourStr;
    public int hourInt;
            
    public int getHourInt(){
        Calendar now = Calendar.getInstance();
        hourInt = now.get(Calendar.HOUR_OF_DAY);
        return(hourInt);
    }        
            
    
}
