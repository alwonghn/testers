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
import smva.jb.BlockBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class BlockDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public BlockDao() {
        dbManager = new DBManager();
    }

    public BlockDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public BlockBean load(int blockID, int routeID) throws SQLException {
        BlockBean block = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT block_id, route_id, block_name, reftime, start_time, nonschedule, nonscheduleactive, incident_log_id," +
                " status, run_id, garage_id, simulated, sim_vehicle_id, sim_operator_id, block_alpha, block_alpha_sort, pref_bus_series_1," +
                " pref_bus_series_2, pref_bus_series_3, yard_assignment_log_id, marked_for_deletion" +
                " FROM block" +
                " WHERE block_id = ? AND route_id = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, blockID);
            pstmt.setInt(2, routeID);
            result = pstmt.executeQuery();
            while (result.next()) {
                block = new BlockBean();
                block.setBlock_id(result.getInt(1));
                block.setRoute_id(result.getInt(2));
                block.setBlock_name(result.getString(3));
                block.setReftime(result.getTimestamp(4));
                block.setStart_time(result.getTimestamp(5));
                block.setNonschedule(result.getBoolean(6));
                block.setNonscheduleactive(result.getBoolean(7));
                block.setIncident_log_id(result.getInt(8));
                block.setStatus(result.getString(9));
                block.setRun_id(result.getInt(10));
                block.setGarage_id(result.getInt(11));
                block.setSimulated(result.getBoolean(12));
                block.setSim_vehicle_id(result.getInt(13));
                block.setSim_operator_id(result.getInt(14));
                block.setBlock_alpha(result.getString(15));
                block.setBlock_alpha_sort(result.getInt(16));
                block.setPref_bus_series_1(result.getString(17));
                block.setPref_bus_series_2(result.getString(18));
                block.setPref_bus_series_3(result.getString(19));
                block.setYard_assignment_log_id(result.getInt(20));
                block.setMarked_for_deletion(result.getTimestamp(21));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return block;
    }
}
