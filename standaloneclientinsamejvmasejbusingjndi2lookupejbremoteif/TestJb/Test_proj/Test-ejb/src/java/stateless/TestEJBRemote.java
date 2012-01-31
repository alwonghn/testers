/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stateless;

import javax.ejb.Remote;

/**
 *
 * @author a
 */
@Remote
public interface TestEJBRemote {

    String getMessage();
    
}
