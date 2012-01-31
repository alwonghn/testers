/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smva.ejb;
import com.smva.dao.CadUserDao;
import com.smva.dao.RoleDao;
import com.smva.dao.LoginPreferenceDao;
import com.smva.dao.UserLoginDao;
import com.smva.dao.WorkGroupNamesDao;
import com.smva.jb.LoginCheckBean;
import com.smva.jb.RoleBean;
import com.smva.jb.LoginPreferenceBean;
import com.smva.jb.WorkGroupNamesBean;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author alfred.wong
 */
@Stateless
public class SMVASessionEJB implements SMVASession {

//   @Resource(mappedName = "jdbc/AVMS")
//    private DataSource ds;

    public String getMessage() {
        return "Hello AVMSSessionEJB !!!";
    }

    public ArrayList<RoleBean> getRoles() {
        ArrayList<RoleBean> alRoleBean = new ArrayList<RoleBean> ();
        try{
            RoleDao rd = new RoleDao();
//            RoleDao rd = new RoleDao(ds);
            alRoleBean = rd.load();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return alRoleBean;
    }

    public LoginPreferenceBean getLoginPreference(int userID) {
//        LoginPreferenceBean loginPreference = null;
        LoginPreferenceBean loginPreference = new LoginPreferenceBean();
        try {
//            LoginPreferenceDao data = new LoginPreferenceDao(ds);
            LoginPreferenceDao data = new LoginPreferenceDao();
            loginPreference = data.load(userID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return loginPreference;
    }

    public LoginCheckBean getLoginCheck(String strWindowsUserName) { // loginID is alfred.wong

        LoginCheckBean loginCheck = new LoginCheckBean();

//        LoginPreferenceBean loginPreference = new LoginPreferenceBean();
//        loginPreference = getLoginPreference(getUserIDByNTLogin(strWindowsUserName));
        
//        ArrayList<WorkGroupNamesBean> workGroupNames = new ArrayList<WorkGroupNamesBean>();
//        workGroupNames = getWorkGroupNames();
//        System.out.println("workGroupNames size - " + workGroupNames.size());


        
//        loginCheck.setLogin_preference(loginPreference);  // store the last login's usage info
//        loginCheck.setWorkGroupNames(workGroupNames);  // store the user's workgroups membership info
//        loginCheck.setLogin(getCadUserByUserID(getUserIDByNTLogin(strWindowsUserName)));  // set the valid flag
//        System.out.println("login name - " + loginCheck.getLogin());
        
        return loginCheck;
    }

    public int getUserIDByNTLogin(String ntLogin) {   // goes to dbo.user_login table to get the avms userid mapped to the this windows user name
        int userLogin = 0;
        try {
//            UserLoginDao data = new UserLoginDao(ds);
            UserLoginDao data = new UserLoginDao();
            userLogin = data.load(ntLogin);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return userLogin;
    }

    public ArrayList<WorkGroupNamesBean> getWorkGroupNames() {
        ArrayList<WorkGroupNamesBean> workGroupNames = null;
        try {
//            WorkGroupNamesDao data = new WorkGroupNamesDao(ds);
            WorkGroupNamesDao data = new WorkGroupNamesDao();
            workGroupNames = data.load();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return workGroupNames;
    }

    public String getCadUserByUserID(int userID) {   //checks whether userID exits in cadUser list and returns a "valid" value to the login check bean's 'login'(validity status flag) member variable
        String valid = "";
        try {
//            cadUserDao data = new cadUserDao(ds);
            CadUserDao data = new CadUserDao();
            if (userID != 0) {
                if (data.loadGroupNameByUserID(userID).size() != 0 && data.loadGroupNameByUserID(userID) != null) {
                    valid = "valid";
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return valid;
    }

    





    


}
