/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novasprint.dao;

import com.novasprint.jb.ProductBean;
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
public class ProductDao {

    private DBManager dbManager;
    private Connection dbConnection;

    public ProductDao(DataSource supplierPortalDS) {
        dbManager = new DBManager(supplierPortalDS);
    }

    //select
    /**
     * Load record from product table by primary key
     */
    public ProductBean load(String product_code) {
        PreparedStatement pstmt = null;
        ResultSet result = null;
        ProductBean productbean = null;

        String query = "SELECT product_code, product_name, product_desc," + "status, created_by, created_date FROM product" + "WHERE product_code = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, product_code);//set input parameter
            result = pstmt.executeQuery();

            while (result.next()) {
                productbean = new ProductBean();
                productbean.setProduct_code(result.getString(1));
                productbean.setProduct_name(result.getString(2));
                productbean.setProduct_desc(result.getString(3));
                productbean.setStatus(result.getInt(4));
                productbean.setCreated_by(result.getString(5));
                productbean.setCreated_date(result.getTimestamp(6));
            }
        } catch (SQLException sqlex) {
            throw new RuntimeException(sqlex);
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return productbean;
    }

    //insert
    /**
     * Insert record to product table
     */
    public void create(ProductBean productbean) {
        PreparedStatement pstmt = null;

        String sql = "INSERT into product(product_code,product_name,product_desc," +
                "status,created_by,created_date)" +
                "values(?,?,?,?,?,?)";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(sql);
            pstmt.setString(1, productbean.getProduct_code()); //set input parameter
            pstmt.setString(2, productbean.getProduct_name());
            pstmt.setString(3, productbean.getProduct_desc());
            pstmt.setInt(4, productbean.getStatus());
            pstmt.setString(5, productbean.getCreated_by());
            pstmt.setTimestamp(6, productbean.getCreatedDate());
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
    public void store(ProductBean productBean) {
    }

    //delete
    public void remove() {
    }
}
