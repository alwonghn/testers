/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers; 
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author alfred.wong
 */
public class FileWriterTest {

   private static void createFile(String sFileName)
   {
	try
	{
	    FileWriter writer = new FileWriter(sFileName);
 
	    writer.append("DisplayName");
	    writer.append(',');
	    writer.append("Age");
	    writer.append('\n');
 
	    writer.append("MKYONG");
	    writer.append(',');
	    writer.append("26");
            writer.append('\n');
 
	    writer.append("YOUR NAME");
	    writer.append(',');
	    writer.append("29");
	    writer.append('\n');
 
	    //generate whatever data you want
 
	    writer.flush();
	    writer.close();
	} catch(IOException e){
	     e.printStackTrace();
	}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createFile("c:\\AVMS\\test1\\test.csv");    // throws exception if the directory does not exist
    }
    
}

 


