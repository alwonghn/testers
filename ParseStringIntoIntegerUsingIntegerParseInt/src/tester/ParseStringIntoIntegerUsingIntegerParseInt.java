/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

import java.text.ParseException;

/**
 *
 * @author alfred.wong
 */
public class ParseStringIntoIntegerUsingIntegerParseInt {

    /**
     * @param args the command line arguments
     */
    private static void TestAString (String strTest){
        if(strTest.startsWith("SBS")){
            System.out.println("This is a SBS vehicle_id ! : ");
            FormatAString(strTest);
        } else {
            System.out.println("This is NOT a SBS vehicle_id ! : ");
        }
               
    }
    
    
    private static void FormatAString (String strTest){
/*        
        for(int i=0; i<strTest.length(); i++){
            System.out.println(strTest.substring(i, i+1));
        }
*/
        String strTestLessSubstring = strTest.replace("SBS", "");
        System.out.println("OK, vehicle id string after removing the 'SBS' prefix is : "+ strTestLessSubstring);
        ParseAParsableString (strTestLessSubstring);
    }
    
    
    private static Integer ParseAParsableString (String strTestLessSubstring){
        Integer intResult = 0;
        try{
            intResult = Integer.parseInt(strTestLessSubstring);
            System.out.println("OK, vehicle id integer after parsing the prepared string : "+intResult);
        } catch (NumberFormatException nfex){
            System.out.println("Caught a Number Format Exception : "+ nfex);
        }
        return intResult;
    }


    public static void main(String[] args) {
//        String strTest = "SBS0585";
        //String strTest = "00585";
//        TestAString(strTest);

//        String strTest = " 3";
//        String strTest = "3 ";
        String strTest = "03";
        Integer result = ParseAParsableString(strTest.trim());
        System.out.println("result : "+result);
    }

}
