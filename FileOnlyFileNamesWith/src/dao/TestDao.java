/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import java.io.File;
import java.io.FilenameFilter;
import util.OnlyFileNamesWith;





/**
 *
 * @author alfred.wong
 */
public class TestDao {
    
    
    public String[] getFilesOnlyFileNamesWith(File directory, String pattern){
        String[] filesList = null;
        FilenameFilter onlyFileNamesWith = new OnlyFileNamesWith(pattern);
        
        if(directory.isDirectory()){
            filesList = directory.list(onlyFileNamesWith);
            for(String file:filesList){
//                System.out.println(file.substring(file.length()-2, file.length()));
                System.out.println(file);
            }
        }
        return filesList;
    }
    
    public void load(File directory, String[] filesList){
        for(String fileName : filesList){
//            File fileFind = new File(""+"C:\\avmsshare\\hastus\\vehicle"+"\\"+"157"+"_"+"1"+".V"+fileName.substring(fileName.length()-2, fileName.length()));
            File fileFind = new File(""+directory+"\\"+fileName);
            if(fileFind.exists() && fileFind.isFile()){
//                System.out.println("found a 157_1.V"+fileName.substring(fileName.length()-2, fileName.length()));
                System.out.println("found a file"+fileName);
            }else{
                System.out.println("did not find a file of name "+fileName + "from the given FILELIST");
            }
        }
    }
}
