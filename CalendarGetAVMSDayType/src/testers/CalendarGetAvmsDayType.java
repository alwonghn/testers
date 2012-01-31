/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author alfred.wong
 */
public class CalendarGetAvmsDayType {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Calendar calTday = Calendar.getInstance();
        Integer calTDay = calTday.get(Calendar.DAY_OF_WEEK);
//        Integer dayType;
//        switch(calTDay){
//            case 1: dayType = 4; break;
//            case 2: dayType = 1; break;
//            case 3: dayType = 1; break;
//            case 4: dayType = 1; break;
//            case 5: dayType = 1; break;
//            case 6: dayType = 1; break;
//            case 7: dayType = 3; break;
//            default: dayType = 1; break;
//        }
        String dayType;
        switch(calTDay){
            case 1: dayType = "4, sunday"; break;
            case 2: dayType = "1, monday"; break;
            case 3: dayType = "1, tuesday"; break;
            case 4: dayType = "1, wednesday"; break;
            case 5: dayType = "1, thursday"; break;
            case 6: dayType = "1, friday"; break;
            case 7: dayType = "3, saturday"; break;
            default: dayType = "1, noday"; break;
        }
        System.out.println("calTday.get(Calendar.DAY_OF_WEEK_IN_MONTH) :"+calTDay+"result is : AVMS day type = "+dayType);

    }

}
