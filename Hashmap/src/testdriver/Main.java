/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testdriver;

import testers.ConstructTester;
import testers.EnumerateTester;
import testers.IteratorTester;

/**
 *
 * @author alfred.wong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        -------Test1:----------
//        ConstructTester tester = new ConstructTester();
//        tester.construct_hashmap();

//        -------Test2:-----------
//        EnumerateTester tester = new EnumerateTester();
//        tester.enumerate_hashmap();

//        -------Test3:-----------
        IteratorTester tester = new IteratorTester();
        tester.printKeys();
//        tester.printValues();
//        tester.printKeyAndValues();
    }

}
