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
public class FileRenameTo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // File (or directory) to be moved
        File file = new File("C:\\avmsshare\\hastus\\crew\\dummy\\157.C-1.txt");

        // Destination directory
        File dir = new File("C:\\avmsshare\\hastus\\crew_done\\dummy");

        // Move file to new directory
        boolean success = file.renameTo(new File(dir, file.getName()));
        if (!success) {
            System.out.println("file was moved");
        } else {
            System.out.println("file was not moved");
        }
    }

}
