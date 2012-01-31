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
public class JavaUtilCalendar_custom {
    
    public static void main(String[] args) {
        Calendar calCustom = Calendar.getInstance();
        calCustom.set(2011, 8, 20, 0, 0, 0); // 8 = september
        System.out.println("Calendar.getInstance().set(2011, 8, 20, 0, 0, 0) :" + calCustom);
        calCustom.set(Calendar.MILLISECOND, 0);
        calCustom.set(Calendar.AM_PM, 0);//
        System.out.println("Calendar.getInstance().set(2011, 8, 20, 0, 0, 0) + set milliseconds to zero :" + calCustom);
        String strCalCustom = calCustom.toString();
        System.out.println("Calendar.getInstance().toString() :" + strCalCustom);
        String strCalCustomGetTime = calCustom.getTime().toString();
        System.out.println("Calendar.getInstance().getTime().toString() :" + strCalCustomGetTime);
    }
}
