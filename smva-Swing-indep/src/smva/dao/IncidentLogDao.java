/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import smva.jb.IncidentLogBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class IncidentLogDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public IncidentLogDao() {
        dbManager = new DBManager();
    }

    public IncidentLogDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public IncidentLogBean loadByIncidentID(int incidentLogID) throws SQLException {
        IncidentLogBean incidentLog = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT incident_log_id, incident_date_time, playback_date_time, transit_date_time, incident_code," +
                " incident_type, incident_status, vehicle_id, driver_id, block_id, route_id, run_id, current_route_id," +
                " dispatcher_id, priority, open_ir, incident_type_counter, deviation, trip_id, tp_id, next_tp_id, ea_state," +
                " last_incident_date_time, sched_time, direction_code_id, garage_id, sched_version, wkstn_id, user_handled," +
                " handled_datetime, geo_area_id, incident_details, vehicle_division_id, incident_owner" +
                " FROM incident_log" +
                " WHERE incident_log_id = ? ";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, incidentLogID);
            result = pstmt.executeQuery();
            while (result.next()) {
                incidentLog = new IncidentLogBean();
                incidentLog.setIncident_log_id(result.getInt(1));
                incidentLog.setIncident_date_time(result.getTimestamp(2));
                incidentLog.setPlayback_date_time(result.getString(3));
                incidentLog.setTransit_date_time(result.getString(4));
                incidentLog.setIncident_code(result.getInt(5));
                incidentLog.setIncident_type(result.getInt(6));
                incidentLog.setIncident_status(result.getInt(7));
                incidentLog.setVehicle_id(result.getInt(8));
                incidentLog.setDriver_id(result.getInt(9));
                incidentLog.setBlock_id(result.getInt(10));
                incidentLog.setRoute_id(result.getInt(11));
                incidentLog.setRun_id(result.getInt(12));
                incidentLog.setCurrent_route_id(result.getInt(13));
                incidentLog.setDispatcher_id(result.getInt(14));
                incidentLog.setPriority(result.getInt(15));
                incidentLog.setOpen_ir(result.getInt(16));
                incidentLog.setIncident_type_counter(result.getInt(17));
                incidentLog.setDeviation(result.getInt(18));
                incidentLog.setTrip_id(result.getInt(19));
                incidentLog.setTp_id(result.getInt(20));
                incidentLog.setNext_tp_id(result.getInt(21));
                incidentLog.setEa_state(result.getInt(22));
                incidentLog.setLast_incident_date_time(result.getString(23));
                incidentLog.setSched_time(result.getString(24));
                incidentLog.setDirection_code_id(result.getInt(25));
                incidentLog.setGarage_id(result.getInt(26));
                incidentLog.setSched_version(result.getInt(27));
                incidentLog.setWkstn_id(result.getInt(28));
                incidentLog.setUser_handled(result.getInt(29));
                incidentLog.setHandled_datetime(result.getString(30));
                incidentLog.setGeo_area_id(result.getInt(31));
                incidentLog.setIncident_details(result.getString(32));
                incidentLog.setVehicle_division_id(result.getInt(33));
                incidentLog.setIncident_owner(result.getInt(34));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return incidentLog;
    }

    public ArrayList<IncidentLogBean> load(int userID, String groupID, String iq_pq_ind, String routeID) throws SQLException {
        ArrayList<IncidentLogBean> incidentLogList = new ArrayList<IncidentLogBean>();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT incident_log_id, incident_date_time, playback_date_time, transit_date_time, incident_code," +
                " incident_type, incident_status, vehicle_id, driver_id, block_id, route_id, run_id, current_route_id," +
                " dispatcher_id, priority, open_ir, incident_type_counter, deviation, trip_id, tp_id, next_tp_id, ea_state," +
                " last_incident_date_time, sched_time, direction_code_id, garage_id, sched_version, wkstn_id, user_handled," +
                " handled_datetime, geo_area_id, incident_details, vehicle_division_id, incident_owner" +
                " FROM incident_log" +
                " WHERE incident_log_id in" +
                " (select incident_log_id from current_performance_status where current_route_id in (select route_id from work_assignment_criteria wac, route r" +
                " where wa_id in(" +
                " select wa_id from work_assignment_name" +
                " where wa_id in(" +
                " select wa_id from work_groups" +
                " where group_id in(" +
                " select c.group_id from cad_user a,role b,work_group_roles c,work_group_names d" +
                " where user_id = ?" +
                " and a.role_ind = b.role_ind" +
                " and c.role_ind = a.role_ind" +
                " and c.group_id = d.group_id" +
                " and group_active = 1" +
                " and c.group_id in (" +
                groupID +
                ")))" +
                " and iq_pq_ind = ?)" +
                " and wac.wa_source = r.route_id" +
                " group by route_id))" +
                " and route_id in(" +
                routeID +
                ")";
        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, userID);
            pstmt.setString(2, iq_pq_ind);
            result = pstmt.executeQuery();
            while (result.next()) {
                IncidentLogBean incidentLog = new IncidentLogBean();
                incidentLog.setIncident_log_id(result.getInt(1));
                incidentLog.setIncident_date_time(result.getTimestamp(2));
                incidentLog.setPlayback_date_time(result.getString(3));
                incidentLog.setTransit_date_time(result.getString(4));
                incidentLog.setIncident_code(result.getInt(5));
                incidentLog.setIncident_type(result.getInt(6));
                incidentLog.setIncident_status(result.getInt(7));
                incidentLog.setVehicle_id(result.getInt(8));
                incidentLog.setDriver_id(result.getInt(9));
                incidentLog.setBlock_id(result.getInt(10));
                incidentLog.setRoute_id(result.getInt(11));
                incidentLog.setRun_id(result.getInt(12));
                incidentLog.setCurrent_route_id(result.getInt(13));
                incidentLog.setDispatcher_id(result.getInt(14));
                incidentLog.setPriority(result.getInt(15));
                incidentLog.setOpen_ir(result.getInt(16));
                incidentLog.setIncident_type_counter(result.getInt(17));
                incidentLog.setDeviation(result.getInt(18));
                incidentLog.setTrip_id(result.getInt(19));
                incidentLog.setTp_id(result.getInt(20));
                incidentLog.setNext_tp_id(result.getInt(21));
                incidentLog.setEa_state(result.getInt(22));
                incidentLog.setLast_incident_date_time(result.getString(23));
                incidentLog.setSched_time(result.getString(24));
                incidentLog.setDirection_code_id(result.getInt(25));
                incidentLog.setGarage_id(result.getInt(26));
                incidentLog.setSched_version(result.getInt(27));
                incidentLog.setWkstn_id(result.getInt(28));
                incidentLog.setUser_handled(result.getInt(29));
                incidentLog.setHandled_datetime(result.getString(30));
                incidentLog.setGeo_area_id(result.getInt(31));
                incidentLog.setIncident_details(result.getString(32));
                incidentLog.setVehicle_division_id(result.getInt(33));
                incidentLog.setIncident_owner(result.getInt(34));
                incidentLogList.add(incidentLog);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return incidentLogList;
    }
}
