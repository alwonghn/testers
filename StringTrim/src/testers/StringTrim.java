/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class StringTrim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String testStr1 = " 3  ";
        String testStr2 = new String(" 3  ");
        String testStr3 = new String(" a  ");
        String testStr4 = new String(" ab  ");
        testStr1.trim();
        testStr2.trim();
        testStr3.trim();
        testStr4.trim();
        System.out.println("testStr1.length() = : "+testStr1.length());
        System.out.println("testStr1 = : -"+testStr1+"-");
        System.out.println("testStr1.trim() = : -"+testStr1.trim()+"-");
        System.out.println("testStr1.trim().length() = : "+testStr1.trim().length());

        System.out.println("testStr2.length() = : "+testStr2.length());
        System.out.println("testStr2 = : -"+testStr2+"-");
        System.out.println("testStr3.length() = : "+testStr3.length());
        System.out.println("testStr3 = : -"+testStr3+"-");
        System.out.println("testStr4.length() = : "+testStr4.length());
        System.out.println("testStr4 = : -"+testStr4+"-");
        String testStr4trim = testStr4.trim();
        System.out.println("testStr4trim = : -"+testStr4trim+"-");



        String testStr5 = "   3  ";
        if(testStr5.substring(2, 6).trim().equals("3")){
            System.out.println("trimmed to 3");
        }else{
            System.out.println("not trimmed to 3");
        }
    }

}
