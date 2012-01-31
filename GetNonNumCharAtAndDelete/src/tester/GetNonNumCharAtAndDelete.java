/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

/**
 *
 * @author alfred.wong
 */
public class GetNonNumCharAtAndDelete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strTest = "020E";
        StringBuffer sb = new StringBuffer(strTest);
        sb.setLength(strTest.length());
        for(int i=0;i<strTest.length();i++){
            char c = strTest.charAt(i);
            if(!('0'<=c&&c<='9')){
                System.out.println("one non numberic character found");
                sb.deleteCharAt(i);
                System.out.println("one non numberic character deleted");
            }
        }

        System.out.println("String result: "+sb.toString());
    }

}
