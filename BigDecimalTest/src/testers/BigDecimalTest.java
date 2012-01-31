/*
 * To change this template, choose Tools | Templates
 * http://stackoverflow.com/questions/1359817/java-bigdecimal
 */

package testers;
import java.math.BigDecimal;
/**
 *
 * @author alfred.wong
 */
public class BigDecimalTest {
    private static BigDecimal bd;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bd = new BigDecimal(1.5000);
//        bd = new BigDecimal("1.5");
        bd.setScale(2);
        
        System.out.println(bd.toString());
    }

}
