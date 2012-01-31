/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.dao;



import com.test.jb.UsersBean;
import com.test.util.DBManager_prod;
import com.test.util.DBManager_simple_direct;
import com.test.util.DBManager_simple_ri;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author a
 */
public class UsersDao {

    protected Connection dbConnection = null;
    //protected DBManager_prod dbManager;
    protected DBManager_simple_ri dbManager;
    //protected DBManager_simple_direct dbManager;

    // CONSTRUCTOR 1
    public UsersDao() {
        //dbManager = new DBManager_prod();
        //dbManager = new DBManager_simple_direct();
    }

    // CONSTRUCTOR 2
    public UsersDao(DataSource DS) {
        //dbManager = new DBManager_prod(AVMS);
        dbManager = new DBManager_simple_ri(DS);
    }


    // LOAD METHOD
    public ArrayList<UsersBean> load() throws SQLException {
        UsersBean uBean = new UsersBean();
        ArrayList<UsersBean> uBeanList = new ArrayList<UsersBean>();
        PreparedStatement pstmt = null;
        ResultSet result = null;

        String query = "SELECT userid, passwd" +
                " FROM dbo.jms_users";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            //pstmt.setString(1, ntLogin);
            result = pstmt.executeQuery();
            while (result.next()) {
                //userLoginID = result.getInt(1);
                uBean.setUserid(result.getString(1));
                uBean.setPasswd(result.getString(2));
                uBeanList.add(uBean);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return uBeanList; //// return arraylist
    }









}  // END OF CLASS
