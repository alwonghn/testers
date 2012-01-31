/*
 *http://stackoverflow.com/questions/1066589/java-iterate-through-hashmap
 */

package testers;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alfred.wong
 */
public class IteratorTester {

    private Map<String, Object> map = new HashMap<String, Object>();

    public IteratorTester(){
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
    }
 

    //If you're only interested in the keys, you can iterate through the keySet() of the map:    
    public void printKeys(){
        for (String key : map.keySet()) {
            System.out.println("key : "+ key);
        }        
    }

    //If you only need the values, use values():
    public void printValues(){
        for (Object value : map.values()) {
            System.out.println("value : "+ value);
        }        
    }

    //Finally, if you want both the key and value, use entrySet():
    public void printKeyAndValues(){
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key: "+key+ "  value: "+value);
        }
    }
 
    
    

}
