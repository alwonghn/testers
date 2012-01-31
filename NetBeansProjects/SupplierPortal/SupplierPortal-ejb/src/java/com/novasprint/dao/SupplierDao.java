/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novasprint.dao;

import com.novasprint.jb.SupplierBean;
import com.novasprint.util.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author alfred.wong
 */
public class SupplierDao {

    private DBManager dbManager;
    private Connection dbConnection;

    public SupplierDao(DataSource supplierPortalDS) {
        dbManager = new DBManager(supplierPortalDS);
    }

    // select
    /**
     * Load record from supplier table by primary key
     */
    public SupplierBean load(String supplier_reg_code) {

        PreparedStatement pstmt = null;
        ResultSet result = null;
        SupplierBean supplierbean = null;

        String query = "SELECT supplier_reg_code,supplier_name,supplier_address,supplier_website" + "status,created_by,created_date FROM supplier" + "WHERE supplier_reg_code = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, supplier_reg_code);//set input parameter
            result = pstmt.executeQuery();

            while (result.next()) {
                supplierbean = new SupplierBean();
                supplierbean.setSupplier_reg_code(result.getString(1));
                supplierbean.setSupplier_name(result.getString(2));
                supplierbean.setSupplier_address(result.getString(3));
                supplierbean.setSupplier_website(result.getString(4));
                supplierbean.setStatus(result.getInt(5));
                supplierbean.setCreated_by(result.getString(6));
                supplierbean.setCreated_date(result.getTimestamp(7));
            }
        } catch (SQLException sqlex) {
            throw new RuntimeException(sqlex);
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return supplierbean;

    } //end of load


    // insert
    /**
     * Insert record to supplier table
     */
    public void create (SupplierBean supplierbean){

        PreparedStatement pstmt = null;

        String sql = "INSERT into supplier(supplier_reg_code,supplier_name,supplier_address,supplier_website," +
                "status,created_by,created_date)" +
                "values(?,?,?,?,?,?,?)";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(sql);
            pstmt.setString(1, supplierbean.getSupplier_reg_code()); //set input parameter
            pstmt.setString(2, supplierbean.getSupplier_name());
            pstmt.setString(3, supplierbean.getSupplier_address());
            pstmt.setString(4, supplierbean.getSupplier_website());
            pstmt.setInt(5, supplierbean.getStatus());
            pstmt.setString(6, supplierbean.getCreated_by());
            pstmt.setTimestamp(7, supplierbean.getCreated_date());
            pstmt.executeUpdate();
        } catch (SQLException sqlex) {
            throw new RuntimeException(sqlex);
        } finally {
            dbManager.cleanup(dbConnection, pstmt);
            dbConnection = null;
            pstmt = null;
        }
    }

    //update
    public void store(SupplierBean supplierBean) {

    }

    //delete
    public void remove() {
        
    }

}
