/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

import java.util.HashMap;

/**
 *
 * @author alfred.wong
 */
public class ObjectIsNull {

//    static String testObj = null;
    static HashMap testObj = null;

    public static boolean isNull(Object o){
        if(o == null){
            return true;
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        testObj = null;
//        testObj = "hello";
        testObj = new HashMap();

        testObj = null;

        if(isNull(testObj)){
            System.out.println("testObj is null");
        }else{
            System.out.println("testObj is not null");
        }
    }

}
