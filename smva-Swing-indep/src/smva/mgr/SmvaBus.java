/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva.mgr;
import java.util.ArrayList;
import smva.dao.BlockDao;
import smva.dao.BstDao;
import smva.dao.CadUserDao;
import smva.dao.CurrentHeadwayStatusDao;
import smva.dao.CurrentPerformanceStatusDao;
import smva.dao.IncidentCodesDao;
import smva.dao.IncidentLogDao;
import smva.dao.IncidentTypesDao;
import smva.dao.LoginPreferenceDao;
import smva.dao.RoleDao;
import smva.dao.RunsLookupDao;
import smva.dao.TimepointNameDao;
import smva.dao.TimepointsDao;
import smva.dao.UserLoginDao;
import smva.dao.VehiclePositionLogDao;
import smva.dao.VehicleStaticInfoDao;
import smva.dao.WorkGroupNamesDao;
import smva.jb.AlertQueListBean;
import smva.jb.BlockBean;
import smva.jb.BsTimepointsBean;
import smva.jb.BstBean;
import smva.jb.CadUserBean;
import smva.jb.CurrentHeadwayStatusBean;
import smva.jb.CurrentPerformanceStatusBean;
import smva.jb.HeadwayBean;
import smva.jb.IncidentCodesBean;
import smva.jb.IncidentLogBean;
import smva.jb.IncidentTypesBean;
import smva.jb.ListOfQueueBean;
import smva.jb.LoginCheckBean;
import smva.jb.LoginPreferenceBean;
import smva.jb.RoleBean;
import smva.jb.RunningQueListBean;
import smva.jb.RunningVehicleBean;
import smva.jb.RunsLookupBean;
import smva.jb.TimepointNameBean;
import smva.jb.VehiclePositionLogBean;
import smva.jb.VehicleStaticInfoBean;
import smva.jb.WorkGroupNamesBean;
import smva.util.AVMSConstant;
import smva.util.commonUtil;
/**
 *
 * @author alfred.wong
 */
public class SmvaBus {

//   @Resource(mappedName = "jdbc/AVMS")
//    private DataSource ds;

    public String getMessage() {
        return "Hello AVMSSessionEJB !!!";
    }

