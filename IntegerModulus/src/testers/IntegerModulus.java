/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class IntegerModulus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        float minsmod60 = 796%60;
        int minsmod60 = 796%60;
//        float minsmod60rnd = Math.round(minsmod60);
//        int minsmod60rnd = Math.round(minsmod60);
        Integer minsmod60rnd = Math.round(minsmod60);
        System.out.println("the modulus is : "+minsmod60rnd);
    }

}
