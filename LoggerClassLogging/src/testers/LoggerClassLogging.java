/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

/**
 *
 * @author alfred.wong
 */
public class LoggerClassLogging {

    static void updateDboTablesFrTTables(){
        try {
            blkDao.updateDboBlock();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AVMSDailyBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
