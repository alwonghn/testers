/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import javax.ejb.Stateless;

/**
 *
 * @author alfred.wong
 */
@Stateless
public class TestEJBBean implements TestEJBRemote {

    public String getMessage() {
        return "Hello EJB World !!!!!";
    }
}
