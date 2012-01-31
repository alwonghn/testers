/*
 * http://www.roseindia.net/java/beginners/SubstringExample.shtml
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class StringSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string = "alfred wong";
        System.out.println("String 'alfred wong' : " + string);
        String substring = string.substring(3);
        System.out.println("string.substring(3) of 'alfred wong' :" + substring);
        substring = string.substring(1, 2);
        System.out.println("Substring (1,2) of 'alfred wong' :" + substring);
        substring = string.substring(0, 2);
        System.out.println("Substring (0,2) of 'alfred wong' :" + substring);

        String string1 = " 5 ";
        System.out.println("Substring (1,2) of  ' 5 ' :" + string1.substring(1, 2));


        String string2 = "se  -809";
        System.out.println("Substring (5) of : 'se  -809' is :" + string2.substring(5));

        String string3 = "Sep9   000";
        System.out.println("Substring (string3.length()-3) of : 'Sep9   000' is :" + string3.substring(string3.length()-3));
    }

}
