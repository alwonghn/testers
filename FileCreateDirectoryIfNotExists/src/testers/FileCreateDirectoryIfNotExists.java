package testers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * http://javarevisited.blogspot.com/2011/12/create-file-directory-java-example.html
 * @author alfred.wong
 */
public class FileCreateDirectoryIfNotExists {   // method 1 : using File.mkdir()

    private static void createFile(String filePath){
	try
	{
	    FileWriter writer = new FileWriter(filePath);
 
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
    
    private static boolean isDirectoryExists(String filePath){
        File directory = new File(filePath);
        if (directory.exists()){
            System.out.println("directory exists");
            return true;
        }else{
            System.out.println("directory does not exist");
            return false;
        }
    }
    
    private static boolean createDirectory(String filePath){
        File directory = new File(filePath);
        Boolean created = directory.mkdir();
        if(created){
            System.out.println("directory was created");
        }
        return created;
    }
    
    
    public static void main(String[] args) {
        String directoryPath = "c:\\AVMS\\test1";
        String filePath = "c:\\AVMS\\test1\\test.csv";
        
        if(!isDirectoryExists(directoryPath)){
            Boolean created = createDirectory(directoryPath);
            if(created){
                createFile(filePath);
            }
        } else {
            createFile(filePath);
        }
    }
}

