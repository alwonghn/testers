/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.jb;

import java.sql.Timestamp;

/**
 *
 * @author alfred.wong
 */
public class IncidentLogBean {
    private int incident_log_id;
    private Timestamp incident_date_time;
    private String playback_date_time;
    private String transit_date_time;
    private int incident_code;
    private int incident_type;
    private int incident_status;
    private int vehicle_id;
    private int driver_id;
    private int block_id;
    private int route_id;
    private int run_id;
    private int current_route_id;
    private int dispatcher_id;
    private int priority;
    private int open_ir;
    private int incident_type_counter;
    private int deviation;
    private int trip_id;
    private int tp_id;
    private int next_tp_id;
    private int ea_state;
    private String last_incident_date_time;
    private String sched_time;
    private int direction_code_id;
    private int garage_id;
    private int sched_version;
    private int wkstn_id;
    private int user_handled;
    private String handled_datetime;
    private int geo_area_id;
    private String incident_details;
    private int vehicle_division_id;
    private int incident_owner;
    private String unpark_datetime;
    private int prepark_priority;
    private int prepark_status;
    private String logged_datetime;
    private int dispatcher_garage_id;
    private String incident_date_time_gmt;
    private int schedule_delta;

    public int getBlock_id() {
        return block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }

    public int getCurrent_route_id() {
        return current_route_id;
    }

    public void setCurrent_route_id(int current_route_id) {
        this.current_route_id = current_route_id;
    }

    public int getDeviation() {
        return deviation;
    }

    public void setDeviation(int deviation) {
        this.deviation = deviation;
    }

    public int getDirection_code_id() {
        return direction_code_id;
    }

    public void setDirection_code_id(int direction_code_id) {
        this.direction_code_id = direction_code_id;
    }

    public int getDispatcher_garage_id() {
        return dispatcher_garage_id;
    }

    public void setDispatcher_garage_id(int dispatcher_garage_id) {
        this.dispatcher_garage_id = dispatcher_garage_id;
    }

    public int getDispatcher_id() {
        return dispatcher_id;
    }

    public void setDispatcher_id(int dispatcher_id) {
        this.dispatcher_id = dispatcher_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getEa_state() {
        return ea_state;
    }

    public void setEa_state(int ea_state) {
        this.ea_state = ea_state;
    }

    public int getGarage_id() {
        return garage_id;
    }

    public void setGarage_id(int garage_id) {
        this.garage_id = garage_id;
    }

    public int getGeo_area_id() {
        return geo_area_id;
    }

    public void setGeo_area_id(int geo_area_id) {
        this.geo_area_id = geo_area_id;
    }

    public String getHandled_datetime() {
        return handled_datetime;
    }

    public void setHandled_datetime(String handled_datetime) {
        this.handled_datetime = handled_datetime;
    }

    public int getIncident_code() {
        return incident_code;
    }

    public void setIncident_code(int incident_code) {
        this.incident_code = incident_code;
    }

    public Timestamp getIncident_date_time() {
        return incident_date_time;
    }

    public void setIncident_date_time(Timestamp incident_date_time) {
        this.incident_date_time = incident_date_time;
    }

    public String getIncident_date_time_gmt() {
        return incident_date_time_gmt;
    }

    public void setIncident_date_time_gmt(String incident_date_time_gmt) {
        this.incident_date_time_gmt = incident_date_time_gmt;
    }

    public String getIncident_details() {
        return incident_details;
    }

    public void setIncident_details(String incident_details) {
        this.incident_details = incident_details;
    }

    public int getIncident_log_id() {
        return incident_log_id;
    }

    public void setIncident_log_id(int incident_log_id) {
        this.incident_log_id = incident_log_id;
    }

    public int getIncident_owner() {
        return incident_owner;
    }

    public void setIncident_owner(int incident_owner) {
        this.incident_owner = incident_owner;
    }

    public int getIncident_status() {
        return incident_status;
    }

    public void setIncident_status(int incident_status) {
        this.incident_status = incident_status;
    }

    public int getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(int incident_type) {
        this.incident_type = incident_type;
    }

    public int getIncident_type_counter() {
        return incident_type_counter;
    }

    public void setIncident_type_counter(int incident_type_counter) {
        this.incident_type_counter = incident_type_counter;
    }

    public String getLast_incident_date_time() {
        return last_incident_date_time;
    }

    public void setLast_incident_date_time(String last_incident_date_time) {
        this.last_incident_date_time = last_incident_date_time;
    }

    public String getLogged_datetime() {
        return logged_datetime;
    }

    public void setLogged_datetime(String logged_datetime) {
        this.logged_datetime = logged_datetime;
    }

    public int getNext_tp_id() {
        return next_tp_id;
    }

    public void setNext_tp_id(int next_tp_id) {
        this.next_tp_id = next_tp_id;
    }

    public int getOpen_ir() {
        return open_ir;
    }

    public void setOpen_ir(int open_ir) {
        this.open_ir = open_ir;
    }

    public String getPlayback_date_time() {
        return playback_date_time;
    }

    public void setPlayback_date_time(String playback_date_time) {
        this.playback_date_time = playback_date_time;
    }

    public int getPrepark_priority() {
        return prepark_priority;
    }

    public void setPrepark_priority(int prepark_priority) {
        this.prepark_priority = prepark_priority;
    }

    public int getPrepark_status() {
        return prepark_status;
    }

    public void setPrepark_status(int prepark_status) {
        this.prepark_status = prepark_status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getRun_id() {
        return run_id;
    }

    public void setRun_id(int run_id) {
        this.run_id = run_id;
    }

    public String getSched_time() {
        return sched_time;
    }

    public void setSched_time(String sched_time) {
        this.sched_time = sched_time;
    }

    public int getSched_version() {
        return sched_version;
    }

    public void setSched_version(int sched_version) {
        this.sched_version = sched_version;
    }

    public int getSchedule_delta() {
        return schedule_delta;
    }

    public void setSchedule_delta(int schedule_delta) {
        this.schedule_delta = schedule_delta;
    }

    public int getTp_id() {
        return tp_id;
    }

    public void setTp_id(int tp_id) {
        this.tp_id = tp_id;
    }

    public String getTransit_date_time() {
        return transit_date_time;
    }

    public void setTransit_date_time(String transit_date_time) {
        this.transit_date_time = transit_date_time;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getUnpark_datetime() {
        return unpark_datetime;
    }

    public void setUnpark_datetime(String unpark_datetime) {
        this.unpark_datetime = unpark_datetime;
    }

    public int getUser_handled() {
        return user_handled;
    }

    public void setUser_handled(int user_handled) {
        this.user_handled = user_handled;
    }

    public int getVehicle_division_id() {
        return vehicle_division_id;
    }

    public void setVehicle_division_id(int vehicle_division_id) {
        this.vehicle_division_id = vehicle_division_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getWkstn_id() {
        return wkstn_id;
    }

    public void setWkstn_id(int wkstn_id) {
        this.wkstn_id = wkstn_id;
    }

}
