/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import smva.jb.RunsLookupBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class RunsLookupDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public RunsLookupDao() {
        dbManager = new DBManager();
    }

    public RunsLookupDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public RunsLookupBean load(int runID) throws SQLException {
        RunsLookupBean runsLookup = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT run_id, run_alpha, run_alpha_sort" +
                " FROM runs_lookup" +
                " WHERE run_id = ?";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, runID);
            result = pstmt.executeQuery();
            while (result.next()) {
                runsLookup = new RunsLookupBean();
                runsLookup.setRun_id(result.getInt(1));
                runsLookup.setRun_alpha(result.getString(2));
                runsLookup.setRun_alpha_sort(result.getInt(3));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return runsLookup;
    }
}
