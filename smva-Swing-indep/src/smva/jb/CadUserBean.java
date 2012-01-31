/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.jb;

import java.sql.Timestamp;

/**
 *
 * @author alfred.wong
 */
public class CadUserBean {
    private int user_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String soc_sec_nbr;
    private String home_phone;
    private String work_phone;
    private String extension;
    private int role_ind;
    private int passwd;
    private String name;
    private int user_id_chg_by;
    private Timestamp change_dt_chg;
    private Timestamp passwd_dt_chg;
    private int passwd_expire_days;
    private int active_nonactive;
    private String employee_id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private Timestamp date_of_birth;
    private int selected_controller;
    private String emergency_contact_name;
    private String emergency_contact_phone;
    private String emergency_contact_address1;
    private String emergency_contact_address2;
    private String emergency_contact_city;
    private String emergency_contact_state;
    private String emergency_contact_zip;
    private String emergency_contact_relationship;
    private int original_job_class;
    private Timestamp marked_for_deletion;
    private int org_id;

    public int getActive_nonactive() {
        return active_nonactive;
    }

    public void setActive_nonactive(int active_nonactive) {
        this.active_nonactive = active_nonactive;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Timestamp getChange_dt_chg() {
        return change_dt_chg;
    }

    public void setChange_dt_chg(Timestamp change_dt_chg) {
        this.change_dt_chg = change_dt_chg;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Timestamp date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmergency_contact_address1() {
        return emergency_contact_address1;
    }

    public void setEmergency_contact_address1(String emergency_contact_address1) {
        this.emergency_contact_address1 = emergency_contact_address1;
    }

    public String getEmergency_contact_address2() {
        return emergency_contact_address2;
    }

    public void setEmergency_contact_address2(String emergency_contact_address2) {
        this.emergency_contact_address2 = emergency_contact_address2;
    }

    public String getEmergency_contact_city() {
        return emergency_contact_city;
    }

    public void setEmergency_contact_city(String emergency_contact_city) {
        this.emergency_contact_city = emergency_contact_city;
    }

    public String getEmergency_contact_name() {
        return emergency_contact_name;
    }

    public void setEmergency_contact_name(String emergency_contact_name) {
        this.emergency_contact_name = emergency_contact_name;
    }

    public String getEmergency_contact_phone() {
        return emergency_contact_phone;
    }

    public void setEmergency_contact_phone(String emergency_contact_phone) {
        this.emergency_contact_phone = emergency_contact_phone;
    }

    public String getEmergency_contact_relationship() {
        return emergency_contact_relationship;
    }

    public void setEmergency_contact_relationship(String emergency_contact_relationship) {
        this.emergency_contact_relationship = emergency_contact_relationship;
    }

    public String getEmergency_contact_state() {
        return emergency_contact_state;
    }

    public void setEmergency_contact_state(String emergency_contact_state) {
        this.emergency_contact_state = emergency_contact_state;
    }

    public String getEmergency_contact_zip() {
        return emergency_contact_zip;
    }

    public void setEmergency_contact_zip(String emergency_contact_zip) {
        this.emergency_contact_zip = emergency_contact_zip;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Timestamp getMarked_for_deletion() {
        return marked_for_deletion;
    }

    public void setMarked_for_deletion(Timestamp marked_for_deletion) {
        this.marked_for_deletion = marked_for_deletion;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public int getOriginal_job_class() {
        return original_job_class;
    }

    public void setOriginal_job_class(int original_job_class) {
        this.original_job_class = original_job_class;
    }

    public int getPasswd() {
        return passwd;
    }

    public void setPasswd(int passwd) {
        this.passwd = passwd;
    }

    public Timestamp getPasswd_dt_chg() {
        return passwd_dt_chg;
    }

    public void setPasswd_dt_chg(Timestamp passwd_dt_chg) {
        this.passwd_dt_chg = passwd_dt_chg;
    }

    public int getPasswd_expire_days() {
        return passwd_expire_days;
    }

    public void setPasswd_expire_days(int passwd_expire_days) {
        this.passwd_expire_days = passwd_expire_days;
    }

    public int getRole_ind() {
        return role_ind;
    }

    public void setRole_ind(int role_ind) {
        this.role_ind = role_ind;
    }

    public int getSelected_controller() {
        return selected_controller;
    }

    public void setSelected_controller(int selected_controller) {
        this.selected_controller = selected_controller;
    }

    public String getSoc_sec_nbr() {
        return soc_sec_nbr;
    }

    public void setSoc_sec_nbr(String soc_sec_nbr) {
        this.soc_sec_nbr = soc_sec_nbr;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id_chg_by() {
        return user_id_chg_by;
    }

    public void setUser_id_chg_by(int user_id_chg_by) {
        this.user_id_chg_by = user_id_chg_by;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    
}
