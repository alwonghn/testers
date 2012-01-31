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
public class IncidentCodesBean {
    private int incident_type;
    private int incident_code;
    private String message_text;
    private Timestamp marked_for_deletion;

    public int getIncident_code() {
        return incident_code;
    }

    public void setIncident_code(int incident_code) {
        this.incident_code = incident_code;
    }

    public int getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(int incident_type) {
        this.incident_type = incident_type;
    }

    public Timestamp getMarked_for_deletion() {
        return marked_for_deletion;
    }

    public void setMarked_for_deletion(Timestamp marked_for_deletion) {
        this.marked_for_deletion = marked_for_deletion;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    
}
