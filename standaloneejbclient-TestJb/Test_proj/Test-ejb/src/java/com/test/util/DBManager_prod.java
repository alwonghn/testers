/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.util;

/**
 *
 * @author a
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author allan.lee
 */
public class DBManager_prod {

    private final int RESOURCE_LOOKUP = 1;
    private final int RESOURCE_INJECTION = 2;
    private final String DS_JNDI_NAME = "jdbc/AVMS";
    private String DB_NAME;
    private DataSource AVMS;
    private int connectionType;

    // CONSTRUCTOR 1
    public DBManager_prod() {
        connectionType = RESOURCE_LOOKUP;
        if (TestConstant.APP_SVR_USED.equalsIgnoreCase(TestConstant.JBOSS)) {
            DB_NAME = "java:/" + DS_JNDI_NAME;
        } else {
            DB_NAME = DS_JNDI_NAME;
        }
    }

    // CONSTRUCTOR 2
    public DBManager_prod(DataSource AVMS) {
        connectionType = RESOURCE_INJECTION;
        this.AVMS = AVMS;
    }

    /**
     * Returns a connection from connection pool.
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
