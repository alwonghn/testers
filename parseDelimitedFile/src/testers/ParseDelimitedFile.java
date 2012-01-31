/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alfred.wong
 */
public class ParseDelimitedFile {

    static String filePath;
    static FileReader fr;
    static BufferedReader br;
    /**
     * @param args the command line arguments
     */
    private static void readFile(String filePath, String delimiter)
    {
        try{
            //ArrayList alRec = new ArrayList();
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String currRec = null;
            while((currRec = br.readLine()) != null){
                //alRec.add(currRec.split(","));        
                String[] arrRecField = currRec.split(delimiter);
                for(String recField: arrRecField){
                    System.out.println(recField);
                }
                System.out.println();
            }
        } catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        } finally {
            try{
                if(br !=null){
                    br.close();
                }
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        filePath = "C:\\AVMS\\SCS\\SCS_Checkin-VEHICLE_20110802.DAT";
        ParseDelimitedFile test = new ParseDelimitedFile();
        test.readFile(filePath, ",");
    }

}
