/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class LongValueOfOneDay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.sql.Timestamp currDayTs = java.sql.Timestamp.valueOf("2011-01-13 00:00:00");
        Long currDayLg = currDayTs.getTime();
        java.sql.Timestamp prevDayTs = java.sql.Timestamp.valueOf("2011-01-12 00:00:00");
        Long prevDayLg = prevDayTs.getTime();
        Long longValOneDayLg = currDayLg-prevDayLg;
        System.out.println("Long Value of One day is :"+longValOneDayLg);
    }

}
