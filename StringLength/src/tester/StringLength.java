/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

/**
 *
 * @author alfred.wong
 */
public class StringLength {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strTest = "YK 7050";
        int length = strTest.length();
        System.out.println("length of "+strTest+" is :"+length);
        StringBuffer sb = new StringBuffer(strTest);
//        for(int i=0; i<strTest.length()-4; i++){
//            //sb = sb.delete(i, i+1);
//            sb = sb.deleteCharAt(i);
//        }
        sb = sb.delete(0, length-4);
        System.out.println("String result: "+sb);

    }

}
