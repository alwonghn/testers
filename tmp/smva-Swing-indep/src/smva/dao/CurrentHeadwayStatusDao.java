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
import smva.jb.CurrentHeadwayStatusBean;
import smva.jb.RunningVehicleBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class CurrentHeadwayStatusDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public CurrentHeadwayStatusDao() {
        dbManager = new DBManager();
    }

    public CurrentHeadwayStatusDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public CurrentHeadwayStatusBean load(int routeID, int blockID) throws SQLException {
        CurrentHeadwayStatusBean currentHeadwayStatus = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select route_id, block_id, transit_date_time, sched_version, headway_log_id, vehicle_id, run_id, direction_code_id," +
                " current_route_id, trip_id, last_tp_rte_hwmon_seq_num, next_tp_rte_hwmon_seq_num, last_tp_eta, next_tp_eta, scheduled_headway," +
                " actual_headway, actual_leader, warning_vehicle, warning_reason_id, incident_type, vehicle_planned_status, headway_status," +
                " ins_veh_start_time, predicted_deviation, operator_id, passenger_count, schedule_delta" +
                " from current_headway_status" +
                " where headway_log_id =" +
                " (select max(headway_log_id) from headway_log" +
                " where route_id = ? and block_id = ?)";
        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, routeID);
            pstmt.setInt(2, blockID);
            result = pstmt.executeQuery();
            while (result.next()) {
                currentHeadwayStatus = new CurrentHeadwayStatusBean();
                currentHeadwayStatus.setRoute_id(result.getInt(1));
                currentHeadwayStatus.setBlock_id(result.getInt(2));
                currentHeadwayStatus.setTransit_date_time(result.getTimestamp(3));
                currentHeadwayStatus.setSched_version(result.getInt(4));
                currentHeadwayStatus.setHeadway_log_id(result.getInt(5));
                currentHeadwayStatus.setVehicle_id(result.getInt(6));
                currentHeadwayStatus.setRun_id(result.getInt(7));
                currentHeadwayStatus.setDirection_code_id(result.getInt(8));
                currentHeadwayStatus.setCurrent_route_id(result.getInt(9));
                currentHeadwayStatus.setTrip_id(result.getInt(10));
                currentHeadwayStatus.setLast_tp_rte_hwmon_seq_num(result.getInt(11));
                currentHeadwayStatus.setNext_tp_rte_hwmon_seq_num(result.getInt(12));
                currentHeadwayStatus.setLast_tp_eta(result.getTimestamp(13));
                currentHeadwayStatus.setNext_tp_eta(result.getTimestamp(14));
                currentHeadwayStatus.setScheduled_headway(result.getInt(15));
                currentHeadwayStatus.setActual_headway(result.getInt(16));
                currentHeadwayStatus.setActual_leader(result.getInt(17));
                currentHeadwayStatus.setWarning_vehicle(result.getBoolean(18));
                currentHeadwayStatus.setWarning_reason_id(result.getInt(19));
                currentHeadwayStatus.setIncident_type(result.getInt(20));
                currentHeadwayStatus.setVehicle_planned_status(result.getInt(21));
                currentHeadwayStatus.setHeadway_status(result.getInt(22));
                currentHeadwayStatus.setIns_veh_start_time(result.getTimestamp(23));
                currentHeadwayStatus.setPredicted_deviation(result.getInt(24));
                currentHeadwayStatus.setOperator_id(result.getInt(25));
                currentHeadwayStatus.setPassenger_count(result.getInt(26));
                currentHeadwayStatus.setSchedule_delta(result.getInt(27));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return currentHeadwayStatus;
    }

    public ArrayList<RunningVehicleBean> loadRunningVehicle(int routeID, int dirCode) throws SQLException {
        ArrayList<RunningVehicleBean> runningVehicleList = new ArrayList<RunningVehicleBean>();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select a.route_id,a.direction_code_id,a.trip_id,a.last_tp_rte_hwmon_seq_num,a.next_tp_rte_hwmon_seq_num," +
                " a.scheduled_headway,a.actual_headway,a.passenger_count,b.seq_num,b.distance,c.passenger_capacity" +
                " from current_headway_status a, trip_timepoint b,vehicle_static_info c" +
                " where a.trip_id = b.trip_id" +
                " and a.last_tp_rte_hwmon_seq_num = b.rte_hwmon_seq_num" +
                " and a.vehicle_id = c.vehicle_id" +
                " and a.route_id = ?" +
                " and a.current_route_id = ?" +
                " and a.direction_code_id = ?" +
                " order by a.trip_id desc";
        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, routeID);
            pstmt.setInt(2, routeID);
            pstmt.setInt(3, dirCode);
            result = pstmt.executeQuery();
            while (result.next()) {
                RunningVehicleBean runningVehicle = new RunningVehicleBean();
                runningVehicle.setRoute_id(result.getInt(1));
                runningVehicle.setDirection_code_id(result.getInt(2));
                runningVehicle.setTrip_id(result.getInt(3));
                runningVehicle.setLast_tp_rte_hwmon_seq_num(result.getInt(4));
                runningVehicle.setNext_tp_rte_hwmon_seq_num(result.getInt(5));
                runningVehicle.setScheduled_headway(result.getInt(6));
                runningVehicle.setActual_headway(result.getInt(7));
                runningVehicle.setPassenger_count(result.getInt(8));
                runningVehicle.setSeq_num(result.getInt(9));
                runningVehicle.setDistance(result.getInt(10));
                runningVehicle.setPassenger_capacity(result.getInt(11));
                runningVehicleList.add(runningVehicle);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return runningVehicleList;
    }
}
