/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smva.dao;

import com.smva.jb.RoleBean;
import com.smva.jb.LoginPreferenceBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import com.avms.util.DBManager;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author alfred.wong
 */
public class RoleDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    //// CONSTRUCTORS

    public RoleDao() {
        dbManager = new DBManager();
    }

    public RoleDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    //// LOAD METHOD

    public ArrayList<RoleBean> load() throws SQLException {
        ArrayList<RoleBean> alRoleBean = new ArrayList<RoleBean> ();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM dbo.ROLE";

        try {
            dbConnection = dbManager.getConnection();
            ps = dbConnection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoleBean rb = new RoleBean();
                rb.setRole_ind(rs.getInt("role_ind"));
                rb.setRole_name(rs.getString("role_name"));
                rb.setRole_desc(rs.getString("role_desc"));
                rb.setSupervisor_role(rs.getBoolean("supervisor_role"));
                alRoleBean.add(rb);
            }
        } finally {
            dbManager.cleanup(dbConnection, ps, rs);
            dbConnection = null;
            ps = null;
            rs = null;
        }
        return alRoleBean;
    }


    

}
