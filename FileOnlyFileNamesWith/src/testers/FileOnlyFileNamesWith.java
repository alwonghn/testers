/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import dao.TestDao;
import java.io.File;

/**
 *
 * @author alfred.wong
 */
public class FileOnlyFileNamesWith {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File directory = new File("C:\\avmsshare\\hastus\\vehicle");
        String pattern  = new String("day");
        TestDao testDao = new TestDao();
        String[] filesList = testDao.getFilesOnlyFileNamesWith(directory, pattern);        
    }

}
