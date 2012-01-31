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
import smva.jb.IncidentTypesBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class IncidentTypesDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public IncidentTypesDao() {
        dbManager = new DBManager();
    }

    public IncidentTypesDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public IncidentTypesBean load(int incidentType) throws SQLException {
        IncidentTypesBean incidentTypes = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT incident_type, incident_name, incident_desc" +
                " FROM incident_types" +
                " WHERE incident_type = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, incidentType);
            result = pstmt.executeQuery();
            while (result.next()) {
                incidentTypes = new IncidentTypesBean();
                incidentTypes.setIncident_type(result.getInt(1));
                incidentTypes.setIncident_name(result.getString(2));
                incidentTypes.setIncident_desc(result.getString(3));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return incidentTypes;
    }
}
