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
public class BlockBean {

    private int block_id;
    private int route_id;
    private String block_name;
    private Timestamp reftime;
    private Timestamp start_time;
    private boolean nonschedule;
    private boolean nonscheduleactive;
    private int incident_log_id;
    private String status;
    private int run_id;
    private int garage_id;
    private boolean simulated;
    private int sim_vehicle_id;
    private int sim_operator_id;
    private String block_alpha;
    private int block_alpha_sort;
    private String pref_bus_series_1;
    private String pref_bus_series_2;
    private String pref_bus_series_3;
    private int yard_assignment_log_id;
    private Timestamp marked_for_deletion;

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

    public int getGarage_id() {
        return garage_id;
    }

    public void setGarage_id(int garage_id) {
        this.garage_id = garage_id;
    }

    public int getIncident_log_id() {
        return incident_log_id;
    }

    public void setIncident_log_id(int incident_log_id) {
        this.incident_log_id = incident_log_id;
    }

    public Timestamp getMarked_for_deletion() {
        return marked_for_deletion;
    }

    public void setMarked_for_deletion(Timestamp marked_for_deletion) {
        this.marked_for_deletion = marked_for_deletion;
    }

    public boolean isNonschedule() {
        return nonschedule;
    }

    public void setNonschedule(boolean nonschedule) {
        this.nonschedule = nonschedule;
    }

    public boolean isNonscheduleactive() {
        return nonscheduleactive;
    }

    public void setNonscheduleactive(boolean nonscheduleactive) {
        this.nonscheduleactive = nonscheduleactive;
    }

    public String getPref_bus_series_1() {
        return pref_bus_series_1;
    }

    public void setPref_bus_series_1(String pref_bus_series_1) {
        this.pref_bus_series_1 = pref_bus_series_1;
    }

    public String getPref_bus_series_2() {
        return pref_bus_series_2;
    }

    public void setPref_bus_series_2(String pref_bus_series_2) {
        this.pref_bus_series_2 = pref_bus_series_2;
    }

    public String getPref_bus_series_3() {
        return pref_bus_series_3;
    }

    public void setPref_bus_series_3(String pref_bus_series_3) {
        this.pref_bus_series_3 = pref_bus_series_3;
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

    public boolean isSimulated() {
        return simulated;
    }

    public void setSimulated(boolean simulated) {
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

    public int getYard_assignment_log_id() {
        return yard_assignment_log_id;
    }

    public void setYard_assignment_log_id(int yard_assignment_log_id) {
        this.yard_assignment_log_id = yard_assignment_log_id;
    }
    
}
