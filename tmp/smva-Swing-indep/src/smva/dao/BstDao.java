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
import smva.jb.BstBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class BstDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public BstDao() {
        dbManager = new DBManager();
    }

    public BstDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public ArrayList<BstBean> loadBST(int routeID, int dirCode) throws SQLException {
        ArrayList<BstBean> bstList = new ArrayList<BstBean>();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select route_id,direction_code_id,seq_num,tp_sname,cum_dist,dist,itp,mark_id" +
                " from bst d" +
                " where route_id = ?" +
                " and direction_code_id = ?" +
                " order by seq_num";
        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, routeID);
            pstmt.setInt(2, dirCode);
            result = pstmt.executeQuery();
            while (result.next()) {
                BstBean bst = new BstBean();
                bst.setRoute_id(result.getInt(1));
                bst.setDirection_code_id(result.getInt(2));
                bst.setSeq_num(result.getInt(3));
                bst.setTp_sname(result.getInt(4));
                bst.setCum_dist(result.getFloat(5));
                bst.setDist(result.getFloat(6));
                bst.setItp(result.getString(7));
                bst.setMark_id(result.getInt(8));
                bstList.add(bst);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return bstList;
    }
}
