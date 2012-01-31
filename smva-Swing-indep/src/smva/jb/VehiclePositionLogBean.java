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
public class VehiclePositionLogBean {
    private int vehicle_position_log_id;
    private Timestamp vehicle_position_date_time;
    private int vehicle_id;
    private float loc_x;
    private float loc_y;
    private int heading;
    private int average_speed;
    private int predicted_deviation;
    private Timestamp playback_date_time;

    public int getAverage_speed() {
        return average_speed;
    }

    public void setAverage_speed(int average_speed) {
        this.average_speed = average_speed;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public float getLoc_x() {
        return loc_x;
    }

    public void setLoc_x(float loc_x) {
        this.loc_x = loc_x;
    }

    public float getLoc_y() {
        return loc_y;
    }

    public void setLoc_y(float loc_y) {
        this.loc_y = loc_y;
    }

    public Timestamp getPlayback_date_time() {
        return playback_date_time;
    }

    public void setPlayback_date_time(Timestamp playback_date_time) {
        this.playback_date_time = playback_date_time;
    }

    public int getPredicted_deviation() {
        return predicted_deviation;
    }

    public void setPredicted_deviation(int predicted_deviation) {
        this.predicted_deviation = predicted_deviation;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public Timestamp getVehicle_position_date_time() {
        return vehicle_position_date_time;
    }

    public void setVehicle_position_date_time(Timestamp vehicle_position_date_time) {
        this.vehicle_position_date_time = vehicle_position_date_time;
    }

    public int getVehicle_position_log_id() {
        return vehicle_position_log_id;
    }

    public void setVehicle_position_log_id(int vehicle_position_log_id) {
        this.vehicle_position_log_id = vehicle_position_log_id;
    }

    
}
