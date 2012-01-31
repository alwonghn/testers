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
import smva.jb.VehiclePositionLogBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class VehiclePositionLogDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public VehiclePositionLogDao() {
        dbManager = new DBManager();
    }

    public VehiclePositionLogDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public VehiclePositionLogBean load(int vehicleID) throws SQLException {
        VehiclePositionLogBean vehiclePositionLog = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select a.vehicle_position_log_id, a.vehicle_position_date_time, a.vehicle_id, a.loc_x, a.loc_y, a.heading, a.average_speed," +
                " a.predicted_deviation, a.playback_date_time" +
                " from vehicle_position_log a, current_performance_status b" +
                " where a.vehicle_position_log_id = b.incident_log_id" +
                " and a.vehicle_id = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, vehicleID);
            result = pstmt.executeQuery();
            while (result.next()) {
                vehiclePositionLog = new VehiclePositionLogBean();
                vehiclePositionLog.setVehicle_position_log_id(result.getInt(1));
                vehiclePositionLog.setVehicle_position_date_time(result.getTimestamp(2));
                vehiclePositionLog.setVehicle_id(result.getInt(3));
                vehiclePositionLog.setLoc_x(result.getFloat(4));
                vehiclePositionLog.setLoc_y(result.getFloat(5));
                vehiclePositionLog.setHeading(result.getInt(6));
                vehiclePositionLog.setAverage_speed(result.getInt(7));
                vehiclePositionLog.setPredicted_deviation(result.getInt(8));
                vehiclePositionLog.setPlayback_date_time(result.getTimestamp(9));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return vehiclePositionLog;
    }
}
