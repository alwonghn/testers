/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.avms.jb;

/**
 *
 * @author alfred.wong
 */
public class RoleBean {
    private String role_name;
    private String role_desc;

    public RoleBean() {
    }

    public RoleBean(String role_name, String role_desc){

        this.role_name = role_name;
        this.role_desc = role_desc;

    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }



    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }


}
