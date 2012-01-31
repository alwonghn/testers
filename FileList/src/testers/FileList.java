/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.io.File;

/**
 *
 * @author alfred.wong
 */
public class FileList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File directory = new File("C:\\avmsshare\\hastus\\vehicle");
        String[] filesList = directory.list();
        System.out.println("List of files in the directory: C:\\avmsshare\\hastus\\vehicle :");
        for(String f: filesList){
            System.out.println(f);
        }
    }

}
