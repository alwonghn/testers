/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.manager;

import com.test.dao.UsersDao;
import com.test.jb.UsersBean;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author a
 */
@Stateless
public class databaseaccessorjdbcBean implements databaseaccessorjdbcRemote {

    //@Resource(name = "jdbc/jboss")
//    @Resource
//    private DataSource ds;
    //private @Resource DataSource ds;
    @Resource(mappedName="jdbc/jboss")
    private DataSource ds;

    public ArrayList<UsersBean> getUsers() {
        // create an arraylist for the results
        ArrayList<UsersBean>  uBeanList = null;
        try{
            // instantiate the usersdao and pass it the datasource
            // usersdao constructor will instantiate a dbmanager obj with the ds
            UsersDao uDao = new UsersDao(ds);
            // call the dao object's load method
            uBeanList = uDao.load();
            // load mtd will get a connection from the dbmanager and execute the prepared statement
            // load mtd will iterate thru result set, populate a bean for each row, and put all beans into an arraylist returned
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return uBeanList;
    }
}
