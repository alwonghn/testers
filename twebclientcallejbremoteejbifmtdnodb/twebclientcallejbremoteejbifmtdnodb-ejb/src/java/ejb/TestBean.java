/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author a
 */
@Stateless
public class TestBean implements TestRemote {

    public String getMessage() {
        return "Hello EJB World";
    }

}
