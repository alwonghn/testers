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
public class CurrentPerformanceStatusBean {

    private int block_id;
    private int route_id;
    private Timestamp transit_date_time;
    private int incident_log_id;
    private String block_name;
    private int simulated;
    private String block_alpha;
    private int block_alpha_sort;
    private int nonschedule;
    private int nonscheduleactive;
    private Timestamp reftime;
    private Timestamp start_time;
    private int sim_vehicle_id;
    private int sim_operator_id;
    private int yard_assignment_log_id;
    private int run_id;
    private int vehicle_id;
    private int driver_id;
    private int deviation;
    private int direction_code_id;
    private int incident_type;
    private int priority;
    private Timestamp sched_time;
    private Timestamp incident_date_time;
    private int current_route_id;
    private int vehicle_division_id;
    private int garage_id;
    private int geo_area_id;
    private String incident_details;
    private int trip_id;
    private int sched_version;
    private int dispatcher_id;
    private int next_tp_id;
    private int tp_id;
    private String status;
    private int schedule_delta;
    private int passenger_count;
    private int block_num;
    private Timestamp block_start;
    private Timestamp block_end;
    private int sched_mod_id;
    private String sched_mod_name;

    public String getBlock_alpha() {
        return block_alpha;
    }

    public void setBlock_alpha(String block_alpha) {
        this.block_alpha = block_alpha;
    }

    public int getBlock_alpha_sort() {
        return block_alpha_sort;
    }

    public void setBlock_alpha_sort(int block_alpha_sort) {
        this.block_alpha_sort = block_alpha_sort;
    }

    public Timestamp getBlock_end() {
        return block_end;
    }

    public void setBlock_end(Timestamp block_end) {
        this.block_end = block_end;
    }

    public int getBlock_id() {
        return block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }

    public String getBlock_name() {
        return block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    public int getBlock_num() {
        return block_num;
    }

    public void setBlock_num(int block_num) {
        this.block_num = block_num;
    }

    public Timestamp getBlock_start() {
        return block_start;
    }

    public void setBlock_start(Timestamp block_start) {
        this.block_start = block_start;
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

    public Timestamp getIncident_date_time() {
        return incident_date_time;
    }

    public void setIncident_date_time(Timestamp incident_date_time) {
        this.incident_date_time = incident_date_time;
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

    public int getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(int incident_type) {
        this.incident_type = incident_type;
    }

    public int getNext_tp_id() {
        return next_tp_id;
    }

    public void setNext_tp_id(int next_tp_id) {
        this.next_tp_id = next_tp_id;
    }

    public int getNonschedule() {
        return nonschedule;
    }

    public void setNonschedule(int nonschedule) {
        this.nonschedule = nonschedule;
    }

    public int getNonscheduleactive() {
        return nonscheduleactive;
    }

    public void setNonscheduleactive(int nonscheduleactive) {
        this.nonscheduleactive = nonscheduleactive;
    }

    public int getPassenger_count() {
        return passenger_count;
    }

    public void setPassenger_count(int passenger_count) {
        this.passenger_count = passenger_count;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Timestamp getReftime() {
        return reftime;
    }

    public void setReftime(Timestamp reftime) {
        this.reftime = reftime;
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

    public int getSched_mod_id() {
        return sched_mod_id;
    }

    public void setSched_mod_id(int sched_mod_id) {
        this.sched_mod_id = sched_mod_id;
    }

    public String getSched_mod_name() {
        return sched_mod_name;
    }

    public void setSched_mod_name(String sched_mod_name) {
        this.sched_mod_name = sched_mod_name;
    }

    public Timestamp getSched_time() {
        return sched_time;
    }

    public void setSched_time(Timestamp sched_time) {
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

    public int getSim_operator_id() {
        return sim_operator_id;
    }

    public void setSim_operator_id(int sim_operator_id) {
        this.sim_operator_id = sim_operator_id;
    }

    public int getSim_vehicle_id() {
        return sim_vehicle_id;
    }

    public void setSim_vehicle_id(int sim_vehicle_id) {
        this.sim_vehicle_id = sim_vehicle_id;
    }

    public int getSimulated() {
        return simulated;
    }

    public void setSimulated(int simulated) {
        this.simulated = simulated;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTp_id() {
        return tp_id;
    }

    public void setTp_id(int tp_id) {
        this.tp_id = tp_id;
    }

    public Timestamp getTransit_date_time() {
        return transit_date_time;
    }

    public void setTransit_date_time(Timestamp transit_date_time) {
        this.transit_date_time = transit_date_time;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
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

    public int getYard_assignment_log_id() {
        return yard_assignment_log_id;
    }

    public void setYard_assignment_log_id(int yard_assignment_log_id) {
        this.yard_assignment_log_id = yard_assignment_log_id;
    }

    
}
