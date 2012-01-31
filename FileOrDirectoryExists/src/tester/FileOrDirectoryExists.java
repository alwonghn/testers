/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;
import java.io.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author alfred.wong
 */
public class FileOrDirectoryExists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


/*
//PROD            Date dateTd = new Date();
//PROD            SimpleDateFormat sdfyyyyMMdd = new SimpleDateFormat("yyyyMMdd");
//PROD            String strSdfyyyyMMdd = sdfyyyyMMdd.format(dateTd);
//PROD            File fileFind = new File("C:\\AVMS\\SCS\\SCS_Checkin-OPERATOR_"+strSdfyyyyMMdd+".DAT");
*/

/*
            File fileFind = new File("C:\\AVMS\\SCS\\SCS_Checkin-OPERATOR_"+"20110802"+".DAT");
            boolean exists = fileFind.exists();
            if (!exists) {
                // It returns false if File or directory does not exist
                System.out.println("the file or directory you are searching does not exist : " + exists);

            }else{
//                // It returns true if File exists and is a file not a directory
                System.out.println("the file or directory you are searching exists and is a file: " +fileFind.isFile());
            }
*/
        String ScsVehicleDatFilePath = "C:\\AVMS\\SCS\\SCS_Checkin-VEHICLE_";
        String strScsVehicleDatFilePathFull = ScsVehicleDatFilePath+"20110802"+".DAT"; // testing: remove in production
        File fileFind = new File(strScsVehicleDatFilePathFull);
        if (fileFind.exists() && fileFind.isFile()) {

            System.out.println("the file or directory you are searching exists:" + fileFind.exists() + " and is a file:" +fileFind.isFile());

        } else {
            System.out.println("the file or directory you are searching does not exist : " + fileFind.exists() + "OR  is not a file" + fileFind.isFile());
        }
    }

}
