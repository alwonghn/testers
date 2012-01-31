/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.avms.ejb;
import com.avms.dao.loginPreferenceDao;
import com.avms.jb.loginPreferenceBean;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author alfred.wong
 */
@Stateless
public class SMVASessionEJB implements SMVASession {

    @Resource(name = "jdbc/AVMS")
    private DataSource ds;


    public loginPreferenceBean getLoginPreference(int userID) {
        loginPreferenceBean loginPreference = null;
        try {
            loginPreferenceDao data = new loginPreferenceDao(ds);
            loginPreference = data.load(userID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return loginPreference;
    }


}
