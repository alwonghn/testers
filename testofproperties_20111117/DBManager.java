/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfortdelgro.avms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
    
//    public static Connection getMSSQLJDBCConnection(){
//        userid = AVMSConstant.dbUserid;
//        password = AVMSConstant.dbPassword;
//        url = AVMSConstant.dbUrl;
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		} catch(java.lang.ClassNotFoundException e) {
//			System.err.print("ClassNotFoundException:");
//			System.err.println(e.getMessage());
//		}
//		try {
//		   con = DriverManager.getConnection(url, userid, password);
//		} catch(SQLException ex) {
//			System.err.println("SQLException: " + ex.getMessage());
//		}
//		return con;
//    }

    public static Connection getMSSQLJDBCConnection(){
//        userid = AVMSConstant.dbUserid;
//        password = AVMSConstant.dbPassword;
//        url = AVMSConstant.dbUrl;
        Properties prop = new Properties();
                try{
                    prop.load(new FileInputStream("db.properties"));
                    userid = prop.getProperty("dbUserid");
                    password = prop.getProperty("dbPassword");
                    url = prop.getProperty("dbUrl");
                }catch(IOException ex){
                    System.err.println("IO Exception: "+ ex.getMessage());
                }

//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//		} catch(java.lang.ClassNotFoundException e) {
//			System.err.print("ClassNotFoundException:");
//			System.err.println(e.getMessage());
//		}
		try {
		   con = DriverManager.getConnection(url, userid, password);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return con;
    }

    public static Connection getMSSQLJDBCContextConn(){
        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            //properties.put("java.naming.provider.url", "jnp://localhost:1099");
            properties.put("java.naming.provider.url", "localhost:1099");
            ctx = new InitialContext(properties);
            if(ctx != null){
                System.out.println("ok got context");
            }
            DataSource ds = (DataSource)ctx.lookup("java:jdbc/AVMS");
            //Connection con = ds.getConnection(userid, password);
            Connection con = ds.getConnection();

        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        } catch (SQLException se){
            
        } finally {
            return con;
        }
    }



}
