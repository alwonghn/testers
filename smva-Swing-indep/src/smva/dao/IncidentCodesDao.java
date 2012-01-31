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
import smva.jb.IncidentCodesBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class IncidentCodesDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public IncidentCodesDao() {
        dbManager = new DBManager();
    }

    public IncidentCodesDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public IncidentCodesBean load(int incidentType, int incidentCode) throws SQLException {
        IncidentCodesBean incidentCodes = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select incident_type, incident_code, message_text, marked_for_deletion" +
                " from incident_codes" +
                " where incident_type = ?" +
                " and incident_code = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, incidentType);
            pstmt.setInt(2, incidentCode);
            result = pstmt.executeQuery();
            while (result.next()) {
                incidentCodes = new IncidentCodesBean();
                incidentCodes.setIncident_type(result.getInt(1));
                incidentCodes.setIncident_code(result.getInt(2));
                incidentCodes.setMessage_text(result.getString(3));
                incidentCodes.setMarked_for_deletion(result.getTimestamp(4));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return incidentCodes;
    }
}
