/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

import java.util.Calendar;

/**
 *
 * @author alfred.wong
 */
public class JavaUtilCalendar_now {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar calNow = Calendar.getInstance();
        System.out.println("Calendar.getInstance() :" + calNow);

//        String strCalNow = calNow.toString();
//        System.out.println("Calendar.getInstance().toString() :" + strCalNow);
//
//        String strCalNowGetTime = calNow.getTime().toString();
//        System.out.println("Calendar.getInstance().getTime().toString() :" + strCalNowGetTime);

        int intCalNowYear = (calNow.get(Calendar.YEAR));
        System.out.println("calNow.get(Calendar.YEAR) :" + intCalNowYear);
    }

}
