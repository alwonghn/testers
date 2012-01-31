
package com.comfortdelgro.avms;
import com.comfortdelgro.avms.dao.CurrentHeadwayStatusDao;
import com.comfortdelgro.avms.dao.CurrentPerformanceStatusDao;
import com.comfortdelgro.avms.jb.CurrentHeadwayStatusBean;
import com.comfortdelgro.avms.jb.CurrentPerformanceStatusBean;
import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.StringTokenizer;
/**
 *
 * @author angck
 */
public class AVMSDailyBatch {

    private static Logger logger;
    static String loggerName;
    static String logFilePath;
    static String ScsVehicleDatFilePath;
    static String ScsOperatorDatFilePath;
    static FileReader fr;
    static BufferedReader br;

    static void logMessage(String message) {
        String messageText;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        messageText = "AVMS Daily Batch " + dateFormat.format(date) + " : " + message;
        logger.info(messageText);
    }

    static void importSCSVehicle(String ScsVehicleDatFilePath) {

//PROD            Date dateTd = new Date();
//PROD            SimpleDateFormat sdfyyyyMMdd = new SimpleDateFormat("yyyyMMdd");
//PROD            String strSdfyyyyMMdd = sdfyyyyMMdd.format(dateTd);
//PROD            String strScsVehicleDatFilePathFull = ScsVehicleDatFilePath+strSdfyyyyMMdd+".DAT";
//PROD            File fileFind = new File(strScsVehicleDatFilePathFull);
            String strScsVehicleDatFilePathFull = ScsVehicleDatFilePath+"20110802"+".DAT"; // testing: remove in production
            File fileFind = new File(strScsVehicleDatFilePathFull);
            boolean exists = fileFind.exists();
            boolean isFile = fileFind.isFile();
            if (exists && isFile) {
//                StringTokenizer st = new StringTokenizer();
                try{
                    //ArrayList alRec = new ArrayList();
                    fr = new FileReader(strScsVehicleDatFilePathFull);
                    br = new BufferedReader(fr);
                    String currRec = null;
                    while((currRec = br.readLine()) != null){
                        //alRec.add(currRec.split(","));
                        String[] arrRecField = currRec.split(",");
                        for(String recField: arrRecField){
                            System.out.println(recField);
                        }
                        System.out.println();
                    }
                }catch(FileNotFoundException ex){
                    ex.printStackTrace();
                }catch(IOException ex){
                    ex.printStackTrace();
                }finally{
                    try{
                        if(br !=null){
                        br.close();
                        }
                    } catch(IOException ex){
                        ex.printStackTrace();
                    }
                }
            }else{

            }
    }

    static void importSCSCrew() {

    }

    static void purgeCurrentPerformanceStatus() {
       try{
           CurrentPerformanceStatusDao cpsDao = new CurrentPerformanceStatusDao();
           cpsDao.purge();
       }catch(Exception ex){
           throw new RuntimeException(ex);
       }
    }

    static void generateCurrentPerformanceStatus() {
       ArrayList<CurrentPerformanceStatusBean> alCps;
       try{
            CurrentPerformanceStatusDao cpsDao = new CurrentPerformanceStatusDao();
            alCps = cpsDao.loadCps();
            cpsDao.insertCps(alCps);
       }catch(Exception ex){
           throw new RuntimeException(ex);
       }
    }

    static void purgeCurrentHeadwayStatus() {
       try{
           CurrentHeadwayStatusDao chwsDao = new CurrentHeadwayStatusDao();
           chwsDao.purge();
       }catch(Exception ex){
           throw new RuntimeException(ex);
       }
    }

    static void generateCurrentHeadwayStatus() {
       ArrayList<CurrentHeadwayStatusBean> alChws;

       try{
           CurrentHeadwayStatusDao chwsDao = new CurrentHeadwayStatusDao();
           alChws = chwsDao.loadChws();
           chwsDao.insertChws(alChws);
       }catch(Exception ex){
           throw new RuntimeException(ex);
       }
    }

    public static void main(String[] args) {
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream("config.properties"));
            loggerName = prop.getProperty("loggerName");
            logFilePath = prop.getProperty("logFilePath");
        }catch(IOException ex){
            System.err.println("IO Exception: "+ ex.getMessage());
        }
        logger = Logger.getLogger(loggerName);
        FileAppender appender = null;
        try {
            appender = new FileAppender(new PatternLayout(), logFilePath);
        } catch(Exception e) {}
        logger.addAppender(appender);
        logMessage("Daily Job Start");

    //        logMessage("Start importing SCS Vehicle");
            importSCSVehicle(ScsVehicleDatFilePath);
    //        logMessage("Completed importing SCS Vehicle");

    //        logMessage("Start importing SCS Crew");
    //        importSCSCrew();
    //        logMessage("Completed importing SCS Crew");

        logMessage("Start Purging CurrentHeadwayStatus");
        purgeCurrentHeadwayStatus();
        logMessage("Completed Purging CurrentHeadwayStatus");

        logMessage("Start Purging CurrentPerformanceStatus");
        purgeCurrentPerformanceStatus();
        logMessage("Completed Purging CurrentPerformanceStatus");

        logMessage("Start Generating CurrentPerformanceStatus");
        generateCurrentPerformanceStatus();
        logMessage("Start Generating CurrentPerformanceStatus");

        logMessage("Start Generating CurrentHeadwayStatus");
        generateCurrentHeadwayStatus();
        logMessage("Completed Generating CurrentHeadwayStatus");
    }
}
