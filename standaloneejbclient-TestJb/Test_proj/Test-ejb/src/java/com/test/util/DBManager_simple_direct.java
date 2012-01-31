/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author a
 */



public class DBManager_simple_direct {

        private final int RESOURCE_LOOKUP = 1;
        //private final int RESOURCE_INJECTION = 2;

        //// DETERMINE THE DataSource's JNDI NAME
        private final String DS_JNDI_NAME = "jdbc/AVMS";

        private String DB_NAME;
        //private DataSource AVMS;
        private DataSource DS;
        private int connectionType;



        // CONSTRUCTOR 2: TO INDICATE RESOURCE LOOKUP IS CALLED
        public DBManager_simple_direct() {

            connectionType = 1; //RESOURCE_LOOKUP

            //// DETERMINE THE DATABASE NAME STRING

            //if (TestConstant.APP_SVR_USED.equalsIgnoreCase(TestConstant.JBOSS)) {
            if (TestConstant.APP_SVR_USED.equalsIgnoreCase("JBOSS")) {
                // should test for just equals a value
                DB_NAME = "java:/" + DS_JNDI_NAME;

            } else {
                DB_NAME = DS_JNDI_NAME;  //non jboss app svrs dont use "java:/"
            }
            

        } // END OF





        public Connection getConnection() {
        Connection connection;

        try {

                InitialContext ic = new InitialContext();
                DataSource ds = (DataSource) ic.lookup(DB_NAME);
                connection = ds.getConnection();

            return connection;
        } catch (SQLException se) {
            //Convert SQLException into checked exception, if the client code is expected to recuperate
            //Convert SQLException into unchecked exception, if client code cannot do anything about it
            throw new RuntimeException(se);
        } catch (NamingException nex) {
            //Convert NamingException into checked exception, if the client code is expected to recuperate
            //Convert NamingException into unchecked exception, if client code cannot do anything about it
            throw new RuntimeException(nex);
        }
    }



//// CONNECTION CLEANUP METHODS

    /**
     * Releases the connection back to pool.
     */
    public void cleanup(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Releases the connection back to pool.
     * Releases resources back for garbage collection.
     */
    public void cleanup(Connection con, Statement stmt) {

        try {
            if (stmt != null) {
                stmt.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Releases the connection back to pool.
     * Releases resources back for garbage collection.
     */
    public void cleanup(Connection con, PreparedStatement pstmt) {

        try {
            if (pstmt != null) {
                pstmt.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Releases the connection back to pool.
     * Releases resources back for garbage collection.
     */
    public void cleanup(PreparedStatement pstmt) {

        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Releases the connection back to pool.
     * Releases resources back for garbage collection.
     */
    public void cleanup(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Releases the connection back to pool.
     * Releases resources back for garbage collection.
     */
    public void cleanup(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Releases the connection back to pool.
     * Releases resources back for garbage collection.
     */
    public void cleanup(Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Releases the connection back to pool.
     * Releases resources back for garbage collection.
     */
    public void cleanup(PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }





} // END OF CLASS
