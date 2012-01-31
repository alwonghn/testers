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
public class HeadwayBean {
    private ArrayList<BsTimepointsBean> dir1BusStopTP;
    private ArrayList<BsTimepointsBean> dir2BusStopTP;
    private ArrayList<RunningVehicleBean> dir1RunningVehicle;
    private ArrayList<RunningVehicleBean> dir2RunningVehicle;
    private ArrayList<BstBean> dir1bst;
    private ArrayList<BstBean> dir2bst;

    public ArrayList<BsTimepointsBean> getDir1BusStopTP() {
        return dir1BusStopTP;
    }

    public void setDir1BusStopTP(ArrayList<BsTimepointsBean> dir1BusStopTP) {
        this.dir1BusStopTP = dir1BusStopTP;
    }

    public ArrayList<RunningVehicleBean> getDir1RunningVehicle() {
        return dir1RunningVehicle;
    }

    public void setDir1RunningVehicle(ArrayList<RunningVehicleBean> dir1RunningVehicle) {
        this.dir1RunningVehicle = dir1RunningVehicle;
    }

    public ArrayList<BstBean> getDir1bst() {
        return dir1bst;
    }

    public void setDir1bst(ArrayList<BstBean> dir1bst) {
        this.dir1bst = dir1bst;
    }

    public ArrayList<BsTimepointsBean> getDir2BusStopTP() {
        return dir2BusStopTP;
    }

    public void setDir2BusStopTP(ArrayList<BsTimepointsBean> dir2BusStopTP) {
        this.dir2BusStopTP = dir2BusStopTP;
    }

    public ArrayList<RunningVehicleBean> getDir2RunningVehicle() {
        return dir2RunningVehicle;
    }

    public void setDir2RunningVehicle(ArrayList<RunningVehicleBean> dir2RunningVehicle) {
        this.dir2RunningVehicle = dir2RunningVehicle;
    }

    public ArrayList<BstBean> getDir2bst() {
        return dir2bst;
    }

    public void setDir2bst(ArrayList<BstBean> dir2bst) {
        this.dir2bst = dir2bst;
    }

    
}
