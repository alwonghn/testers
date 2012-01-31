/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smva.ejb;

import com.smva.jb.LoginCheckBean;
import com.smva.jb.RoleBean;
import com.smva.jb.LoginPreferenceBean;
import com.smva.jb.WorkGroupNamesBean;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author alfred.wong
 */
@Remote
public interface SMVASession {

//    public com.avms.jb.LoginPreferenceBean getLoginPreference(int userID);

    String getMessage();

    ArrayList<RoleBean> getRoles();

    LoginPreferenceBean getLoginPreference(int userID);

    LoginCheckBean getLoginCheck(String loginID);

    int getUserIDByNTLogin(String ntLogin);

    ArrayList<WorkGroupNamesBean> getWorkGroupNames();

    String getCadUserByUserID(int parameter);








    
}
