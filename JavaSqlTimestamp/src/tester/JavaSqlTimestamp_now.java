/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author alfred.wong
 */
public class JavaSqlTimestamp_now {
    /**
     * aws: make a Timestamp by new Timestamp and pass it the Unix epoch Long milliseconds value (using Date.getTime() method)
     */
    public static void main(String[] args) {
        Timestamp tsNow = new Timestamp(new Date().getTime());
        System.out.println("new Timestamp(dateNow.getTime())  : " + tsNow);
    }

}
