/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import smva.jb.VehicleStaticInfoBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class VehicleStaticInfoDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public VehicleStaticInfoDao() {
        dbManager = new DBManager();
    }

    public VehicleStaticInfoDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public VehicleStaticInfoBean load(int vehicleID) throws SQLException {
        VehicleStaticInfoBean vehicleStaticInfo = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select vehicle_id, vehicle_indentification_nbr, license_nbr, model_year, passenger_capacity, wheel_chair_access," +
                " gps_equipped, camera_equipped, sleep_mode, vlu_equipped, vlu_version, vlu_serial_nbr, radio_serial_num, radio_make_id," +
                " vehicle_make_id, garage_id, vehicle_type, vehicle_series, marked_for_deletion" +
                " from vehicle_static_info" +
                " where vehicle_id = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, vehicleID);
            result = pstmt.executeQuery();
            while (result.next()) {
                vehicleStaticInfo = new VehicleStaticInfoBean();
                vehicleStaticInfo.setVehicle_id(result.getInt(1));
                vehicleStaticInfo.setVehicle_indentification_nbr(result.getString(2));
                vehicleStaticInfo.setLicense_nbr(result.getString(3));
                vehicleStaticInfo.setModel_year(result.getInt(4));
                vehicleStaticInfo.setPassenger_capacity(result.getInt(5));
                vehicleStaticInfo.setWheel_chair_access(result.getBoolean(6));
                vehicleStaticInfo.setGps_equipped(result.getBoolean(7));
                vehicleStaticInfo.setCamera_equipped(result.getBoolean(8));
                vehicleStaticInfo.setSleep_mode(result.getBoolean(9));
                vehicleStaticInfo.setVlu_equipped(result.getBoolean(10));
                vehicleStaticInfo.setVlu_version(result.getString(11));
                vehicleStaticInfo.setVlu_serial_nbr(result.getString(12));
                vehicleStaticInfo.setRadio_serial_num(result.getString(13));
                vehicleStaticInfo.setRadio_make_id(result.getInt(14));
                vehicleStaticInfo.setVehicle_make_id(result.getInt(15));
                vehicleStaticInfo.setGarage_id(result.getInt(16));
                vehicleStaticInfo.setVehicle_type(result.getInt(17));
                vehicleStaticInfo.setVehicle_series(result.getString(18));
                vehicleStaticInfo.setMarked_for_deletion(result.getTimestamp(19));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return vehicleStaticInfo;
    }
}
