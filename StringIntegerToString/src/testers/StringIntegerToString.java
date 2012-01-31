/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class StringIntegerToString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer tenInt = 10;
        String strTen = tenInt.toString();
        String str2Ten = ""+tenInt;   // alternative conversion method
//        String strTen = tenInt.toString().trim();
        System.out.println("Integer 10 converted to String using toString is : "+strTen);
        System.out.println("Type of tenInt" + tenInt.getClass().getName());
        System.out.println("Type of strTen" + strTen.getClass().getName());
        System.out.println("Type of str2Ten" + str2Ten.getClass().getName());
        
    }

}
