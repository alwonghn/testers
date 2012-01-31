/*
 * http://www.coderanch.com/t/401142/java/java/check-if-String-value-numeric
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class IntegerTestStringIsInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strStr = "brbp";
        System.out.println("result of test isInteger on "+strStr+" is :"+isInteger(strStr.trim()));
    }

    public static boolean isInteger(String strStr){
        try{
            Integer.parseInt(strStr);
            return true;
        }
        catch(Exception e){
          return false;
        }
    }

}
