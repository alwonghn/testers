/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class StringSubstringComparison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string = "157_1.V43";
        System.out.println("String to compare substring of which is: '157_1.V43' : " + string);
        if(string.substring(6, 7).equalsIgnoreCase("V")){
            System.out.println("Detected the 'V' using string.equalsIgnoreCase('V') ! ");
        }

    }

}
