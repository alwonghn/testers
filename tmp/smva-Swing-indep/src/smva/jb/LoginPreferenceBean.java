/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.jb;

/**
 *
 * @author alfred.wong
 */
public class LoginPreferenceBean {

    private int user_id;
    private String group_id;
    private String route_id;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
