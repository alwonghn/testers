/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package timestampgetrecordfrdbwheredatetimecolistoday;

import com.comfortdelgro.avms.util.CommonUtil;
import com.comfortdelgro.avms.util.DBManager;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alfred.wong
 */
public class Test {
    
    protected DBManager dbManager = null;
    protected Connection con = null;

    public Test(){
        dbManager = new DBManager();
    }
    
    @SuppressWarnings("static-access")
    public ArrayList<Integer> getStartDatesForToday() throws SQLException {

        String sql =  "SELECT booking_num FROM dbo.booking " +
                "WHERE convert(varchar, getdate(), 103) = convert(varchar, start_date, 103)";
        ArrayList<Integer> bkgNumList = new ArrayList<Integer>();
        try{
            con = null;
            Statement st = null;
            ResultSet rs = null;
            con = dbManager.getMSSQLJDBCConnection();
//            ps = con.prepareStatement(sql);
            st = con.createStatement();
//            st.setTimestamp(1, tsTday);
//            rs = ps.executeQuery();
            rs = st.executeQuery(sql);

            while(rs.next()){
                bkgNumList.add(rs.getInt("booking_num"));
            }
//            ps.close();
            st.close();
        }finally{
            con.close();
        }
        return bkgNumList;
        
    }
}
