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
import smva.jb.CadUserBean;
import smva.util.DBManager;
/**
 *
 * @author alfred.wong
 */
public class CadUserDao {

    protected Connection dbConnection = null;
    protected DBManager dbManager;

    public CadUserDao() {
        dbManager = new DBManager();
    }

    public CadUserDao(DataSource AVMS) {
        dbManager = new DBManager(AVMS);
    }

    public CadUserBean load(int userID) throws SQLException {
        CadUserBean cadUser = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "SELECT user_id, first_name, middle_name, last_name, soc_sec_nbr, home_phone, work_phone, extension," +
                " role_ind, passwd, name, user_id_chg_by, change_dt_chg, passwd_dt_chg, passwd_expire_days, active_nonactive," +
                " employee_id, address1, address2, city, state, zip, date_of_birth, selected_controller, emergency_contact_name," +
                " emergency_contact_phone, emergency_contact_address1, emergency_contact_address2, emergency_contact_city," +
                " emergency_contact_state, emergency_contact_zip, emergency_contact_relationship, original_job_class," +
                " marked_for_deletion, org_id" +
                " FROM cad_user" +
                " WHERE user_id = ? ";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, userID);
            result = pstmt.executeQuery();
            while (result.next()) {
                cadUser = new CadUserBean();
                cadUser.setUser_id(result.getInt(1));
                cadUser.setFirst_name(result.getString(2));
                cadUser.setMiddle_name(result.getString(3));
                cadUser.setLast_name(result.getString(4));
                cadUser.setSoc_sec_nbr(result.getString(5));
                cadUser.setHome_phone(result.getString(6));
                cadUser.setWork_phone(result.getString(7));
                cadUser.setExtension(result.getString(8));
                cadUser.setRole_ind(result.getInt(9));
                cadUser.setPasswd(result.getInt(10));
                cadUser.setName(result.getString(11));
                cadUser.setUser_id_chg_by(result.getInt(12));
                cadUser.setChange_dt_chg(result.getTimestamp(13));
                cadUser.setPasswd_dt_chg(result.getTimestamp(14));
                cadUser.setPasswd_expire_days(result.getInt(15));
                cadUser.setActive_nonactive(result.getInt(16));
                cadUser.setEmployee_id(result.getString(17));
                cadUser.setAddress1(result.getString(18));
                cadUser.setAddress2(result.getString(19));
                cadUser.setCity(result.getString(20));
                cadUser.setState(result.getString(21));
                cadUser.setZip(result.getString(22));
                cadUser.setDate_of_birth(result.getTimestamp(23));
                cadUser.setSelected_controller(result.getInt(24));
                cadUser.setEmergency_contact_name(result.getString(25));
                cadUser.setEmergency_contact_phone(result.getString(26));
                cadUser.setEmergency_contact_address1(result.getString(27));
                cadUser.setEmergency_contact_address2(result.getString(28));
                cadUser.setEmergency_contact_city(result.getString(29));
                cadUser.setEmergency_contact_state(result.getString(30));
                cadUser.setEmergency_contact_zip(result.getString(31));
                cadUser.setEmergency_contact_relationship(result.getString(32));
                cadUser.setOriginal_job_class(result.getInt(33));
                cadUser.setMarked_for_deletion(result.getTimestamp(34));
                cadUser.setOrg_id(result.getInt(35));
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return cadUser;
    }

    public ArrayList<String> loadGroupNameByUserID(int userID) throws SQLException {
        ArrayList<String> groupName = new ArrayList<String>();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String query = "select group_name from cad_user a,role b,work_group_roles c,work_group_names d, user_login e" +
                " where a.user_id = ?" +
                " and a.role_ind = b.role_ind" +
                " and c.role_ind = a.role_ind" +
                " and c.group_id = d.group_id" +
                " and group_active = 1 ";

        try {
            dbConnection = dbManager.getConnection();
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, userID);
            result = pstmt.executeQuery();
            while (result.next()) {
                String group = new String();
                group = result.getString(1);
                groupName.add(group);
            }
        } finally {
            dbManager.cleanup(dbConnection, pstmt, result);
            dbConnection = null;
            pstmt = null;
            result = null;
        }
        return groupName;
    }
}
