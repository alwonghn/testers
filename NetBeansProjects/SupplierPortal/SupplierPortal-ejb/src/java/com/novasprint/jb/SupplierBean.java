/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novasprint.jb;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author alfred.wong
 */
public class SupplierBean implements Serializable {

    private String supplier_reg_code;
    private String supplier_name;
    private String supplier_address;
    private String supplier_number;
    private String supplier_website;
    private int status;
    private String created_by;
    private Timestamp created_date;

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_number() {
        return supplier_number;
    }

    public void setSupplier_number(String supplier_number) {
        this.supplier_number = supplier_number;
    }

    public String getSupplier_reg_code() {
        return supplier_reg_code;
    }

    public void setSupplier_reg_code(String supplier_reg_code) {
        this.supplier_reg_code = supplier_reg_code;
    }

    public String getSupplier_website() {
        return supplier_website;
    }

    public void setSupplier_website(String supplier_website) {
        this.supplier_website = supplier_website;
    }
}
