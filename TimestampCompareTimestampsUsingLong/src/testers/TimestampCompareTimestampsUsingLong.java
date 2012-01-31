/*
 * http://www.java2s.com/Code/Java/Database-SQL-JDBC/ConvertjavasqlTimestamptolongforeasycompare.htm
 * 
 */

package testers;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author alfred.wong
 */
public class TimestampCompareTimestampsUsingLong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Date todayDt = new java.util.Date();
        java.sql.Timestamp todayTs = new java.sql.Timestamp(todayDt.getTime());
        java.sql.Timestamp customTimeTs = java.sql.Timestamp.valueOf("2005-04-06 09:01:10");

        long todayLg = todayTs.getTime();
        long customTimeLg = customTimeTs.getTime();

        System.out.println("long value of today : "+todayLg);
        System.out.println("long value of 2005-04-06 09:01:10   :  "+customTimeLg);


        /// example 1:find long value of one day
        Calendar startDayArbitraryCal = Calendar.getInstance();
        startDayArbitraryCal.set(Calendar.YEAR, 1977);
        startDayArbitraryCal.set(Calendar.MONTH, 0);
        startDayArbitraryCal.set(Calendar.DAY_OF_MONTH, 1);
        startDayArbitraryCal.set(Calendar.HOUR_OF_DAY, 0);
        startDayArbitraryCal.set(Calendar.MINUTE, 0);
        startDayArbitraryCal.set(Calendar.MILLISECOND, 0);
        Timestamp startDayArbitraryTs = new Timestamp(startDayArbitraryCal.getTime().getTime());
        System.out.println("long value of startDateArbitraryTs : "+startDayArbitraryTs.getTime());
        Calendar oneDayFrStDtCal = Calendar.getInstance();
        oneDayFrStDtCal.set(Calendar.YEAR, 1977);
        oneDayFrStDtCal.set(Calendar.MONTH, 0);
        oneDayFrStDtCal.set(Calendar.DAY_OF_MONTH, 2);
        oneDayFrStDtCal.set(Calendar.HOUR_OF_DAY, 0);
        oneDayFrStDtCal.set(Calendar.MINUTE, 0);
        oneDayFrStDtCal.set(Calendar.MILLISECOND, 0);
        Timestamp oneDayFrStDtTs = new Timestamp(oneDayFrStDtCal.getTime().getTime());
        System.out.println("long value of oneDayFrStDtTs : "+oneDayFrStDtTs.getTime());
        System.out.println("long value of one day : "+(oneDayFrStDtTs.getTime()-startDayArbitraryTs.getTime()));
        /// example 2:find long value of one year
        Calendar startDateArbitraryCal = Calendar.getInstance();
        startDateArbitraryCal.set(Calendar.YEAR, 1977);
        startDateArbitraryCal.set(Calendar.MONTH, 0);
        startDateArbitraryCal.set(Calendar.DAY_OF_MONTH, 1);
        startDateArbitraryCal.set(Calendar.HOUR_OF_DAY, 0);
        startDateArbitraryCal.set(Calendar.MINUTE, 0);
        startDateArbitraryCal.set(Calendar.MILLISECOND, 0);
        Timestamp startDateArbitraryTs = new Timestamp(startDateArbitraryCal.getTime().getTime());
        System.out.println("long value of startDateArbitraryTs : "+startDateArbitraryTs.getTime());
        Calendar oneYrFrStDtCal = Calendar.getInstance();
        oneYrFrStDtCal.set(Calendar.YEAR, 1978);
        oneYrFrStDtCal.set(Calendar.MONTH, 0);
        oneYrFrStDtCal.set(Calendar.DAY_OF_MONTH, 1);
        oneYrFrStDtCal.set(Calendar.HOUR_OF_DAY, 0);
        oneYrFrStDtCal.set(Calendar.MINUTE, 0);
        oneYrFrStDtCal.set(Calendar.MILLISECOND, 0);
        Timestamp oneYrFrStDtTs = new Timestamp(oneYrFrStDtCal.getTime().getTime());
        System.out.println("long value of oneYrFrStDtTs : "+oneYrFrStDtTs.getTime());
        System.out.println("long value of one year : "+(oneYrFrStDtTs.getTime()-startDateArbitraryTs.getTime()));
    }

}
