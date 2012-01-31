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

    //public String hourIntFormat = "hh";
    //public String hourStr;
    public int hourInt;
            
    public int getHourInt(){
        Calendar now = Calendar.getInstance();
        //SimpleDateFormat sdf = new SimpleDateFormat(hourIntFormat);
        //hourStr = sdf.format(now.getTime());
        //hourInt = Integer.parseInt(hourStr);
        hourInt = now.get(Calendar.HOUR_OF_DAY);
        return(hourInt);
    }        
            
    
}
