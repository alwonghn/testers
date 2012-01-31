/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.novasprint.util;

import java.io.Serializable;
import java.sql.Connection;//?? check
import java.sql.PreparedStatement;//?? check
import java.sql.ResultSet;// ?? check
import java.sql.SQLException;
import javax.sql.DataSource;//

/**
 *
 * @author alfred.wong
 */
public class DBManager implements Serializable {

    private DataSource supplierPortalDS;

    public DBManager(DataSource supplierPortalDS){

    }

    /**
     * Returns a connection from connection pool.
     * @return
     */

    public Connection getConnection(){

        Connection connection;

        try{
            connection = supplierPortalDS.getConnection();
            return connection;
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
    }

    /**
     * Releases the connection back to pool.
     * Releases resources back for garbage collection.
     * @param con
     */

    public void cleanup(Connection con){
        try{
            if(con !=null){
                con.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void cleanup(Connection con, PreparedStatement pstmt){
        try{
            if(pstmt !=null){
                pstmt.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        try{
            if(con !=null){
                con.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void cleanup(PreparedStatement pstmt, ResultSet rs){
        try{
            if(rs !=null){
                rs.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        try{
            if(pstmt !=null){
                pstmt.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void cleanup(Connection con, PreparedStatement pstmt,ResultSet rs){
        try{
            if(rs !=null){
                rs.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        try{
            if(pstmt !=null){
                pstmt.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        try{
            if(con !=null){
                con.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
