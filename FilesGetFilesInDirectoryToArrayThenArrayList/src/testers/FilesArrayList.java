/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author alfred.wong
 */
public class FilesArrayList {


    

    public static ArrayList<String> getFilesListInDirectory(String FilePath){
        ArrayList<String> filesList = new ArrayList<String>();
        System.out.println("filepath :"+FilePath);
        File directory = new File(FilePath);
//        FilenameFilter onlyExtOfName = new OnlyExtOfName("txt");
        if(directory.isDirectory()){
//            String[] filesArr = directory.list(onlyExtOfName);
            String[] filesArr = directory.list();
            for(String f : filesArr){
                System.out.println("file in array filesArr :"+f);
                filesList.add(f);
            }
        }
        return filesList;
    }

    public static void main(String[] args) {
        //String hastusVehSchedFilePath = "C:\\avmsshare\\hastus\\vehicle";
        String hastusVehSchedFilePath = "C:\\avmsshare\\hastus\\vehicle";
        ArrayList<String> filesList = getFilesListInDirectory(hastusVehSchedFilePath);
        for(String file : filesList){
            System.out.println(file);
        }
    }

}
