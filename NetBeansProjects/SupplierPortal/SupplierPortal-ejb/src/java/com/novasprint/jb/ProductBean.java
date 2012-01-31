/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novasprint.jb;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author alfred.wong
 */
public class ProductBean implements Serializable {

    private String product_code;
    private String product_name;
    private String product_desc;
    private int status;
    private String created_by;
    private Timestamp created_date;

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreatedDate() {
        return created_date;
    }

    public String getCreatedDateString() {
        return (new SimpleDateFormat("dd/MM/yyyy").format(created_date));
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
