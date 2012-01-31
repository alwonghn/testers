/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smva.ui;

//import com.webservices.AVMSWebServices;
//import com.webservices.ListOfQueue;
//import com.webservices.LoginCheck;
//import com.webservices.LoginPreferenceBean;
//import com.webservices.RunningQueList;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import smva.jb.ListOfQueueBean;
import smva.jb.LoginCheckBean;
import smva.jb.LoginPreferenceBean;
import smva.jb.RunningQueListBean;
import smva.mgr.SmvaBus;

public class RunQue extends JPanel {

    static String loginID = System.getProperty("user.name");
    private JSplitPane mainContainer;
    ArrayList<RunningQueListBean> RunningList = null;
    private JLabel runQueTableLabel;
    private JPanel runQueTablePane;
    private JScrollPane runQueTableScrollPane;
    private JTable runQueTable;
    private JPanel runQueDetailPane;
    JLabel lblVehStatus;
    JTextField txfVehStatus;
    JLabel lblDev;
    JTextField txfDev;
    JLabel lblDateTime;
    JTextField txfDTDate;
    JTextField txfDTTime;
    JLabel lblPredDev;
    JTextField txfPredDev;
    JLabel lblActHW;
    JTextField txfActHW;
    JLabel lblSchedHW;
    JTextField txfSchedHW;
    JLabel lblDelta;
    JTextField txfDelta;
    JLabel lblVID;
    JTextField txfVID;
    JLabel lblVehType;
    JTextField txfVehType;
    JLabel lblLdr;
    JTextField txfLdr;
    JLabel lblBC;
    JTextField txfBC;
    JLabel lblSvc;
    JTextField txfSvc;
    JLabel lblRun;
    JTextField txfRun;
    JLabel lblDuty;
    JTextField txfDuty;
    JLabel lblDirectn;
    JTextField txfDirectn;
    JLabel lblCurSvc;
    JTextField txfCurSvc;
    JLabel lblCallStatus;
    JTextField txfCallStatus;
    JLabel lblLastITP;
    JTextField txfLastITP;
    JLabel lblNextITP;
    JTextField txfNextITP;
    JLabel lblPassCnt;
    JTextField txfPassCnt;
    JLabel lblCapacity;
    JTextField txfCapacity;
    JLabel lblPctLd;
    JTextField txfPctLd;
    JLabel lblRunStatus;
    JTextField txfRunStatus;
    JLabel lblOpenDay;
    JTextField txfOpenDay;

