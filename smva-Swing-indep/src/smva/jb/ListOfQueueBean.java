/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.jb;

import java.util.ArrayList;

/**
 *
 * @author alfred.wong
 */
public class ListOfQueueBean {
    private ArrayList<AlertQueListBean> alertQueList;
    private ArrayList<RunningQueListBean> runningQueList;

    public ArrayList<AlertQueListBean> getAlertQueList() {
        return alertQueList;
    }

    public void setAlertQueList(ArrayList<AlertQueListBean> alertQueList) {
        this.alertQueList = alertQueList;
    }

    public ArrayList<RunningQueListBean> getRunningQueList() {
        return runningQueList;
    }

    public void setRunningQueList(ArrayList<RunningQueListBean> runningQueList) {
        this.runningQueList = runningQueList;
    }

    

}
