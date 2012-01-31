/*
 * http://www.easywayserver.com/blog/java-map-example/
 * http://stackoverflow.com/questions/1062135/updating-a-java-map-entry
 */

package testers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author alfred.wong
 */
public class MapUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer,Object> mp=new HashMap<Integer, Object>();
        // adding or set elements in Map by put method key and value pair
        mp.put(new Integer(2), "Two");
        mp.put(1, new String("One"));
        mp.put(3, new String("Three"));
        mp.put(new Integer(4), "Four");

        for(Entry<Integer, Object> entry:mp.entrySet()){
            System.out.println(entry.getValue());
        }
        mp.put(new Integer(2), "Trwo");
        for(Entry<Integer, Object> entry:mp.entrySet()){
            System.out.println(entry.getValue());
        }
        mp.put(new Integer(2), "Too");
        for(Entry<Integer, Object> entry:mp.entrySet()){
            System.out.println(entry.getValue());
        }

        if(mp.containsKey(new Integer(3))){
            System.out.println((String)mp.get(new Integer(3)));
        }
    }

}
