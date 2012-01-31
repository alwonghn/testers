/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.jb;

/**
 *
 * @author alfred.wong
 */
public class IncidentTypesBean {
    private int incident_type;
    private String incident_name;
    private String incident_desc;

    public String getIncident_desc() {
        return incident_desc;
    }

    public void setIncident_desc(String incident_desc) {
        this.incident_desc = incident_desc;
    }

    public String getIncident_name() {
        return incident_name;
    }

    public void setIncident_name(String incident_name) {
        this.incident_name = incident_name;
    }

    public int getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(int incident_type) {
        this.incident_type = incident_type;
    }

    
}
