/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alfred.wong
 */
public class DateSimpleDateFormatFromTimestamp {

    ////////////////WRONG!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    public static String makeDateStrFrTs(Timestamp ts){
//        SimpleDateFormat ddmmyyyyDF = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat ddmmyyyyDF = new SimpleDateFormat("ddMMyyyy");
        Date tdayDt = new Date();
        return ddmmyyyyDF.format(tdayDt);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar tdayCal = Calendar.getInstance();
        Date tdayDt = tdayCal.getTime();
        Timestamp tdayTs = new Timestamp(tdayDt.getTime());
        System.out.println(makeDateStrFrTs(tdayTs));
    }

}
