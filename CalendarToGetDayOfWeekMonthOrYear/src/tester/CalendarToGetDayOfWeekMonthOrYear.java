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
public class CalendarToGetDayOfWeekMonthOrYear {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Calendar calTday = Calendar.getInstance();
        System.out.println("Calendar.getInstance() is : " + calTday);
        System.out.println("calTday.AM is : " + calTday.AM);
        System.out.println("calTday.AM/PM is : " + calTday.get(Calendar.AM_PM));
        System.out.println("calTday.DATE is : " + calTday.DATE);
        System.out.println("calTday.DAY_OF_MONTH is : " + calTday.DAY_OF_MONTH);
        System.out.println("[do this first choice] calTday.get(Calendar.DAY_OF_MONTH) is : " + calTday.get(Calendar.DAY_OF_MONTH));
        System.out.println("[dont do this] calTday.DAY_OF_WEEK is : " + calTday.DAY_OF_WEEK);
        System.out.println("[do this first choice] calTday.get(Calendar.DAY_OF_WEEK_IN_MONTH) is : " + calTday.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("[do this second choice] calTday.get(Calendar.DAY_OF_WEEK) is : " + calTday.get(Calendar.DAY_OF_WEEK) + "  ~  Note: 1. sun=0  2.type of calTday.get(Calendar.DAY_OF_WEEK) is int ");
        System.out.println("calTday.MONTH is : " + calTday.MONTH);
        System.out.println("calTday.get(Calendar.MONTH) is : " + calTday.get(Calendar.MONTH));
    }

}
