/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LoggerBasic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

/**
 *
 * http://www.roseindia.net/java/example/java/util/quintessential-logging-program.shtml
 */
public class Main {
    private static Logger logger;
    static String loggerName = "AVMSBatchEngine";
    static String logFilePath = "C:\\LoggerTest\\LogTester.log";
    /**
     * @param args the command line arguments
     */
    public static void logMessage(String message) {
        String messageText;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        messageText = "AVMS Daily Batch " + dateFormat.format(date) + " : " + message;
        logger.warning("warning messageText"+messageText);
        logger.info("info messageText"+messageText);        
        logger.severe("severe messageText"+messageText);
    }

    public static void main(String[] args) {
        logger = Logger.getLogger(loggerName);
        // using appender :
        //FileAppender appender = null;
        // using handler :
        FileHandler handler = null;
        try {
            // using appender :
            //appender = new FileAppender(new PatternLayout(), logFilePath);
            // using handler :
            handler = new FileHandler("test.log");
            //handler = new FileHandler("test.log", 2, 8); // constructor(String pattern, int limit, int count)
        } catch(Exception e) {
        }
        // using appender :
        // logger.addAppender(appender);
        // using handler :
        logger.addHandler(handler);
        logMessage("AVMSDailyBatch Job Start");
    }

}
