package com.comfortdelgro.avms.jb;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author alfred.wong
 */
public class CurrentHeadwayStatusBean {
    private int route_id;
    private int block_id;
    private Timestamp transit_date_time;
    private int sched_version;
    private int headway_log_id;
    private int vehicle_id;
    private int run_id;
    private int direction_code_id;
    private int current_route_id;
    private int trip_id;
    private int last_tp_rte_hwmon_seq_num;
    private int next_tp_rte_hwmon_seq_num;
    private Timestamp last_tp_eta;
    private Timestamp next_tp_eta;
    private int scheduled_headway;
    private int actual_headway;
    private int actual_leader;
    private boolean warning_vehicle;
    private int warning_reason_id;
    private int incident_type;
    private int vehicle_planned_status;
    private int headway_status;
    private Timestamp ins_veh_start_time;
    private int predicted_deviation;
    private int operator_id;
    private int passenger_count;
    private int schedule_delta;

    public CurrentHeadwayStatusBean(){
        Calendar calDefaultDate = Calendar.getInstance();
        calDefaultDate.set(1977, 0, 1, 0, 0, 0);
        Date dtDefaultDate = calDefaultDate.getTime();
        Timestamp tsDefaultDate = new Timestamp(dtDefaultDate.getTime());

        route_id = 0;
        block_id = 0;
        transit_date_time = tsDefaultDate;
        sched_version = 0;
        headway_log_id = 0;

        vehicle_id = 0;
        run_id = 0;
        direction_code_id = 0;
        current_route_id = 0;
        trip_id = 0;

        last_tp_rte_hwmon_seq_num = 0;
        next_tp_rte_hwmon_seq_num = 0;
        last_tp_eta = tsDefaultDate;
        next_tp_eta = tsDefaultDate;
        scheduled_headway = 0;

        actual_headway = 0;
        actual_leader = 0;
        warning_vehicle = false;
        warning_reason_id = 0;
        incident_type = 0;

        vehicle_planned_status = 0;
        headway_status = 0;
        ins_veh_start_time = tsDefaultDate;
        predicted_deviation = 0;
        operator_id = 0;

        passenger_count = 0;
        schedule_delta = 0;
    }

    public int getActual_headway() {
        return actual_headway;
    }

    public void setActual_headway(int actual_headway) {
        this.actual_headway = actual_headway;
    }

    public int getActual_leader() {
        return actual_leader;
    }

    public void setActual_leader(int actual_leader) {
        this.actual_leader = actual_leader;
    }

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

    public int getDirection_code_id() {
        return direction_code_id;
    }

    public void setDirection_code_id(int direction_code_id) {
        this.direction_code_id = direction_code_id;
    }

    public int getHeadway_log_id() {
        return headway_log_id;
    }

    public void setHeadway_log_id(int headway_log_id) {
        this.headway_log_id = headway_log_id;
    }

    public int getHeadway_status() {
        return headway_status;
    }

    public void setHeadway_status(int headway_status) {
        this.headway_status = headway_status;
    }

    public int getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(int incident_type) {
        this.incident_type = incident_type;
    }

    public Timestamp getIns_veh_start_time() {
        return ins_veh_start_time;
    }

    public void setIns_veh_start_time(Timestamp ins_veh_start_time) {
        this.ins_veh_start_time = ins_veh_start_time;
    }

    public Timestamp getLast_tp_eta() {
        return last_tp_eta;
    }

    public void setLast_tp_eta(Timestamp last_tp_eta) {
        this.last_tp_eta = last_tp_eta;
    }

    public int getLast_tp_rte_hwmon_seq_num() {
        return last_tp_rte_hwmon_seq_num;
    }

    public void setLast_tp_rte_hwmon_seq_num(int last_tp_rte_hwmon_seq_num) {
        this.last_tp_rte_hwmon_seq_num = last_tp_rte_hwmon_seq_num;
    }

    public Timestamp getNext_tp_eta() {
        return next_tp_eta;
    }

    public void setNext_tp_eta(Timestamp next_tp_eta) {
        this.next_tp_eta = next_tp_eta;
    }

    public int getNext_tp_rte_hwmon_seq_num() {
        return next_tp_rte_hwmon_seq_num;
    }

    public void setNext_tp_rte_hwmon_seq_num(int next_tp_rte_hwmon_seq_num) {
        this.next_tp_rte_hwmon_seq_num = next_tp_rte_hwmon_seq_num;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }

    public int getPassenger_count() {
        return passenger_count;
    }

    public void setPassenger_count(int passenger_count) {
        this.passenger_count = passenger_count;
    }

    public int getPredicted_deviation() {
        return predicted_deviation;
    }

    public void setPredicted_deviation(int predicted_deviation) {
        this.predicted_deviation = predicted_deviation;
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

    public int getScheduled_headway() {
        return scheduled_headway;
    }

    public void setScheduled_headway(int scheduled_headway) {
        this.scheduled_headway = scheduled_headway;
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

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getVehicle_planned_status() {
        return vehicle_planned_status;
    }

    public void setVehicle_planned_status(int vehicle_planned_status) {
        this.vehicle_planned_status = vehicle_planned_status;
    }

    public int getWarning_reason_id() {
        return warning_reason_id;
    }

    public void setWarning_reason_id(int warning_reason_id) {
        this.warning_reason_id = warning_reason_id;
    }

    public boolean isWarning_vehicle() {
        return warning_vehicle;
    }

    public void setWarning_vehicle(boolean warning_vehicle) {
        this.warning_vehicle = warning_vehicle;
    }
}