    public RunQue(String Svc) {
//        super(new BorderLayout());
//        AVMSWebServices wsport = Main.port;
//        LoginCheck loginCheck = wsport.loginPreferenceCheck(loginID);
//        String login = loginCheck.getLogin();
//        LoginPreferenceBean loginPreferenceBean = loginCheck.getLoginPreference();
//        System.out.println("login - " + login + " login preference - " + loginPreferenceBean.getGroupId());
//        if (loginPreferenceBean.getUserId() != 0) {
//            ListOfQueue queList = wsport.queueList(loginPreferenceBean.getUserId(), loginPreferenceBean.getGroupId(), loginPreferenceBean.getRouteId());
//            initComponents();
//            RunningList = (ArrayList<RunningQueList>) queList.getRunningQueList();
//            DefaultTableModel dataForRunningQue = new DefaultTableModel() {
//
//                public boolean isCellEditable(int rowIndex, int vColIndex) {
//                    return false;
//                }
//            };
//            dataForRunningQue.addColumn("Service");
//            dataForRunningQue.addColumn("Run");
//            dataForRunningQue.addColumn("Status");
//            dataForRunningQue.addColumn("Dev");
//            dataForRunningQue.addColumn("HDev");
//            dataForRunningQue.addColumn("Delta");
//            dataForRunningQue.addColumn("VID");
//            dataForRunningQue.addColumn("Staff ID");
//            dataForRunningQue.addColumn("Last ITP");
//            System.out.println("List size - " + RunningList.size());
//            if (RunningList.size() != 0) {
//                for (int i = 0; i < RunningList.size(); i++) {
//                    dataForRunningQue.insertRow(i, new Object[]{RunningList.get(i).getService(), RunningList.get(i).getRun(), RunningList.get(i).getStatus(),
//                                RunningList.get(i).getDev(), RunningList.get(i).getHdev(), RunningList.get(i).getDelta(), RunningList.get(i).getVid(),
//                                RunningList.get(i).getStaffId(), RunningList.get(i).getService()});
//                }
//            }
//            runQueTable.setModel(dataForRunningQue);
//        } else {
//            /*display for user to add in the preference.*/
//            wsport.updateLoginPreference(loginPreferenceBean.getUserId(), "8,9", "157");
//        }
//        add(mainContainer);

        super(new BorderLayout());
//        AVMSWebServices wsport = Main.port;
//        LoginCheck loginCheck = wsport.loginPreferenceCheck(loginID);

        SmvaBus mgr = new SmvaBus();
        LoginCheckBean loginCheck = mgr.getLoginCheck(loginID);
        String login = loginCheck.getLogin();
        LoginPreferenceBean loginPreferenceBean = loginCheck.getLogin_preference();
//        System.out.println("login - " + login + " login preference - " + loginPreferenceBean.getGroupId());
        System.out.println("login - " + login + " login preference - " + loginPreferenceBean.getGroup_id());
        if (loginPreferenceBean.getUser_id() != 0) {
//            ListOfQueue queList = wsport.queueList(loginPreferenceBean.getUserId(), loginPreferenceBean.getGroupId(), loginPreferenceBean.getRouteId());
            ListOfQueueBean queList = mgr.getAllQue(loginPreferenceBean.getUser_id(), loginPreferenceBean.getGroup_id(), loginPreferenceBean.getRoute_id());
            initComponents();
            RunningList = (ArrayList<RunningQueListBean>) queList.getRunningQueList();
            DefaultTableModel dataForRunningQue = new DefaultTableModel() {

                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }
            };
            dataForRunningQue.addColumn("Service");
            dataForRunningQue.addColumn("Run");
            dataForRunningQue.addColumn("Status");
            dataForRunningQue.addColumn("Dev");
            dataForRunningQue.addColumn("HDev");
            dataForRunningQue.addColumn("Delta");
            dataForRunningQue.addColumn("VID");
            dataForRunningQue.addColumn("Staff ID");
            dataForRunningQue.addColumn("Last ITP");
            System.out.println("List size - " + RunningList.size());
            if (RunningList.size() != 0) {
                for (int i = 0; i < RunningList.size(); i++) {
                    dataForRunningQue.insertRow(i, new Object[]{RunningList.get(i).getService(), RunningList.get(i).getRun(), RunningList.get(i).getStatus(),
                                RunningList.get(i).getDev(), RunningList.get(i).getHdev(), RunningList.get(i).getDelta(), RunningList.get(i).getVid(),
                                RunningList.get(i).getStaff_id(), RunningList.get(i).getService()});
                }
            }
            runQueTable.setModel(dataForRunningQue);
        } else {
            /*display for user to add in the preference.*/
//            wsport.updateLoginPreference(loginPreferenceBean.getUserId(), "8,9", "157");
            mgr.setLoginPreference(loginPreferenceBean.getUser_id(), "8,9", "157");
        }
        add(mainContainer);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        initRunQueTableComponents();
        initRunQueDetailsComponents();
        mainContainer = new JSplitPane();
        mainContainer.setDividerLocation(700);
        mainContainer.setDividerSize(2);
        mainContainer.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
//        mainContainer.setResizeWeight(0.5);
        mainContainer.setLeftComponent(runQueTablePane);
        mainContainer.setRightComponent(runQueDetailPane);
    }

    @SuppressWarnings("unchecked")
    private void initRunQueTableComponents() {
        runQueTableLabel = new JLabel();
        runQueTablePane = new JPanel();
        runQueTableScrollPane = new JScrollPane();
        runQueTable = new JTable();
        runQueTableLabel.setFont(new Font("Arial", 1, 11));
        runQueTableLabel.setText("    Running Queue");
        runQueTable.setModel(
                new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{"Incident Name", "Time", "VIDeo", "Service", "Run", "Staff ID", "Status", "Message"}) {

                    boolean[] canEdit = new boolean[]{
                        false, false, false, false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
        runQueTable.getTableHeader().setReorderingAllowed(false);
        runQueTable.addMouseListener(
                new MouseAdapter() {

                    public void mouseClicked(MouseEvent evt) {
                        runQueTableMouseClicked(evt);
                    }
                });

        runQueTableScrollPane.setViewportView(runQueTable);

        GroupLayout runQueTablePaneLayout = new GroupLayout(runQueTablePane);
        runQueTablePane.setLayout(runQueTablePaneLayout);
        runQueTablePaneLayout.setHorizontalGroup(
                runQueTablePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(runQueTableLabel, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addComponent(runQueTableScrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        runQueTablePaneLayout.setVerticalGroup(
                runQueTablePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(runQueTablePaneLayout.createSequentialGroup()
                        .addComponent(runQueTableLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runQueTableScrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     )
        );
    }

    @SuppressWarnings("unchecked")
    private void initRunQueDetailsComponents() {
        runQueDetailPane = new JPanel();

        lblVehStatus = new JLabel();
        txfVehStatus = new JTextField();
        lblDev = new JLabel();
        txfDev = new JTextField();
        lblDateTime = new JLabel();
        txfDTDate = new JTextField();
        txfDTTime = new JTextField();
        lblPredDev = new JLabel();
        txfPredDev = new JTextField();
        lblActHW = new JLabel();
        txfActHW = new JTextField();
        lblSchedHW = new JLabel();
        txfSchedHW = new JTextField();
        lblDelta = new JLabel();
        txfDelta = new JTextField();
        lblVID = new JLabel();
        txfVID = new javax.swing.JTextField();
        lblVehType = new JLabel();
        txfVehType = new JTextField();
        lblLdr = new JLabel();
        txfLdr = new JTextField();
        lblBC = new JLabel();
        txfBC = new JTextField();
        lblSvc = new JLabel();
        txfSvc = new JTextField();
        lblRun = new JLabel();
        txfRun = new JTextField();
        lblDuty = new JLabel();
        txfDuty = new JTextField();
        lblDirectn = new JLabel();
        txfDirectn = new JTextField();
        lblCurSvc = new JLabel();
        txfCurSvc = new JTextField();
        lblCallStatus = new JLabel();
        txfCallStatus = new JTextField();
        lblLastITP = new JLabel();
        txfLastITP = new JTextField();
        lblNextITP = new JLabel();
        txfNextITP = new JTextField();
        lblPassCnt = new JLabel();
        txfPassCnt = new JTextField();
        lblCapacity = new JLabel();
        txfCapacity = new JTextField();
        lblPctLd = new JLabel();
        txfPctLd = new JTextField();
        lblRunStatus = new JLabel();
        txfRunStatus = new JTextField();
        lblOpenDay = new JLabel();
        txfOpenDay = new JTextField();

        lblVehStatus.setText("Veh Status:");
        txfVehStatus.setText("   ");
        lblDev.setText("Dev:");
        txfDev.setText("   ");
        lblDateTime.setText("Date/Time:");
        txfDTDate.setText("         ");
        txfDTTime.setText("         ");
        lblPredDev.setText("Pred Dev:");
        txfPredDev.setText("   ");
        lblActHW.setText("Act HW:");
        txfActHW.setText("    ");
        lblSchedHW.setText("Sched HW:");
        txfSchedHW.setText("   ");
        lblDelta.setText("Delta:");
        txfDelta.setText("     ");
        lblVID.setText("Veh ID:");
        txfVID.setText("    ");
        lblVehType.setText("Veh Type:");
        txfVehType.setText("    ");
        lblLdr.setText("Leader:");
        txfLdr.setText("   ");
        lblBC.setText("BC:");
        txfBC.setText("              ");
        lblSvc.setText("Svc:");
        txfSvc.setText("    ");
        lblRun.setText("Run:");
        txfRun.setText("    ");
        lblDuty.setText("Duty:");
        txfDuty.setText("     ");
        lblDirectn.setText("Direction:");
        txfDirectn.setText("    ");
        lblCurSvc.setText("CurSvc:");
        txfCurSvc.setText("    ");
        lblCallStatus.setText("Call Status:");
        txfCallStatus.setText("    ");
        lblLastITP.setText("Last ITP:");
        txfLastITP.setText("   ");
        lblNextITP.setText("Next ITP:");
        txfNextITP.setText("     ");
        lblPassCnt.setText("Pass Cnt:");
        txfPassCnt.setText("   ");
        lblCapacity.setText("Capacity:");
        txfCapacity.setText("    ");
        lblPctLd.setText("% Ld:");
        txfPctLd.setText("   ");
        lblRunStatus.setText("Run Status:");
        txfRunStatus.setText("       ");
        lblOpenDay.setText("Open Day:");
        txfOpenDay.setText("  ");

        GroupLayout runQueDetailPaneLayout = new GroupLayout(runQueDetailPane);
        runQueDetailPane.setLayout(runQueDetailPaneLayout);

        runQueDetailPaneLayout.setHorizontalGroup(
                runQueDetailPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(runQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(runQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblVehStatus)
                        .addGap(5, 5, 5)
                        .addComponent(txfVehStatus)
                        .addGap(20, 20, 20)
                        .addComponent(lblDev)
                        .addGap(5, 5, 5)
                        .addComponent(txfDev)
                        .addGap(20, 20, 20)
                        .addComponent(lblDateTime)
                        .addGap(5, 5, 5)
                        .addComponent(txfDTDate)
                        .addGap(5, 5, 5)
                        .addComponent(txfDTTime)
                     )
                     .addGroup(runQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblPredDev)
                        .addGap(5, 5, 5)
                        .addComponent(txfPredDev)
                        .addGap(20, 20, 20)
                        .addComponent(lblActHW)
                        .addGap(5, 5, 5)
                        .addComponent(txfActHW)
                        .addGap(18, 18, 18)
                        .addComponent(lblSchedHW)
                        .addGap(5, 5, 5)
                        .addComponent(txfSchedHW)
                        .addGap(20, 20, 20)
                        .addComponent(lblDelta)
                        .addGap(5, 5, 5)
                        .addComponent(txfDelta, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                     )
                     .addGroup(runQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblVID)
                        .addGap(5, 5, 5)
                        .addComponent(txfVID)
                        .addGap(20, 20, 20)
                        .addComponent(lblVehType)
                        .addGap(5, 5, 5)
                        .addComponent(txfVehType)
                        .addGap(20, 20, 20)
                        .addComponent(lblLdr)
                        .addGap(5, 5, 5)
                        .addComponent(txfLdr)
                     )
                     .addGroup(runQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblBC)
                        .addGap(5, 5, 5)
                        .addComponent(txfBC)
                        .addGap(20, 20, 20)
                        .addComponent(lblSvc)
                        .addGap(5, 5, 5)
                        .addComponent(txfSvc)
                        .addGap(20, 20, 20)
                        .addComponent(lblRun)
                        .addGap(5, 5, 5)
                        .addComponent(txfRun)
                        .addGap(20, 20, 20)
                        .addComponent(lblDuty)
                        .addGap(5, 5, 5)
                        .addComponent(txfDuty)
                        .addGap(20, 20, 20)
                     )
                     .addGroup(runQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblDirectn)
                        .addGap(5, 5, 5)
                        .addComponent(txfDirectn)
                        .addGap(20, 20, 20)
                        .addComponent(lblCurSvc)
                        .addGap(5, 5, 5)
                        .addComponent(txfCurSvc)
                        .addGap(20, 20, 20)
                        .addComponent(lblCallStatus)
                        .addGap(5, 5, 5)
                        .addComponent(txfCallStatus)
                      )
                      .addGroup(runQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblLastITP)
                        .addGap(5, 5, 5)
                        .addComponent(txfLastITP)
                        .addGap(20, 20, 20)
                        .addComponent(lblNextITP)
                        .addGap(18, 18, 18)
                        .addComponent(txfNextITP))
                        .addGroup(runQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblPassCnt)
                        .addGap(5, 5, 5)
                        .addComponent(txfPassCnt)
                        .addGap(20, 20, 20)
                        .addComponent(lblCapacity)
                        .addGap(5, 5, 5)
                        .addComponent(txfCapacity)
                        .addGap(20, 20, 20)
                        .addComponent(lblPctLd)
                        .addGap(5, 5, 5)
                        .addComponent(txfPctLd)
                      )
                      .addGroup(runQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblRunStatus)
                        .addGap(5, 5, 5)
                        .addComponent(txfRunStatus)
                        .addGap(20, 20, 20)
                        .addComponent(lblOpenDay)
                        .addGap(5, 5, 5)
                        .addComponent(txfOpenDay)
                      )
                )
                .addContainerGap());


        runQueDetailPaneLayout.setVerticalGroup(
                runQueDetailPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(runQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVehStatus)
                        .addComponent(txfVehStatus)
                        .addComponent(lblDev)
                        .addComponent(txfDev)
                        .addComponent(lblDateTime)
                        .addComponent(txfDTDate)
                        .addComponent(txfDTTime)
                     )
                     .addGap(10, 10, 10)
                     .addGroup(runQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPredDev)
                        .addComponent(txfPredDev)
                        .addComponent(lblActHW)
                        .addComponent(txfActHW)
                        .addComponent(lblSchedHW)
                        .addComponent(txfSchedHW)
                        .addComponent(lblDelta)
                        .addComponent(txfDelta)
                      )
                      .addGap(10, 10, 10)
                      .addGroup(runQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVID)
                        .addComponent(txfVID)
                        .addComponent(lblVehType)
                        .addComponent(txfVehType)
                        .addComponent(lblLdr)
                        .addComponent(txfLdr)
                      )
                      .addGap(10, 10, 10)
                      .addGroup(runQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBC)
                        .addComponent(txfBC)
                        .addComponent(lblSvc)
                        .addComponent(txfSvc)
                        .addComponent(lblRun)
                        .addComponent(txfRun)
                        .addComponent(lblDuty)
                        .addComponent(txfDuty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      )
                      .addGap(10, 10, 10)
                      .addGroup(runQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                          .addComponent(lblDirectn)
                          .addComponent(txfDirectn)
                          .addComponent(lblCurSvc)
                          .addComponent(txfCurSvc)
                          .addComponent(lblCallStatus)
                          .addComponent(txfCallStatus)
                      )
                      .addGap(10, 10, 10)
                      .addGroup(runQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLastITP)
                        .addComponent(txfLastITP)
                        .addComponent(lblNextITP)
                        .addComponent(txfNextITP)
                      )
                      .addGap(10, 10, 10)
                      .addGroup(runQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                          .addComponent(lblPassCnt)
                          .addComponent(txfPassCnt)
                          .addComponent(lblCapacity)
                          .addComponent(txfCapacity)
                          .addComponent(lblPctLd)
                          .addComponent(txfPctLd)
                      )
                      .addGap(10, 10, 10)
                      .addGroup(runQueDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRunStatus)
                        .addComponent(txfRunStatus)
                        .addComponent(lblOpenDay)
                        .addComponent(txfOpenDay)
                      )
                      .addContainerGap()
       );
    }

    private void runQueTableMouseClicked(MouseEvent evt) {
        String output = "";
        output = String.format("Row %d", runQueTable.getSelectionModel().getLeadSelectionIndex());
        System.out.println(output);
        output = String.format("Column %d", runQueTable.getColumnModel().getSelectionModel().getLeadSelectionIndex());
        System.out.println(output);

        if (evt.getClickCount() == 1) {
//            txfVehStatus.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getStatus());
//            txfDev.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDev()));
//            txfDTDate.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDate());
//            txfDTTime.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getTime());
//            txfPredDev.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getPredDev()));
//            txfActHW.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getActHw()));
//            txfSchedHW.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getSchedHw()));
//            txfDelta.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDelta()));
//            txfVID.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getVid()));
//            txfVehType.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getVehType());
//            txfLdr.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getLeader()));
//            txfBC.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getBc());
//            txfSvc.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getService()));
//            txfRun.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getRun());
//            txfDuty.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDuty());
//            txfDirectn.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDirection()));
//            txfCurSvc.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getCursvc()));
//            txfCallStatus.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getCallStatus());
//            txfLastITP.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getLastItp()));
//            txfNextITP.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getNextItp()));
//            txfPassCnt.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getPassCnt()));
//            txfCapacity.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getCapacity()));
//            txfPctLd.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getLd()));
//            txfRunStatus.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getRunStatus());
//            txfOpenDay.setText("");
            txfVehStatus.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getStatus());
            txfDev.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDev()));
            txfDTDate.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDate());
            txfDTTime.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getTime());
