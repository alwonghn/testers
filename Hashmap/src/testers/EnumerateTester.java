/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * http://stackoverflow.com/questions/2048131/get-an-enumeration-for-the-keys-of-a-map-hashmap-in-java
 */
public class EnumerateTester {
    
    public void enumerate_hashmap(){
        final Map <String,Integer> test = new HashMap<String,Integer>();
        test.put("one",1);
        test.put("two",2);
        test.put("three",3);
        final Enumeration<String> strEnum = Collections.enumeration(test.keySet());

        while(strEnum.hasMoreElements()) {
            System.out.println(strEnum.nextElement());
        }

        // doesn't work!!
//        System.out.println( "Enumerate the HashMap" );
//        Enumeration e = map.elements();
//        while ( e.hasMoreElements() )
//          System.out.println( e.nextElement() );
//        System.out.println();
    }
}
