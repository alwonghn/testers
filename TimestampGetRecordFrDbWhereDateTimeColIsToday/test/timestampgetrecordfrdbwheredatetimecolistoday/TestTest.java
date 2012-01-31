/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package timestampgetrecordfrdbwheredatetimecolistoday;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author alfred.wong
 */
public class TestTest extends TestCase {
    
    public TestTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getStartDatesForToday method, of class Test.
     */
    public void testGetStartDatesForToday() throws Exception {
        System.out.println("getStartDatesForToday");
        Test instance = new Test();

        ArrayList<Integer> expResult = new ArrayList<Integer> ();
        expResult.add(new Integer(19));
        ArrayList<Integer> result = instance.getStartDatesForToday();
        for(Integer i : result){
            System.out.println("booking nums with start date today : "+ i);
        }
        assertEquals(expResult, result);
    }

}
