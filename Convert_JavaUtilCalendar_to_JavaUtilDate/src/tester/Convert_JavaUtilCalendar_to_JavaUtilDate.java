/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alfred.wong
 */
public class Convert_JavaUtilCalendar_to_JavaUtilDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar calNow = Calendar.getInstance();
        Date dateNow = calNow.getTime();
        System.out.println("calNow.getTime() :" + dateNow);
    }

}
