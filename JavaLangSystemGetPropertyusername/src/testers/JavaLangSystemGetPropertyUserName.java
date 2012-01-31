/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class JavaLangSystemGetPropertyUserName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String systemusername = System.getProperty("user.name");
        System.out.println("systemusername :" + systemusername);
        String javaclasspath = System.getProperty("java.class.path");
        System.out.println("javaclasspath :" + javaclasspath);
        System.out.println(System.getProperties());
    }

}
