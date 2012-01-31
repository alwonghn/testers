/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.jb;

/**
 *
 * @author alfred.wong
 */
public class RunningVehicleBean {
    private int route_id;
    private int direction_code_id;
    private int trip_id;
    private int last_tp_rte_hwmon_seq_num;
    private int next_tp_rte_hwmon_seq_num;
    private int scheduled_headway;
    private int actual_headway;
    private int passenger_count;
    private int seq_num;
    private int distance;
    private int passenger_capacity;

    public int getActual_headway() {
        return actual_headway;
    }

    public void setActual_headway(int actual_headway) {
        this.actual_headway = actual_headway;
    }

    public int getDirection_code_id() {
        return direction_code_id;
    }

    public void setDirection_code_id(int direction_code_id) {
        this.direction_code_id = direction_code_id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getLast_tp_rte_hwmon_seq_num() {
        return last_tp_rte_hwmon_seq_num;
    }

    public void setLast_tp_rte_hwmon_seq_num(int last_tp_rte_hwmon_seq_num) {
        this.last_tp_rte_hwmon_seq_num = last_tp_rte_hwmon_seq_num;
    }

    public int getNext_tp_rte_hwmon_seq_num() {
        return next_tp_rte_hwmon_seq_num;
    }

    public void setNext_tp_rte_hwmon_seq_num(int next_tp_rte_hwmon_seq_num) {
        this.next_tp_rte_hwmon_seq_num = next_tp_rte_hwmon_seq_num;
    }

    public int getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setPassenger_capacity(int passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }

    public int getPassenger_count() {
        return passenger_count;
    }

    public void setPassenger_count(int passenger_count) {
        this.passenger_count = passenger_count;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getScheduled_headway() {
        return scheduled_headway;
    }

    public void setScheduled_headway(int scheduled_headway) {
        this.scheduled_headway = scheduled_headway;
    }

    public int getSeq_num() {
        return seq_num;
    }

    public void setSeq_num(int seq_num) {
        this.seq_num = seq_num;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    
}
