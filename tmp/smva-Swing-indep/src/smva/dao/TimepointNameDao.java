/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import smva.jb.TimepointNameBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class TimepointNameDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public TimepointNameDao() {
        dbManager = new DBManager();
    }

    public TimepointNameDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }
    public TimepointNameBean load(int tpID) throws SQLException {
        TimepointNameBean timepointName = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT tp_id, tp_sname, tp_mname, tp_lname, tp_name_description" +
                " FROM timepoint_name" +
                " WHERE tp_id = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, tpID);
            result = pstmt.executeQuery();
            while (result.next()) {
                timepointName = new TimepointNameBean();
                timepointName.setTp_id(result.getInt(1));
                timepointName.setTp_sname(result.getString(2));
                timepointName.setTp_mname(result.getString(3));
                timepointName.setTp_lname(result.getString(2));
                timepointName.setTp_name_description(result.getString(3));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return timepointName;
    }
}
