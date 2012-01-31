/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import smva.jb.BsTimepointsBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class TimepointsDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public TimepointsDao() {
        dbManager = new DBManager();
    }

    public TimepointsDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public ArrayList<BsTimepointsBean> loadBSTimepoints(int routeID, int dirCode) throws SQLException {
        ArrayList<BsTimepointsBean> bsTimepointsList = new ArrayList<BsTimepointsBean>();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select a.tp_id,a.tp_type_id,b.route_id,b.direction_code_id,b.seq_num,b.tp_type_id,c.tp_lname" +
                " from timepoints a,route_timepoints b,timepoint_name c" +
                " where a.tp_id = b.tp_id" +
                " and a.tp_id = c.tp_id" +
                " and b.route_id = ?" +
                " and b.booking_num = 1" +
                " and b.variation = 0001" +
                " and b.direction_code_id = ?" +
                " order by b.direction_code_id,b.seq_num";
        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, routeID);
            pstmt.setInt(2, dirCode);
            result = pstmt.executeQuery();
            while (result.next()) {
                BsTimepointsBean bsTimepoints = new BsTimepointsBean();
                bsTimepoints.setTp_id(result.getInt(1));
                bsTimepoints.setTp_type_id_BS(result.getInt(2));
                bsTimepoints.setRoute_id(result.getInt(3));
                bsTimepoints.setDirection_code_id(result.getInt(4));
                bsTimepoints.setSeq_num(result.getInt(5));
                bsTimepoints.setTp_type_id_VT(result.getInt(6));
                bsTimepoints.setTp_lname(result.getString(7));
                bsTimepointsList.add(bsTimepoints);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return bsTimepointsList;
    }
}
