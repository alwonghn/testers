package com.comfortdelgro.avms.dao;
import com.comfortdelgro.avms.jb.CurrentPerformanceStatusBean;
import com.comfortdelgro.avms.util.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author angck
 */
public class CurrentPerformanceStatusDao {
    protected DBManager dbManager;
    protected Connection con = null;

    public CurrentPerformanceStatusDao(){
        dbManager = new DBManager();
    }

    @SuppressWarnings("static-access")
    public void purge() throws SQLException {
        PreparedStatement ps = null;
        String sql = "delete from current_performance_status where current_performance_status.block_end < ?";
        Calendar calTday0000 = Calendar.getInstance();
        calTday0000.set(Calendar.HOUR_OF_DAY, 0);
        calTday0000.set(Calendar.MINUTE, 0);
        calTday0000.set(Calendar.SECOND, 0);
        calTday0000.set(Calendar.MILLISECOND, 0);
        Date dtTday0000 = calTday0000.getTime();
        Timestamp tsTday0000 = new Timestamp(dtTday0000.getTime());
        try {
            con = dbManager.getMSSQLJDBCConnection();
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, tsTday0000);
            ps.executeUpdate();
        } finally {
            ps.close();
            con.close();
        }
    }

    @SuppressWarnings("static-access")
    public ArrayList<CurrentPerformanceStatusBean> loadCps () throws SQLException {
        ArrayList<CurrentPerformanceStatusBean> alCps = new ArrayList<CurrentPerformanceStatusBean>();
        PreparedStatement ps = null;
        ResultSet rs = null;
/*
// SQL PROD
        String sql_prod = "SELECT " +
                "a.block_id, a.route_id, getdate() transit_date_time, b.block_name, " +
                "b.block_alpha, b.block_alpha_sort, " +
                "b.reftime, b.start_time, b.sim_vehicle_id, b.sim_operator_id, b.yard_assignment_log_id, " +
                "b.run_id, " +
                "getdate() sched_time, getdate() incident_date_time, " +
                "a.sched_version, b.status, " +
                "a.block_num, DATEADD(DAY, DATEDIFF(DD, a.block_start, getdate()),a.block_start) block_start, DATEADD(DAY, DATEDIFF( DD, a.block_start, getdate() ), a.block_end) block_end " +
                "FROM block_sched a INNER JOIN block b ON a.block_id = b.block_id AND a.route_id = b.route_id AND service_days = 62 " +
                "where a.sched_version = ( select convert(varchar, booking_num)+ '1' from booking where convert(DATETIME, '20/09/2011', 103) between start_date and end_date )";
*/
// SQL TEST 157
        String sql_test = "SELECT " +
                "a.block_id, a.route_id, getdate() transit_date_time, b.block_name, " +
//                "a.block_id, a.route_id, CONVERT(DATETIME, getdate(), 103) transit_date_time, b.block_name, " +
                "b.block_alpha, b.block_alpha_sort, " +
                "b.reftime, b.start_time, b.sim_vehicle_id, b.sim_operator_id, b.yard_assignment_log_id, " +
                "b.run_id, " +
                "getdate() sched_time, getdate() incident_date_time, " +
                "a.sched_version, b.status, " +
                "a.block_num, DATEADD(DAY, DATEDIFF(DD,a.block_start, getdate()),a.block_start) block_start,  DATEADD(DAY, DATEDIFF( DD, a.block_start, getdate() ),a.block_end) block_end " +
                "FROM block_sched a INNER JOIN block b ON a.block_id = b.block_id AND a.route_id = b.route_id " +
                "WHERE a.sched_version = ( select convert(varchar, booking_num)+ '1' from booking where convert(DATETIME, '20/09/2011', 103) between start_date and end_date) " +
                "and a.route_id = 157 " +
                "order by block_id" ;
        try{
            con = dbManager.getMSSQLJDBCConnection();
            ps = con.prepareStatement(sql_test);
            rs = ps.executeQuery();
            while(rs.next()){
                CurrentPerformanceStatusBean pfsBean = new CurrentPerformanceStatusBean();
/*
// FOR SQL_PROD
                pfsBean.setBlock_id(rs.getInt("block_id"));
                pfsBean.setRoute_id(rs.getInt("route_id"));
                pfsBean.setTransit_date_time(rs.getTimestamp("transit_date_time"));
                pfsBean.setBlock_name(rs.getString("block_name"));
                pfsBean.setBlock_alpha(rs.getString("block_alpha"));
                pfsBean.setBlock_alpha_sort(rs.getInt("block_alpha_sort"));
                pfsBean.setReftime(rs.getTimestamp("reftime"));
                pfsBean.setStart_time(rs.getTimestamp("start_time"));
                pfsBean.setSim_vehicle_id(rs.getInt("sim_vehicle_id"));
                pfsBean.setSim_operator_id(rs.getInt("sim_operator_id"));
                pfsBean.setYard_assignment_log_id(rs.getInt("yard_assignment_log_id"));
                pfsBean.setRun_id(rs.getInt("run_id"));
                pfsBean.setSched_time(rs.getTimestamp("sched_time"));
                pfsBean.setIncident_date_time(rs.getTimestamp("incident_date_time"));
                pfsBean.setSched_version(rs.getInt("sched_version"));
                pfsBean.setStatus(rs.getString("status"));
                pfsBean.setBlock_num(rs.getInt("block_num"));
                pfsBean.setBlock_start(rs.getTimestamp("block_start"));
                pfsBean.setBlock_end(rs.getTimestamp("block_end"));
*/
// FOR SQL_TEST 157
                pfsBean.setBlock_id(rs.getInt("block_id"));
                pfsBean.setRoute_id(rs.getInt("route_id"));
                pfsBean.setTransit_date_time(rs.getTimestamp("transit_date_time"));
                pfsBean.setBlock_name(rs.getString("block_name"));
                pfsBean.setBlock_alpha(rs.getString("block_alpha"));
                pfsBean.setBlock_alpha_sort(rs.getInt("block_alpha_sort"));
                pfsBean.setReftime(rs.getTimestamp("reftime"));
                pfsBean.setStart_time(rs.getTimestamp("start_time"));
                pfsBean.setSim_vehicle_id(rs.getInt("sim_vehicle_id"));
                pfsBean.setSim_operator_id(rs.getInt("sim_operator_id"));
                pfsBean.setYard_assignment_log_id(rs.getInt("yard_assignment_log_id"));
                pfsBean.setRun_id(rs.getInt("run_id"));
                pfsBean.setSched_time(rs.getTimestamp("sched_time"));
                pfsBean.setIncident_date_time(rs.getTimestamp("incident_date_time"));
                pfsBean.setSched_version(rs.getInt("sched_version"));
                pfsBean.setStatus(rs.getString("status"));
                pfsBean.setBlock_num(rs.getInt("block_num"));
                pfsBean.setBlock_start(rs.getTimestamp("block_start"));
                pfsBean.setBlock_end(rs.getTimestamp("block_end"));
                alCps.add(pfsBean);
            }
        }finally{
            ps.close();
            con.close();
        }
        return alCps;
    }

    @SuppressWarnings("static-access")
    public void insertCps(ArrayList<CurrentPerformanceStatusBean> alCps) throws SQLException {
            PreparedStatement ps;
            String sql = "INSERT INTO current_performance_status " +
                            "(block_id, route_id, transit_date_time, incident_log_id, block_name, " +
                            "simulated, block_alpha, block_alpha_sort, nonschedule, nonscheduleactive," +
                            "reftime, start_time, sim_vehicle_id, sim_operator_id, yard_assignment_log_id, " +
                            "run_id, vehicle_id, driver_id, deviation, direction_code_id, " +
                            "incident_type, priority, sched_time, incident_date_time, current_route_id, " +
                            "vehicle_division_id, garage_id, geo_area_id, incident_details, trip_id,  " +
                            "sched_version, dispatcher_id, next_tp_id, tp_id, status, " +
                            "schedule_delta, passenger_count, block_num, block_start, block_end, " +
                            " sched_mod_name, sched_mod_id )" +
                            "VALUES(?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?)";
            try {
                con = dbManager.getMSSQLJDBCConnection();
                for(CurrentPerformanceStatusBean cpsBean : alCps){
                    ps = null;
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, cpsBean.getBlock_id());
                    ps.setInt(2, cpsBean.getRoute_id());
                    Timestamp tsTdt = cpsBean.getTransit_date_time();
                    Date dtTdt = new Date(tsTdt.getTime());
                    Calendar calTdt000 = Calendar.getInstance();
                    calTdt000.setTime(dtTdt);
                    calTdt000.set(Calendar.HOUR, 0);
                    calTdt000.set(Calendar.HOUR_OF_DAY, 0);
                    calTdt000.set(Calendar.MINUTE, 0);
                    calTdt000.set(Calendar.SECOND, 0);
                    calTdt000.set(Calendar.MILLISECOND, 0);
                    calTdt000.set(Calendar.AM_PM, 0);
                    Date dtTdt000 = calTdt000.getTime();
                    Timestamp tsTdt000 = new Timestamp(dtTdt000.getTime());
                    ps.setTimestamp(3, tsTdt000);
                    ps.setInt(4, cpsBean.getIncident_log_id());
                    ps.setString(5, cpsBean.getBlock_name());
                    ps.setBoolean(6, cpsBean.isSimulated());
                    ps.setString(7, cpsBean.getBlock_alpha());
                    ps.setInt(8, cpsBean.getBlock_alpha_sort());
                    ps.setBoolean(9, cpsBean.isNonschedule());
                    ps.setBoolean(10, cpsBean.isNonscheduleactive());
                    ps.setTimestamp(11, cpsBean.getReftime());
                    ps.setTimestamp(12, cpsBean.getStart_time());
                    ps.setInt(13, cpsBean.getSim_vehicle_id());
                    ps.setInt(14, cpsBean.getSim_operator_id());
                    ps.setInt(15, cpsBean.getYard_assignment_log_id());
                    ps.setInt(16, cpsBean.getRun_id());
                    ps.setInt(17, cpsBean.getVehicle_id());
                    ps.setInt(18, cpsBean.getDriver_id());
                    ps.setInt(19, cpsBean.getDeviation());
                    ps.setInt(20, cpsBean.getDirection_code_id());
                    ps.setInt(21, cpsBean.getIncident_type());
                    ps.setInt(22, cpsBean.getPriority());
                    ps.setTimestamp(23, cpsBean.getSched_time());
                    ps.setTimestamp(24, cpsBean.getIncident_date_time());
                    ps.setInt(25, cpsBean.getCurrent_route_id());
                    ps.setInt(26, cpsBean.getVehicle_division_id());
                    ps.setInt(27, cpsBean.getGarage_id());
                    ps.setInt(28, cpsBean.getGeo_area_id());
                    ps.setString(29, cpsBean.getIncident_details());
                    ps.setInt(30, cpsBean.getTrip_id());
                    ps.setInt(31, cpsBean.getSched_version());
                    ps.setInt(32, cpsBean.getDispatcher_id());
                    ps.setInt(33, cpsBean.getNext_tp_id());
                    ps.setInt(34, cpsBean.getTp_id());
                    ps.setString(35, cpsBean.getStatus());
                    ps.setInt(36, cpsBean.getSchedule_delta());
                    ps.setInt(37, cpsBean.getPassenger_count());
                    ps.setInt(38, cpsBean.getBlock_num());
                    ps.setTimestamp(39, cpsBean.getBlock_start());
                    ps.setTimestamp(40, cpsBean.getBlock_end());
                    ps.setInt(41, cpsBean.getSched_mod_id());
                    ps.setString(42, cpsBean.getSched_mod_name());
                    ps.executeUpdate();
                    ps.close();
                }
            } finally {
                con.close();
            }
    }
}

