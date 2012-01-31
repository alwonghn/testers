/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.novasprint.ejb;

import com.novasprint.dao.SupplierDao;
import com.novasprint.jb.SupplierBean;
import java.util.Hashtable;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author alfred.wong
 */
@Stateless
public class SupplierPortalBean implements SupplierPortalRemote {

    @Resource(name = "jdbc/SupplierPortalDB")

    private DataSource supplierPortalDS;

    public void registerSupplier(Hashtable formParams, String userID) {
        SupplierDao sdao = new SupplierDao(supplierPortalDS);
        sdao.create(null);
    }

    public void updateSupplierInfo(Hashtable formParams, String userID) {
        
    }
    
    public void deregisterSupplier(String supplier_reg_code, String userID){
        
    }

    public void addProduct(Hashtable formParams, String userID){

    }

    public void updateProductInfo(Hashtable formParams, String userID){

    }

    public SupplierBean getSupplierInfo(String supplier_reg_code){
        SupplierDao sdao = new SupplierDao(supplierPortalDS);
        SupplierBean supplier = sdao.load("supplier_reg_code");
        return supplier;
    }
}
