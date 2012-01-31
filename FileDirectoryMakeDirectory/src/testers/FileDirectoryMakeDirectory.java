/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.io.File;

/**
 *
 * http://xytang.blogspot.com/2007/10/renamemove-files-using-java.html
 */
public class FileDirectoryMakeDirectory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean status;
        
        // make directory 1
        status = new File("C:\\avmsshare\\testmkdir1").mkdir();
        report(status);
        // make the same directory 1 again
        status = new File("C:\\avmsshare\\testmkdir1").mkdir(); // should fail
        report(status);

        // make directory2
        String directory2Path = "C:\\avmsshare\\testmkdir2";
        File directory2 = new File(directory2Path);
        status = new File(directory2Path).mkdir();
        report(status);
        // check for existing directory 2 and make alternative directory if exists
        if(directory2.exists()){
            status = new File("C:\\avmsshare\\testmkdir3").mkdir();
        }        

        // use mkdirs   to circumvent 
        status = new File("C:\\avmsshare\\testmkdir2").mkdirs(); // should succeed
        report(status);
    }

    static void report(boolean b) {
        System.out.println(b ? "success" : "failure");
    }

}
