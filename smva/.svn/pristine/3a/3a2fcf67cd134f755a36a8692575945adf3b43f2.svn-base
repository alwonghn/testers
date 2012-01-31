/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avms.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author alfred.wong
 */
public class DBManager {

    private int connectionType;
    private final int RESOURCE_LOOKUP = 1;    //set the connectionType flag to 1 if rl is used
    private final int RESOURCE_INJECTION = 2;  // set the connectionType flag to 2 if ri is used
    private String DB_NAME;
    private final String DS_JNDI_NAME = "jdbc/AVMS";
    private DataSource AVMS;

    //// CONSTRUCTORS
    // first overload constructor : when db connection will be created using resource lookup
    public DBManager() {
        // if this constructor is called, the 'connectionType' variable is set to RL
        connectionType = RESOURCE_LOOKUP;
        // for RL: need to differentiate between JBoss-RL or non-JBoss-RL vary the DB_NAME according to whether JBoss is the app server
        if (AVMSConstant.APP_SVR_USED.equalsIgnoreCase(AVMSConstant.JBOSS)) {
            DB_NAME = "java:/" + DS_JNDI_NAME;
        } else {
            DB_NAME = DS_JNDI_NAME;
        }
    }

    // second overload constructor : when db connection will be created using resource injection:  pass in the ds 
    public DBManager(DataSource AVMS) {
        // if this constructor is called, the 'connectionType' variable is set to RI
        connectionType = RESOURCE_INJECTION;
        this.AVMS = AVMS;
    }

    //// CONNECTION GETTER
    /**
     * wrong imagery "Returns a connection from connection pool".
     * should be: "get a connection according to the connection type (1 or 2) set .."
     * "...by the choice of overloaded class constructor of the caller  / .."
     * AND return it
     */
    public Connection getConnection() {
        Connection connection;

        try {
            if (connectionType == RESOURCE_INJECTION) {
                connection = AVMS.getConnection();
            } else {
                InitialContext ic = new InitialContext();
                DataSource ds = (DataSource) ic.lookup(DB_NAME);
                connection = ds.getConnection();
            }
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

    //// CLEANUP METHODS
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
}
