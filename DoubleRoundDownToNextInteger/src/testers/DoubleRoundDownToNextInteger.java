/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;
import java.util.*;
    import java.lang.*;
/**
 *http://www.dreamincode.net/forums/topic/127499-rounding-a-double-down-to-next-integer/
 * http://www.java2s.com/Code/Java/Language-Basics/Obtainingtheintegerandfractionalparts.htm
 * @author alfred.wong
 */
public class DoubleRoundDownToNextInteger {

    /** rule of Math.round :   round a double you get a long
     *                         round a  float you get a int
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        float pi = 3.6415f;
//        double pi = 3.141;
//        long rounded = Math.round(pi);
//        System.out.println("the rounded  no is   :"+rounded);


        // ans shld be 13hrs and 16mins
//        float mins = 796;
//        float minsdiv60 = mins/60;
//        long hoursRoundedNearest = Math.round(minsdiv60);
//        System.out.println("the rounded hours is : "+ hoursRoundedNearest );

        // ans shld be 6 hrs and x mins
//        float mins = 396;
//        float minsdiv60 = mins/60;
//        long hoursRoundedNearest = Math.round(minsdiv60);
//        System.out.println("the rounded hours is : "+ hoursRoundedNearest );
//        // doesn't work!!

        // ans shld be 6 hrs and x mins
        int mins = 396;
        double minsdiv60 = mins/60;
        double hoursRoundedNearest = Math.floor(minsdiv60);
        System.out.println("the rounded hours using floor will always return a decimal value : "+ hoursRoundedNearest );
        System.out.println("the rounded hours after casting as long : "+ (long)hoursRoundedNearest );
    }

}
