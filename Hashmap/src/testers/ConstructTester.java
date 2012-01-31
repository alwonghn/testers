package testers;
import java.util.HashMap;
/**
 *
 * http://www.devjavasoft.org/CS1ADS_1999_2000/jgl_docs/api/com.objectspace.jgl.examples.HashMapExamples.html
 */
public class ConstructTester {
    
    public void construct_hashmap(){
        HashMap map = new HashMap();
        map.put( new Integer( 2 ), "two" );
        map.put( new Integer( 4 ), "four" );
        System.out.println( map );
    }

}
