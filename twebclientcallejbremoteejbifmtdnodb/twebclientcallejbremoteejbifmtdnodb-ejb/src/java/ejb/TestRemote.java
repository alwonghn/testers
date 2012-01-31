/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;

/**
 *
 * @author a
 */
@Remote
public interface TestRemote {

    String getMessage();
    
}
