/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smva.dao;
import com.avms.util.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
/**
 *
 * @author alfred.wong
 */
public class UserLoginDao {
    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public UserLoginDao() {
        dbManager = new DBManager();
    }

    public UserLoginDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public int load(String ntLogin) throws SQLException {
        int userLoginID = 0;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT user_id" +
                " FROM user_login" +
                " WHERE nt_login = ? ";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, ntLogin);
            result = pstmt.executeQuery();
            while (result.next()) {
                userLoginID = result.getInt(1);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return userLoginID;
    }
}
