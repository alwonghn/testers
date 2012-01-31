/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novasprint.ejb;

import java.io.Serializable;

/**
 *
 * @author alfred.wong
 */
public class ProductSupplierPk implements Serializable {

    private String supplier_reg_code;
    private String product_code;

    public ProductSupplierPk(String supplier_reg_code, String product_code) {
        this.supplier_reg_code = supplier_reg_code;
        this.product_code = product_code;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getSupplier_reg_code() {
        return supplier_reg_code;
    }

    public void setSupplier_reg_code(String supplier_reg_code) {
        this.supplier_reg_code = supplier_reg_code;
    }

    @Override
    public boolean equals(Object other) {
//        if(other == this){
//            return true;
//        }

        /*is object's reference is null*/
        if (other == null) {
            return false;
        }

        /*references are the same type of reference i.e. instance of same class*/
        if (!(getClass() == other.getClass())) {
            return false;
        } else {
            ProductSupplierPk tmp = (ProductSupplierPk) other;
            if (tmp.product_code.equals(this.product_code) && tmp.supplier_reg_code.equals(this.supplier_reg_code)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