    public ArrayList<RoleBean> getRoles() {
        ArrayList<RoleBean> alRoleBean = new ArrayList<RoleBean> ();
        try{
            RoleDao rd = new RoleDao();
//            RoleDao rd = new RoleDao(ds);
            alRoleBean = rd.load();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return alRoleBean;
    }

    public LoginPreferenceBean getLoginPreference(int userID) {
//        LoginPreferenceBean loginPreference = null;
        LoginPreferenceBean loginPreference = new LoginPreferenceBean();
        try {
//            LoginPreferenceDao data = new LoginPreferenceDao(ds);
            LoginPreferenceDao data = new LoginPreferenceDao();
            loginPreference = data.load(userID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return loginPreference;
    }

    public LoginCheckBean getLoginCheck(String strWindowsUserName) { // loginID is alfred.wong

        LoginCheckBean loginCheck = new LoginCheckBean();

//        LoginPreferenceBean loginPreference = new LoginPreferenceBean();
//        loginPreference = getLoginPreference(getUserIDByNTLogin(strWindowsUserName));

//        ArrayList<WorkGroupNamesBean> workGroupNames = new ArrayList<WorkGroupNamesBean>();
//        workGroupNames = getWorkGroupNames();
//        System.out.println("workGroupNames size - " + workGroupNames.size());



//        loginCheck.setLogin_preference(loginPreference);  // store the last login's usage info
//        loginCheck.setWorkGroupNames(workGroupNames);  // store the user's workgroups membership info
//        loginCheck.setLogin(getCadUserByUserID(getUserIDByNTLogin(strWindowsUserName)));  // set the valid flag
//        System.out.println("login name - " + loginCheck.getLogin());

        LoginPreferenceBean loginPreference = new LoginPreferenceBean();
        loginPreference = getLoginPreference(getUserIDByNTLogin(strWindowsUserName));

        ArrayList<WorkGroupNamesBean> workGroupNames = new ArrayList<WorkGroupNamesBean>();
        workGroupNames = getWorkGroupNames();
        System.out.println("workGroupNames size - " + workGroupNames.size());



        loginCheck.setLogin_preference(loginPreference);  // store the last login's usage info
        loginCheck.setWorkGroupNames(workGroupNames);  // store the user's workgroups membership info
        loginCheck.setLogin(getCadUserByUserID(getUserIDByNTLogin(strWindowsUserName)));  // set the valid flag
        System.out.println("login name - " + loginCheck.getLogin());

        return loginCheck;
    }

    public int getUserIDByNTLogin(String ntLogin) {   // goes to dbo.user_login table to get the avms userid mapped to the this windows user name
        int userLogin = 0;
        try {
//            UserLoginDao data = new UserLoginDao(ds);
            UserLoginDao data = new UserLoginDao();
            userLogin = data.load(ntLogin);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return userLogin;
    }

    public ArrayList<WorkGroupNamesBean> getWorkGroupNames() {
        ArrayList<WorkGroupNamesBean> workGroupNames = null;
        try {
//            WorkGroupNamesDao data = new WorkGroupNamesDao(ds);
            WorkGroupNamesDao data = new WorkGroupNamesDao();
            workGroupNames = data.load();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return workGroupNames;
    }

    public String getCadUserByUserID(int userID) {   //checks whether userID exits in cadUser list and returns a "valid" value to the login check bean's 'login'(validity status flag) member variable
        String valid = "";
        try {
//            cadUserDao data = new cadUserDao(ds);
            CadUserDao data = new CadUserDao();
            if (userID != 0) {
                if (data.loadGroupNameByUserID(userID).size() != 0 && data.loadGroupNameByUserID(userID) != null) {
                    valid = "valid";
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return valid;
    }



    public ListOfQueueBean getAllQue(int userID, String groupID, String routeID) {
        ListOfQueueBean queueList = new ListOfQueueBean();

//        if (loginPreference.size() != 0 && loginPreference.size() > 1) {
//            for (int i = 0; i < loginPreference.size(); i++) {
//                if (groupID.equals("")) {
//                    groupID = String.valueOf(loginPreference.get(i).getGroup_id());
//                } else {
//                    groupID = groupID + "," + String.valueOf(loginPreference.get(i).getGroup_id());
//                }
//            }
//        } else {
//            groupID = String.valueOf(loginPreference.get(0).getGroup_id());
//        }
        ArrayList<IncidentLogBean> incidentLogList = new ArrayList<IncidentLogBean>();
        incidentLogList = getIncidentLogList(userID, groupID, "I", routeID);
        ArrayList<AlertQueListBean> aqlist = new ArrayList<AlertQueListBean>();
        System.out.println("incidentLogList size - " + incidentLogList.size());
        ArrayList<CurrentPerformanceStatusBean> currentPerformanceStatusList = new ArrayList<CurrentPerformanceStatusBean>();
        currentPerformanceStatusList = getCurrentPerformanceStatusList(userID, groupID, "P", routeID);
        ArrayList<RunningQueListBean> rqlist = new ArrayList<RunningQueListBean>();
        System.out.println("currentPerformanceStatusList size - " + currentPerformanceStatusList.size());
        IncidentTypesBean incidentTypes = new IncidentTypesBean();
        VehiclePositionLogBean vehiclePositionLog = new VehiclePositionLogBean();
        CurrentHeadwayStatusBean currentHeadwayStatus = new CurrentHeadwayStatusBean();
        VehicleStaticInfoBean vehicleStaticInfo = new VehicleStaticInfoBean();
        CadUserBean cadUser = new CadUserBean();
        BlockBean block = new BlockBean();
        IncidentCodesBean incidentCodes = new IncidentCodesBean();
        RunsLookupBean runsLookup = new RunsLookupBean();
        TimepointNameBean timepointName = new TimepointNameBean();
        try {
            /*For loop for the Alert Queue*/
            for (int i = 0; i < incidentLogList.size(); i++) {
                AlertQueListBean alertQue = new AlertQueListBean();
                incidentTypes = getIncidentType(incidentLogList.get(i).getIncident_type());
                if (incidentTypes != null) {
                    alertQue.setType(incidentTypes.getIncident_name());
                    alertQue.setDesc(incidentTypes.getIncident_desc());
                }
                alertQue.setDate(commonUtil.formatTimestamp(incidentLogList.get(i).getIncident_date_time(), AVMSConstant.DISPLAY_DATE_FORMAT));
                alertQue.setTime(commonUtil.formatTimestamp(incidentLogList.get(i).getIncident_date_time(), AVMSConstant.DISPLAY_TIME_FORMAT));
                alertQue.setVid(incidentLogList.get(i).getVehicle_id());
                alertQue.setService(incidentLogList.get(i).getRoute_id());
//                alertQue.setRun(currentPerformanceStatusList.get(i).getBlock_alpha());
                alertQue.setStaff_id(incidentLogList.get(i).getDriver_id());
                incidentCodes = getIncidentCodesBean(incidentLogList.get(i).getIncident_type(), incidentLogList.get(i).getIncident_code());
                alertQue.setMsg(incidentCodes.getMessage_text());
                alertQue.setOwner(incidentLogList.get(i).getUser_handled());
                cadUser = getCadUserBean(incidentLogList.get(i).getDriver_id());
                alertQue.setBc(cadUser.getLast_name());
                runsLookup = getRunsLookup(incidentLogList.get(i).getRun_id());
                if (runsLookup != null) {
                    alertQue.setDuty(runsLookup.getRun_alpha());
                }
                alertQue.setLast_itp(incidentLogList.get(i).getTp_id());
                timepointName = getTimepointNameBean(incidentLogList.get(i).getTp_id());
                alertQue.setIntersection(timepointName.getTp_lname());
//                alertQue.setVeh_status(currentPerformanceStatusList.get(i).getStatus());
//                alertQue.setCursvc(currentPerformanceStatusList.get(i).getCurrent_route_id());
                alertQue.setDev(incidentLogList.get(i).getDeviation());
                aqlist.add(alertQue);
            }
            /*For loop for the Running Queue*/
            for (int i = 0; i < currentPerformanceStatusList.size(); i++) {
                RunningQueListBean runningQue = new RunningQueListBean();
                runningQue.setService(currentPerformanceStatusList.get(i).getRoute_id());
                runningQue.setRun(currentPerformanceStatusList.get(i).getBlock_alpha());
                runningQue.setStatus(currentPerformanceStatusList.get(i).getStatus());
                vehiclePositionLog = getVehiclePositionLogBean(currentPerformanceStatusList.get(i).getVehicle_id());
                if (vehiclePositionLog != null) {
                    runningQue.setPred_dev(vehiclePositionLog.getPredicted_deviation());
                    if (vehiclePositionLog.getVehicle_position_log_id() != currentPerformanceStatusList.get(i).getDeviation()) {
                        runningQue.setDevList(String.valueOf(vehiclePositionLog.getPredicted_deviation()) + "p");
                    } else {
                        runningQue.setDevList(String.valueOf(vehiclePositionLog.getPredicted_deviation()));
                    }
                } else {
                    runningQue.setPred_dev(0);
                    runningQue.setDevList("NR");
                }
                currentHeadwayStatus = getCurrentHeadwayStatusBean(currentPerformanceStatusList.get(i).getRoute_id(), currentPerformanceStatusList.get(i).getBlock_id());
                if (currentHeadwayStatus != null) {
                    runningQue.setHdev(currentHeadwayStatus.getScheduled_headway() - currentHeadwayStatus.getActual_headway());
                    runningQue.setAct_hw(currentHeadwayStatus.getActual_headway());
                    runningQue.setSched_hw(currentHeadwayStatus.getScheduled_headway());
                } else {
                    runningQue.setHdev(0);
                    runningQue.setAct_hw(0);
                    runningQue.setSched_hw(0);
                }
                runningQue.setDelta(currentPerformanceStatusList.get(i).getSchedule_delta());
                runningQue.setVid(currentPerformanceStatusList.get(i).getVehicle_id());
                runningQue.setStaff_id(currentPerformanceStatusList.get(i).getDriver_id());
                runningQue.setLast_itp(currentPerformanceStatusList.get(i).getTp_id());
                runningQue.setNext_itp(currentPerformanceStatusList.get(i).getNext_tp_id());
                runningQue.setDev(currentPerformanceStatusList.get(i).getDeviation());
                runningQue.setDate(commonUtil.formatTimestamp(currentPerformanceStatusList.get(i).getTransit_date_time(), AVMSConstant.DISPLAY_DATE_FORMAT));
                runningQue.setTime(commonUtil.formatTimestamp(currentPerformanceStatusList.get(i).getTransit_date_time(), AVMSConstant.DISPLAY_TIME_FORMAT));
                vehicleStaticInfo = getVehicleStaticInfoBean(currentPerformanceStatusList.get(i).getVehicle_id());
                /*vehicle_type db not created*/
                if (vehicleStaticInfo != null) {
                    runningQue.setVeh_type(String.valueOf(vehicleStaticInfo.getVehicle_type()) + "Missing vehicle_type DB");
                    int passCnt = currentPerformanceStatusList.get(i).getPassenger_count();
                    int cap = vehicleStaticInfo.getPassenger_capacity();
//                    int ld = passCnt * 100 / cap;
                    runningQue.setPass_cnt(passCnt);
                    runningQue.setCapacity(cap);
//                    runningQue.setLd(ld);
                }
                cadUser = getCadUserBean(currentPerformanceStatusList.get(i).getDriver_id());
                runningQue.setBc(cadUser.getLast_name());
                runningQue.setDirection(currentPerformanceStatusList.get(i).getDirection_code_id());
                runsLookup = getRunsLookup(currentPerformanceStatusList.get(i).getRun_id());
                if (runsLookup != null) {
                    runningQue.setDuty(runsLookup.getRun_alpha());
                }
                runningQue.setCursvc(currentPerformanceStatusList.get(i).getCurrent_route_id());
                block = getBlockBean(currentPerformanceStatusList.get(i).getBlock_id(), currentPerformanceStatusList.get(i).getRoute_id());
                if (block != null) {
                    runningQue.setRun_status(block.getStatus());
                }
                rqlist.add(runningQue);
            }
            System.out.println("aqlist - " + aqlist.size() + " rqlist - " + rqlist);
            queueList.setAlertQueList(aqlist);
            queueList.setRunningQueList(rqlist);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return queueList;
    }

    public ArrayList<IncidentLogBean> getIncidentLogList(int userID, String groupID, String iq_pq_ind, String routeID) {
        ArrayList<IncidentLogBean> incidentLog = new ArrayList<IncidentLogBean>();
        try {
//            incidentLogDao data = new incidentLogDao(ds);
            IncidentLogDao data = new IncidentLogDao();
            incidentLog = data.load(userID, groupID, iq_pq_ind, routeID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return incidentLog;
    }

    public ArrayList<CurrentPerformanceStatusBean> getCurrentPerformanceStatusList(int userID, String groupID, String iq_pq_ind, String routeID) {
        ArrayList<CurrentPerformanceStatusBean> currentPerformanceStatus = new ArrayList<CurrentPerformanceStatusBean>();
        try {
//            CurrentPerformanceStatusDao data = new CurrentPerformanceStatusDao(ds);
            CurrentPerformanceStatusDao data = new CurrentPerformanceStatusDao();
            currentPerformanceStatus = data.load(userID, groupID, iq_pq_ind, routeID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return currentPerformanceStatus;
    }

    public IncidentTypesBean getIncidentType(int incidentType) {
        IncidentTypesBean incidentTypes = null;
        try {
//            incidentTypesDao data = new incidentTypesDao(ds);
            IncidentTypesDao data = new IncidentTypesDao();
            incidentTypes = data.load(incidentType);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return incidentTypes;
    }


    public IncidentCodesBean getIncidentCodesBean(int incidentType, int incidentCode) {
        IncidentCodesBean incidentCodes = null;
        try {
//            incidentCodesDao data = new incidentCodesDao(ds);
            IncidentCodesDao data = new IncidentCodesDao();
            incidentCodes = data.load(incidentType, incidentCode);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return incidentCodes;
    }


    public CadUserBean getCadUserBean(int userID) {
        CadUserBean cadUser = null;
        try {
//            cadUserDao data = new cadUserDao(ds);
            CadUserDao data = new CadUserDao();
            cadUser = data.load(userID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return cadUser;
    }


    public RunsLookupBean getRunsLookup(int runID) {
        RunsLookupBean runsLookup = null;
        try {
//            runsLookupDao data = new runsLookupDao(ds);
            RunsLookupDao data = new RunsLookupDao();
            runsLookup = data.load(runID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return runsLookup;
    }

    public BlockBean getBlockBean(int blockID, int routeID) {
        BlockBean block = null;
        try {
//            blockDao data = new blockDao(ds);
            BlockDao data = new BlockDao();
            block = data.load(blockID, routeID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return block;
    }

    public TimepointNameBean getTimepointNameBean(int tpID) {
        TimepointNameBean timepointName = null;
        try {
//            timepointNameDao data = new timepointNameDao(ds);
            TimepointNameDao data = new TimepointNameDao();
            timepointName = data.load(tpID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return timepointName;
    }

    public VehiclePositionLogBean getVehiclePositionLogBean(int vehicleID) {
        VehiclePositionLogBean vehiclePositionLog = null;
        try {
//            vehiclePositionLogDao data = new vehiclePositionLogDao(ds);
            VehiclePositionLogDao data = new VehiclePositionLogDao();
            vehiclePositionLog = data.load(vehicleID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return vehiclePositionLog;
    }

    public CurrentHeadwayStatusBean getCurrentHeadwayStatusBean(int routeID, int blockID) {
        CurrentHeadwayStatusBean currentHeadwayStatus = null;
        try {
//            currentHeadwayStatusDao data = new currentHeadwayStatusDao(ds);
            CurrentHeadwayStatusDao data = new CurrentHeadwayStatusDao();
            currentHeadwayStatus = data.load(routeID, blockID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return currentHeadwayStatus;
    }


    public VehicleStaticInfoBean getVehicleStaticInfoBean(int vehicleID) {
        VehicleStaticInfoBean vehicleStaticInfo = null;
        try {
//            vehicleStaticInfoDao data = new vehicleStaticInfoDao(ds);
            VehicleStaticInfoDao data = new VehicleStaticInfoDao();
            vehicleStaticInfo = data.load(vehicleID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return vehicleStaticInfo;
    }


    public void setLoginPreference(int userID, String groupID, String routeID) {
        try {
//            loginPreferenceDao data = new loginPreferenceDao(ds);
            LoginPreferenceDao data = new LoginPreferenceDao();
            data.update(userID, groupID, routeID);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public HeadwayBean getHeadway(int routeID) {
        HeadwayBean headway = new HeadwayBean();
        ArrayList<BsTimepointsBean> dir1BusStopTP = new ArrayList<BsTimepointsBean>();
        dir1BusStopTP = getBSTimepoints(routeID, 1);
        ArrayList<BsTimepointsBean> dir2BusStopTP = new ArrayList<BsTimepointsBean>();
        dir2BusStopTP = getBSTimepoints(routeID, 2);
        ArrayList<RunningVehicleBean> dir1RunningVehicle = new ArrayList<RunningVehicleBean>();
        dir1RunningVehicle = getRunningVehicle(routeID, 1);
        ArrayList<RunningVehicleBean> dir2RunningVehicle = new ArrayList<RunningVehicleBean>();
        dir2RunningVehicle = getRunningVehicle(routeID, 2);
        ArrayList<BstBean> dir1bst = new ArrayList<BstBean>();
        dir1bst = getbst(routeID, 1);
        ArrayList<BstBean> dir2bst = new ArrayList<BstBean>();
        dir2bst = getbst(routeID, 2);

        headway.setDir1BusStopTP(dir1BusStopTP);
        headway.setDir2BusStopTP(dir2BusStopTP);
        headway.setDir1RunningVehicle(dir1RunningVehicle);
        headway.setDir2RunningVehicle(dir2RunningVehicle);
        headway.setDir1bst(dir1bst);
        headway.setDir2bst(dir2bst);
        return headway;
    }


    public ArrayList<BsTimepointsBean> getBSTimepoints(int routeID, int dirCode) {
        ArrayList<BsTimepointsBean> bsTimepoints = null;
        try {
//            timepointsDao data = new timepointsDao(ds);
            TimepointsDao data = new TimepointsDao();
            bsTimepoints = data.loadBSTimepoints(routeID, dirCode);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return bsTimepoints;
    }


    public ArrayList<RunningVehicleBean> getRunningVehicle(int routeID, int dirCode) {
        ArrayList<RunningVehicleBean> runningVehicle = null;
        try {
//            currentHeadwayStatusDao data = new currentHeadwayStatusDao(ds);
            CurrentHeadwayStatusDao data = new CurrentHeadwayStatusDao();
            runningVehicle = data.loadRunningVehicle(routeID, dirCode);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return runningVehicle;
    }

    public ArrayList<BstBean> getbst(int routeID, int dirCode) {
//        ArrayList<BstBean> bst = null;
        ArrayList<BstBean> bst = new ArrayList<BstBean>();/////////////////////
        try {
//            bstDao data = new bstDao(ds);
            BstDao data = new BstDao();
            bst = data.loadBST(routeID, dirCode);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return bst;
    }

}
