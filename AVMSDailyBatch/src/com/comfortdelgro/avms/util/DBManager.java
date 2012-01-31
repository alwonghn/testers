
package com.comfortdelgro.avms.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
/**
 *
 * @author angck
 */
public class DBManager {
    static String userid;
    static String password;
    static String url;
    static Connection con = null;
    static Context ctx = null;

    public static Connection getMSSQLJDBCConnection(){
        Properties prop = new Properties();
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
            con = DriverManager.getConnection(url, userid, password);
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return con;
    }
}
