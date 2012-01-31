package com.comfortdelgro.avms.dao;
import com.comfortdelgro.avms.jb.CurrentHeadwayStatusBean;
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
 * @author alfred.wong
 */
public class CurrentHeadwayStatusDao {
    protected DBManager dbManager;
    protected Connection con = null;

    public CurrentHeadwayStatusDao(){
        dbManager = new DBManager();
    }

    @SuppressWarnings("static-access")
    public void purge() throws SQLException {
        PreparedStatement ps = null;
        String sql = "DELETE current_headway_status " +
                "FROM current_headway_status INNER JOIN current_performance_status ON " +
                "current_performance_status.block_id = current_headway_status.block_id AND " +
                "current_performance_status.route_id = current_headway_status.route_id AND " +
                "current_performance_status.transit_date_time = current_headway_status.transit_date_time " +
                "WHERE current_performance_status.block_end < ? ";

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
    public ArrayList<CurrentHeadwayStatusBean> loadChws() throws SQLException {
        ArrayList<CurrentHeadwayStatusBean> alChws = new ArrayList<CurrentHeadwayStatusBean>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT " +
                        "block_id, route_id, transit_date_time, " +
                        "run_id, vehicle_id, direction_code_id, " +
                        "incident_type, current_route_id, " +
                        "trip_id, " +
                        "sched_version, " +
                        "schedule_delta, passenger_count " +
                        "FROM current_performance_status";
        try{
            con = dbManager.getMSSQLJDBCConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                CurrentHeadwayStatusBean chwsBean = new CurrentHeadwayStatusBean();
                chwsBean.setRoute_id(rs.getInt("route_id"));
                chwsBean.setBlock_id(rs.getInt("block_id"));
                chwsBean.setTransit_date_time(rs.getTimestamp("transit_date_time"));
                chwsBean.setSched_version(rs.getInt("sched_version"));
                chwsBean.setVehicle_id(rs.getInt("vehicle_id"));
                chwsBean.setRun_id(rs.getInt("run_id"));
                chwsBean.setDirection_code_id(rs.getInt("direction_code_id"));
                chwsBean.setCurrent_route_id(rs.getInt("current_route_id"));
                chwsBean.setTrip_id(rs.getInt("trip_id"));
                chwsBean.setIncident_type(rs.getInt("incident_type"));
                chwsBean.setPassenger_count(rs.getInt("passenger_count"));
                chwsBean.setSchedule_delta(rs.getInt("schedule_delta"));
                alChws.add(chwsBean);
            }
        }finally{
            ps.close();
            con.close();
        }
        return alChws;
    }

    @SuppressWarnings("static-access")
    public void insertChws(ArrayList<CurrentHeadwayStatusBean> alChws) throws SQLException {
            PreparedStatement ps;
            String sql = "INSERT INTO current_headway_status " +
                            "( route_id, block_id, transit_date_time, sched_version, headway_log_id, " +
                            "vehicle_id, run_id, direction_code_id, current_route_id, trip_id, " +
                            "last_tp_rte_hwmon_seq_num, next_tp_rte_hwmon_seq_num, last_tp_eta, next_tp_eta, scheduled_headway, " +
                            "actual_headway, actual_leader, warning_vehicle, warning_reason_id, incident_type, " +
                            "vehicle_planned_status, headway_status, ins_veh_start_time, predicted_deviation, operator_id, " +
                            "passenger_count, schedule_delta ) " +

                            "VALUES ( ?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?)";
            try {
                con = dbManager.getMSSQLJDBCConnection();
                for(CurrentHeadwayStatusBean chwsBean : alChws){
                    ps = null;
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, chwsBean.getRoute_id());
                    ps.setInt(2, chwsBean.getBlock_id());
                    ps.setTimestamp(3, chwsBean.getTransit_date_time());
                    ps.setInt(4, chwsBean.getSched_version());
                    ps.setInt(5, chwsBean.getHeadway_log_id());
                    ps.setInt(6, chwsBean.getVehicle_id());
                    ps.setInt(7, chwsBean.getRun_id());
                    ps.setInt(8, chwsBean.getDirection_code_id());
                    ps.setInt(9, chwsBean.getCurrent_route_id());
                    ps.setInt(10, chwsBean.getTrip_id());
                    ps.setInt(11, chwsBean.getLast_tp_rte_hwmon_seq_num());
                    ps.setInt(12, chwsBean.getNext_tp_rte_hwmon_seq_num());
                    ps.setTimestamp(13, chwsBean.getLast_tp_eta());
                    ps.setTimestamp(14, chwsBean.getNext_tp_eta());
                    ps.setInt(15, chwsBean.getScheduled_headway());
                    ps.setInt(16, chwsBean.getActual_headway());
                    ps.setInt(17, chwsBean.getActual_leader());
                    ps.setBoolean(18, chwsBean.isWarning_vehicle());
                    ps.setInt(19, chwsBean.getWarning_reason_id());
                    ps.setInt(20, chwsBean.getIncident_type());
                    ps.setInt(21, chwsBean.getVehicle_planned_status());
                    ps.setInt(22, chwsBean.getHeadway_status());
                    ps.setTimestamp(23, chwsBean.getIns_veh_start_time());
                    ps.setInt(24, chwsBean.getPredicted_deviation());
                    ps.setInt(25, chwsBean.getOperator_id());
                    ps.setInt(26, chwsBean.getPassenger_count());
                    ps.setInt(27, chwsBean.getSchedule_delta());
                    ps.executeUpdate();
                    ps.close();
                }
            } finally {
                con.close();
            }
    }
}
