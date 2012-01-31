/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author alfred.wong
 */
public class JavaIoFileNameFilterTestForFilenamePattern {

    /**
     * http://www.java-samples.com/showtutorial.php?tutorialid=384
     */
    public static void main(String[] args) {
        String hastusVehSchedFilePath = "C:\\avmsshare\\hastus\\vehicle";
        File directory = new File(hastusVehSchedFilePath);
        FilenameFilter onlyExtOfName = new OnlyExtOfName("txt");
        if(directory.isDirectory()){
            String[] filesList = directory.list(onlyExtOfName);
            for(int i=0; i<filesList.length; i++){
                System.out.println(filesList[i]);
            }
        }
    }

}
