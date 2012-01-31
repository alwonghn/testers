/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.novasprint.ejb;

import java.util.Hashtable;
import javax.ejb.Remote;

/**
 *
 * @author alfred.wong
 */
@Remote
public interface SupplierPortalRemote {

    void registerSupplier(Hashtable formParams, String userID);

    public void updateSupplierInfo(java.util.Hashtable formParams, java.lang.String userID);

    public void deregisterSupplier(java.lang.String supplier_reg_code, java.lang.String userID);

    public void addProduct(java.util.Hashtable formParams, java.lang.String userID);

    public void updateProductInfo(java.util.Hashtable formParams, java.lang.String userID);

    public com.novasprint.jb.SupplierBean getSupplierInfo(java.lang.String supplier_reg_code);
    
}
