/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import java.sql.SQLException;
import smva.jb.LoginPreferenceBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class LoginPreferenceDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    //// CONSTRUCTORS

    public LoginPreferenceDao() {
        dbManager = new DBManager();
    }

    public LoginPreferenceDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    //// LOAD METHOD

    public LoginPreferenceBean load(int userID) throws SQLException {
        LoginPreferenceBean loginPreference = new LoginPreferenceBean();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT user_id,group_id,route_id" +
                " FROM login_preference" +
                " WHERE user_id = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, userID);
            result = pstmt.executeQuery();
            while (result.next()) {
                loginPreference.setUser_id(result.getInt(1));
                loginPreference.setGroup_id(result.getString(2));
                loginPreference.setRoute_id(result.getString(3));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return loginPreference;
    }

    public void remove(int userID) throws SQLException {
        PreparedStatement pstmt = null;
        String query = "DELETE FROM login_preference WHERE user_id = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
        } finally {
            dbManager.cleanup(dbConnection, pstmt);
            dbConnection = null;
            pstmt = null;
        }
    }

    public void create(LoginPreferenceBean loginPreference) throws SQLException {
        PreparedStatement pstmt = null;
        String query = "INSERT INTO login_preference " +
                "(user_id, group_id, route_id) VALUES (?,?,?)";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, loginPreference.getUser_id());
            pstmt.setString(2, loginPreference.getGroup_id());
            pstmt.setString(3, loginPreference.getRoute_id());
            pstmt.executeUpdate();
        } finally {
            dbManager.cleanup(dbConnection, pstmt);
            dbConnection = null;
            pstmt = null;
        }
    }

    public void update(int userID, String groupID, String routeID) throws SQLException {
        PreparedStatement pstmt = null;
        String query = "UPDATE login_preference SET" +
                " group_id = ?," +
                " route_id = ?" +
                " where user_id = ?";
        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, groupID);
            pstmt.setString(2, routeID);
            pstmt.setInt(3, userID);
            pstmt.executeUpdate();
        } finally {
            dbManager.cleanup(dbConnection, pstmt);
            dbConnection = null;
            pstmt = null;
        }
    }
    

}
