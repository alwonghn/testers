

package testers;

import java.io.File;

/**
 *
 * @author alfred.wong
 */
public class TestIfDirectoryIsEmpty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String hastusVehSchedFilePath = "C:\\avmsshare\\hastus\\vehicle";
        File directory = new File(hastusVehSchedFilePath);
        if(directory.isDirectory()){
            String[] filesList = directory.list();
            for(int i=0; i<filesList.length; i++){
                System.out.println(filesList[i]);
            }
        }


    }

}
