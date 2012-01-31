/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author alfred.wong
 */
public class TestBasicDataSource {

    static Connection connection = null;
    BasicDataSource bdSource;

    public TestBasicDataSource(){
        bdSource = new BasicDataSource();
        bdSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        bdSource.setUrl("jdbc:sqlserver://NSS-PC-001:1433;databaseName=jboss;selectMethod=cursor");
        bdSource.setUsername("sa");
        bdSource.setPassword("sa");
    }

    public Connection createConnection(){
        Connection con = null;
        try{
            con = bdSource.getConnection();
            if(con == null){
                System.out.println("no connection");
            }
        }catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
	}
        return con;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        TestBasicDataSource bsc = new TestBasicDataSource();
        connection = bsc.createConnection();
        Statement stmt = connection.createStatement();
        String query = "SELECT userid, passwd FROM dbo.jms_users";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            System.out.println("<br> " +rs.getString("USERID") + " | " +rs.getString("PASSWD"));
        }
        connection.close();
        stmt.close();
        rs.close();
    }

}
