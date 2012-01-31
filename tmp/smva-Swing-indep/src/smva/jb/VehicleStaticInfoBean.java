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
public class VehicleStaticInfoBean {
    private int vehicle_id;
    private String vehicle_indentification_nbr;
    private String license_nbr;
    private int model_year;
    private int passenger_capacity;
    private boolean wheel_chair_access;
    private boolean gps_equipped;
    private boolean camera_equipped;
    private boolean sleep_mode;
    private boolean vlu_equipped;
    private String vlu_version;
    private String vlu_serial_nbr;
    private String radio_serial_num;
    private int radio_make_id;
    private int vehicle_make_id;
    private int garage_id;
    private int vehicle_type;
    private String vehicle_series;
    private Timestamp marked_for_deletion;

    public boolean isCamera_equipped() {
        return camera_equipped;
    }

    public void setCamera_equipped(boolean camera_equipped) {
        this.camera_equipped = camera_equipped;
    }

    public int getGarage_id() {
        return garage_id;
    }

    public void setGarage_id(int garage_id) {
        this.garage_id = garage_id;
    }

    public boolean isGps_equipped() {
        return gps_equipped;
    }

    public void setGps_equipped(boolean gps_equipped) {
        this.gps_equipped = gps_equipped;
    }

    public String getLicense_nbr() {
        return license_nbr;
    }

    public void setLicense_nbr(String license_nbr) {
        this.license_nbr = license_nbr;
    }

    public Timestamp getMarked_for_deletion() {
        return marked_for_deletion;
    }

    public void setMarked_for_deletion(Timestamp marked_for_deletion) {
        this.marked_for_deletion = marked_for_deletion;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public int getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setPassenger_capacity(int passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }

    public int getRadio_make_id() {
        return radio_make_id;
    }

    public void setRadio_make_id(int radio_make_id) {
        this.radio_make_id = radio_make_id;
    }

    public String getRadio_serial_num() {
        return radio_serial_num;
    }

    public void setRadio_serial_num(String radio_serial_num) {
        this.radio_serial_num = radio_serial_num;
    }

    public boolean isSleep_mode() {
        return sleep_mode;
    }

    public void setSleep_mode(boolean sleep_mode) {
        this.sleep_mode = sleep_mode;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_indentification_nbr() {
        return vehicle_indentification_nbr;
    }

    public void setVehicle_indentification_nbr(String vehicle_indentification_nbr) {
        this.vehicle_indentification_nbr = vehicle_indentification_nbr;
    }

    public int getVehicle_make_id() {
        return vehicle_make_id;
    }

    public void setVehicle_make_id(int vehicle_make_id) {
        this.vehicle_make_id = vehicle_make_id;
    }

    public String getVehicle_series() {
        return vehicle_series;
    }

    public void setVehicle_series(String vehicle_series) {
        this.vehicle_series = vehicle_series;
    }

    public int getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(int vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public boolean isVlu_equipped() {
        return vlu_equipped;
    }

    public void setVlu_equipped(boolean vlu_equipped) {
        this.vlu_equipped = vlu_equipped;
    }

    public String getVlu_serial_nbr() {
        return vlu_serial_nbr;
    }

    public void setVlu_serial_nbr(String vlu_serial_nbr) {
        this.vlu_serial_nbr = vlu_serial_nbr;
    }

    public String getVlu_version() {
        return vlu_version;
    }

    public void setVlu_version(String vlu_version) {
        this.vlu_version = vlu_version;
    }

    public boolean isWheel_chair_access() {
        return wheel_chair_access;
    }

    public void setWheel_chair_access(boolean wheel_chair_access) {
        this.wheel_chair_access = wheel_chair_access;
    }
    
}
