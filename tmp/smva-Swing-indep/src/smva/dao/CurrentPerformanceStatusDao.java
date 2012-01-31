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
import smva.jb.CurrentPerformanceStatusBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class CurrentPerformanceStatusDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public CurrentPerformanceStatusDao() {
        dbManager = new DBManager();
    }

    public CurrentPerformanceStatusDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public ArrayList<CurrentPerformanceStatusBean> load(int userID, String groupID, String iq_pq_ind, String routeID) throws SQLException {
        ArrayList<CurrentPerformanceStatusBean> currentPerformanceStatusList = new ArrayList<CurrentPerformanceStatusBean>();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT block_id,route_id,transit_date_time,incident_log_id,block_name,simulated,block_alpha,block_alpha_sort," +
                " nonschedule,nonscheduleactive,reftime,start_time,sim_vehicle_id,sim_operator_id,yard_assignment_log_id,run_id,vehicle_id," +
                " driver_id,deviation,direction_code_id,incident_type,priority,sched_time,incident_date_time,current_route_id," +
                " vehicle_division_id,garage_id,geo_area_id,incident_details,trip_id,sched_version,dispatcher_id,next_tp_id,tp_id,status," +
                " schedule_delta,passenger_count,block_num,block_start,block_end,sched_mod_id,sched_mod_name" +
                " from current_performance_status" +
                " where current_route_id in (select route_id from work_assignment_criteria wac, route r" +
                " where wa_id in(select wa_id from work_assignment_name" +
                " where wa_id in(select wa_id from work_groups" +
                " where group_id in(select c.group_id from cad_user a,role b,work_group_roles c,work_group_names d" +
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
                " group by route_id)" +
                " and route_id in(" +
                routeID +
                ")";
        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, userID);
//            pstmt.setString(2, groupID);
            pstmt.setString(2, iq_pq_ind);
            result = pstmt.executeQuery();
            while (result.next()) {
                CurrentPerformanceStatusBean currentPerformanceStatus = new CurrentPerformanceStatusBean();
                currentPerformanceStatus.setBlock_id(result.getInt(1));
                currentPerformanceStatus.setRoute_id(result.getInt(2));
                currentPerformanceStatus.setTransit_date_time(result.getTimestamp(3));
                currentPerformanceStatus.setIncident_log_id(result.getInt(4));
                currentPerformanceStatus.setBlock_name(result.getString(5));
                currentPerformanceStatus.setSimulated(result.getInt(6));
                currentPerformanceStatus.setBlock_alpha(result.getString(7));
                currentPerformanceStatus.setBlock_alpha_sort(result.getInt(8));
                currentPerformanceStatus.setNonschedule(result.getInt(9));
                currentPerformanceStatus.setNonscheduleactive(result.getInt(10));
                currentPerformanceStatus.setReftime(result.getTimestamp(11));
                currentPerformanceStatus.setStart_time(result.getTimestamp(12));
                currentPerformanceStatus.setSim_vehicle_id(result.getInt(13));
                currentPerformanceStatus.setSim_operator_id(result.getInt(14));
                currentPerformanceStatus.setYard_assignment_log_id(result.getInt(15));
                currentPerformanceStatus.setRun_id(result.getInt(16));
                currentPerformanceStatus.setVehicle_id(result.getInt(17));
                currentPerformanceStatus.setDriver_id(result.getInt(18));
                currentPerformanceStatus.setDeviation(result.getInt(19));
                currentPerformanceStatus.setDirection_code_id(result.getInt(20));
                currentPerformanceStatus.setIncident_type(result.getInt(21));
                currentPerformanceStatus.setPriority(result.getInt(22));
                currentPerformanceStatus.setSched_time(result.getTimestamp(23));
                currentPerformanceStatus.setIncident_date_time(result.getTimestamp(24));
                currentPerformanceStatus.setCurrent_route_id(result.getInt(25));
                currentPerformanceStatus.setVehicle_division_id(result.getInt(26));
                currentPerformanceStatus.setGarage_id(result.getInt(27));
                currentPerformanceStatus.setGeo_area_id(result.getInt(28));
                currentPerformanceStatus.setIncident_details(result.getString(29));
                currentPerformanceStatus.setTrip_id(result.getInt(30));
                currentPerformanceStatus.setSched_version(result.getInt(31));
                currentPerformanceStatus.setDispatcher_id(result.getInt(32));
                currentPerformanceStatus.setNext_tp_id(result.getInt(33));
                currentPerformanceStatus.setTp_id(result.getInt(34));
                currentPerformanceStatus.setStatus(result.getString(35));
                currentPerformanceStatus.setSchedule_delta(result.getInt(36));
                currentPerformanceStatus.setPassenger_count(result.getInt(37));
                currentPerformanceStatus.setBlock_num(result.getInt(38));
                currentPerformanceStatus.setBlock_start(result.getTimestamp(39));
                currentPerformanceStatus.setBlock_end(result.getTimestamp(40));
                currentPerformanceStatus.setSched_mod_id(result.getInt(41));
                currentPerformanceStatus.setSched_mod_name(result.getString(42));

                currentPerformanceStatusList.add(currentPerformanceStatus);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return currentPerformanceStatusList;
    }
}
