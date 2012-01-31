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
import smva.jb.WorkGroupNamesBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class WorkGroupNamesDao {
    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public WorkGroupNamesDao() {
        dbManager = new DBManager();
    }

    public WorkGroupNamesDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public ArrayList<WorkGroupNamesBean> load() throws SQLException {
        ArrayList<WorkGroupNamesBean> workGroupNamesList = new ArrayList<WorkGroupNamesBean>();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select group_id,group_name from work_group_names";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            result = pstmt.executeQuery();
            while (result.next()) {
                WorkGroupNamesBean workGroupNames = new WorkGroupNamesBean();
                workGroupNames.setGroup_id(result.getInt(1));
                workGroupNames.setGroup_name(result.getString(2));
                workGroupNamesList.add(workGroupNames);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return workGroupNamesList;
    }
}