//            txfPredDev.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getPredDev()));
            txfPredDev.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getPred_dev()));
//            txfActHW.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getActHw()));
            txfActHW.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getAct_hw()));
//            txfSchedHW.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getSchedHw()));
            txfSchedHW.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getSched_hw()));
            txfDelta.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDelta()));
            txfVID.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getVid()));
//            txfVehType.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getVehType());
            txfVehType.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getVeh_type());
            txfLdr.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getLeader()));
            txfBC.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getBc());
            txfSvc.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getService()));
            txfRun.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getRun());
            txfDuty.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDuty());
            txfDirectn.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getDirection()));
            txfCurSvc.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getCursvc()));
//            txfCallStatus.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getCallStatus());
            txfCallStatus.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getCall_status());
//            txfLastITP.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getLastItp()));
            txfLastITP.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getLast_itp()));
//            txfNextITP.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getNextItp()));
            txfNextITP.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getNext_itp()));
//            txfPassCnt.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getPassCnt()));
            txfPassCnt.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getPass_cnt()));
            txfCapacity.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getCapacity()));
            txfPctLd.setText(String.valueOf(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getLd()));
//            txfRunStatus.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getRunStatus());
            txfRunStatus.setText(RunningList.get(runQueTable.getSelectionModel().getLeadSelectionIndex()).getRun_status());
            txfOpenDay.setText("");
        } else if (evt.getClickCount() == 2) {
//            NewJFrame1 newframe = new NewJFrame1();
//            if (ret.equals("true")) {
//                newframe.setVisible(true);
//                ret = "false";
//            }
        }
    }
}
