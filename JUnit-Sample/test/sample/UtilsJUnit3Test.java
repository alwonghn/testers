/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample;

import junit.framework.TestCase;

/**
 *
 * @author alfred.wong
 */
public class UtilsJUnit3Test extends TestCase {
    
    public UtilsJUnit3Test(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("* UtilsJUnit3Test: setUp() method");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.out.println("* UtilsJUnit3Test: tearDown() method");
    }

    /**
     * Test of concatWords method, of class Utils.
     */
//    public void testConcatWords() {
//        System.out.println("concatWords");
//        String[] words = null;
//        String expResult = "";
//        String result = Utils.concatWords(words);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of computeFactorial method, of class Utils.
//     */
//    public void testComputeFactorial() {
//        System.out.println("computeFactorial");
//        int number = 0;
//        String expResult = "";
//        String result = Utils.computeFactorial(number);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of normalizeWord method, of class Utils.
//     */
//    public void testNormalizeWord() {
//        System.out.println("normalizeWord");
//        String word = "";
//        String expResult = "";
//        String result = Utils.normalizeWord(word);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    public void testHelloWorld(){
        System.out.println("* UtilsJUnit3Test: test method 1 - testHelloWorld()");
        assertEquals("Hello, world!", Utils.concatWords("Hello", ", ", "world", "!"));
    }

}
