/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter.ejb;

import javax.ejb.Remote;

/**
 *
 * @author alfred.wong
 */
@Remote
public interface Converter {

    public java.math.BigDecimal dollarToYen(java.math.BigDecimal dollars);

    public java.math.BigDecimal yenToEuro(java.math.BigDecimal yen);
    
}
