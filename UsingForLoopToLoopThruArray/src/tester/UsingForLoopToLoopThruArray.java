/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

/**
 *
 * @author alfred.wong
 */
public class UsingForLoopToLoopThruArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arrInts = new int[5];
        arrInts[0] = 1;
        arrInts[1] = 2;
        arrInts[2] = 3;
        arrInts[3] = 4;
        arrInts[4] = 5;
        System.out.println("arrInts.length = "+arrInts.length);
        for(int i = 0; i<arrInts.length; i++){   //aws:  always start at 0 and always use < not <= !!
            System.out.println(arrInts[i]);
        }
    }

}
