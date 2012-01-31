/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.jb;

/**
 *
 * @author alfred.wong
 */
public class BstBean {
    private int route_id;
    private int direction_code_id;
    private int seq_num;
    private int tp_sname;
    private float cum_dist;
    private float dist;
    private String itp;
    private int mark_id;

    public float getCum_dist() {
        return cum_dist;
    }

    public void setCum_dist(float cum_dist) {
        this.cum_dist = cum_dist;
    }

    public int getDirection_code_id() {
        return direction_code_id;
    }

    public void setDirection_code_id(int direction_code_id) {
        this.direction_code_id = direction_code_id;
    }

    public float getDist() {
        return dist;
    }

    public void setDist(float dist) {
        this.dist = dist;
    }

    public String getItp() {
        return itp;
    }

    public void setItp(String itp) {
        this.itp = itp;
    }

    public int getMark_id() {
        return mark_id;
    }

    public void setMark_id(int mark_id) {
        this.mark_id = mark_id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getSeq_num() {
        return seq_num;
    }

    public void setSeq_num(int seq_num) {
        this.seq_num = seq_num;
    }

    public int getTp_sname() {
        return tp_sname;
    }

    public void setTp_sname(int tp_sname) {
        this.tp_sname = tp_sname;
    }

    
}
