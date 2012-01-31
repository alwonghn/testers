/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.manager;

import com.test.jb.UsersBean;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author a
 */
@Remote
public interface databaseaccessorjdbcRemote {

    ArrayList<UsersBean> getUsers();


    
}
