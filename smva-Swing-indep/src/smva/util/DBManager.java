/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smva.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.io.FileInputStream;
import java.io.IOException;
//import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.Properties;
//import javax.naming.Context;

/**
 *
 * @author alfred.wong
 */
public class DBManager {

//    private int connectionType;
    private String connectionType;
//    private final int RESOURCE_LOOKUP = 1;    //set the connectionType flag to 1 if rl is used
//    private final int RESOURCE_INJECTION = 2;  // set the connectionType flag to 2 if ri is used

    private String DB_NAME;
    private final String DS_JNDI_NAME = "jdbc/AVMS";
    private DataSource AVMS;

    static String userid;
    static String password;
    static String url;
    static Connection connection = null;
    static Context ctx = null;


    //// CONSTRUCTORS
    // first overload constructor : when db connection will be created using resource lookup
    public DBManager() {
        
       
        // if this constructor is called, the 'connectionType' variable is set to RL  or  Driver Mgr
//        connectionType = "RESOURCE_LOOKUP";
        connectionType = "DRIVER_MANAGER";
        
/*
        // for RL: need to differentiate between JBoss-RL or non-JBoss-RL vary the DB_NAME according to whether JBoss is the app server
//        if (AVMSConstant.APP_SVR_USED.equalsIgnoreCase(AVMSConstant.JBOSS)) {
//            DB_NAME = "java:/" + DS_JNDI_NAME;
//        } else {
//            DB_NAME = DS_JNDI_NAME;
//        }
        DB_NAME = "java:/jdbc/AVMS";
*/      

    }

    // second overload constructor : when db connection will be created using resource injection:  pass in the ds 
    public DBManager(DataSource AVMS) {
        // if this constructor is called, the 'connectionType' variable is set to RI
//        connectionType = RESOURCE_INJECTION;
        connectionType = "RESOURCE_INJECTION";
        this.AVMS = AVMS;
    }

    
    public Connection getConnection() {
        Properties prop = new Properties();
        try {
//            if (connectionType == RESOURCE_INJECTION) {
            if (connectionType.equalsIgnoreCase("RESOURCE_INJECTION") ) {
                System.out.println("Using resource injection to connect to db");
                connection = AVMS.getConnection();
//            } else if (connectionType == RESOURCE_LOOKUP) {
            } else if (connectionType.equalsIgnoreCase("RESOURCE_LOOKUP")) {
                getJDBCConnectionByRL();
            } else { // driverManager
                getJDBCConnectionByDM();
            }
            return connection;
        } catch (SQLException se) {
            //Convert SQLException into checked exception, if the client code is expected to recuperate
            //Convert SQLException into unchecked exception, if client code cannot do anything about it
            throw new RuntimeException(se);
        } 
    }


    public Connection getJDBCConnectionByRL(){
        DataSource ds = null;
        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            //properties.put("java.naming.provider.url", "jnp://localhost:1099");
            properties.put("java.naming.provider.url", "localhost:1099");
            
//            Context ctx = new InitialContext(properties);
//            System.out.println("Got context");

//            InitialContext initialContext = new InitialContext (properties);
//            Context envContext = (Context) initialContext.lookup ("java:comp/env");
//            DataSource dataSource = (DataSource) envContext.lookup ("jdbc/AVMS");
//            System.out.println("Got context");

            ds = (DataSource)ctx.lookup( "java:/jdbc/AVMS" );
//            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/AVMS");
            System.out.println("Using resource lookup to connect to db");
            System.out.println("Got context");

            connection = ds.getConnection();
        } catch (SQLException se) {
            //Convert SQLException into checked exception, if the client code is expected to recuperate
            //Convert SQLException into unchecked exception, if client code cannot do anything about it
            throw new RuntimeException(se);
        } catch (NamingException nex) {
            //Convert NamingException into checked exception, if the client code is expected to recuperate
            //Convert NamingException into unchecked exception, if client code cannot do anything about it
            throw new RuntimeException(nex);
        }
        return connection;
    }


    public Connection getJDBCConnectionByDM(){
        Properties prop = new Properties();
//        System.out.println("Using driver manager to connect to db");
        try{
            prop.load(new FileInputStream("config.properties"));
            userid = prop.getProperty("dbUserid");
            password = prop.getProperty("dbPassword");
            url = prop.getProperty("dbUrl");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch(IOException ex){
            System.err.println("IO Exception: "+ ex.getMessage());
        }
        catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException:");
            System.err.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(url, userid, password);
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return connection;
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
