/*
 * http://mindprod.com/jgloss/string.html
 */

package tester;

/**
 *
 * @author alfred.wong
 */
public class StringEmptyString {

    /**
     * @param args the command line arguments
     */
    public static boolean isEmptyString(String str){
        boolean result = false;
//        String emptystring = "";
//        if (str.equals(emptystring)) {
//            return true;
//        } else {
//            return false;
//        }
        if ( str == null ){
            result = true;//result = "was null";
        } else if ( str.length() == 0 ){
            result=true;//result = "was empty";
        } else if ( str.trim().length () == 0 ){
            result=true;//result = "was blank or other whitespace";
        }
        return result;
    }

    public static void main(String[] args) {
//        String str = " ";
        String str = "";
//        String str = null;
//        str.trim();
        boolean result = isEmptyString(str);
        System.out.println("test result of - is this string an empty string (where empty is defined as null, '', or '  ') ??? result: "+result);

    }

}
