
package smva.ui;
//import com.webservices.AVMSWebServices;
//import com.webservices.AlertQueList;
//import com.webservices.ListOfQueue;
//import com.webservices.LoginCheck;
//import com.webservices.LoginPreferenceBean;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import smva.jb.AlertQueListBean;
import smva.jb.ListOfQueueBean;
import smva.jb.LoginCheckBean;
import smva.jb.LoginPreferenceBean;
import smva.mgr.SmvaBus;

public class AlertQue extends JPanel {
    static String loginID = System.getProperty("user.name");
    private JSplitPane mainContainer;
    ArrayList<AlertQueListBean> AlertList = null;
    private JLabel alertQueTableLabel;
    private JPanel alertQueTablePane;
    private JScrollPane alertQueTableScrollPane;
    private JTable alertQueTable;
    private JPanel alertQueDetailPane;
    private JLabel lblDesc;
    private JTextField txfDesc;
    private JLabel lblDateTime;
    private JTextField txfDTDate;
    private JTextField txfDTTime;
    private JLabel lblOwner;
    private JTextField txfOwner;    
    private JLabel lblBC;
    private JTextField txfBC;
    private JLabel lblSvc;
    private JTextField txfSvc;    
    private JLabel lblRun;
    private JTextField txfRun;
    private JLabel lblDuty;
    private JTextField txfDuty;
    private JLabel lblLastITP;
    private JTextField txfLastITP;    
    private JLabel lblTime;
    private JTextField txfTime;
    private JLabel lblInt;
    private JTextField txfInt;
    private JLabel lblVehStatus;
    private JTextField txfVehStatus;
    private JLabel lblVID;
    private JTextField txfVID;
    private JLabel lblCurSvc;
    private JTextField txfCurSvc;
    private JLabel lblDev;
    private JTextField txfDev;
    private JLabel lblCallStat;
    private JTextField txfCallStat;
    private JLabel lblOrigSC;
    private JTextField txfOrigSC;
    private JLabel lblSC;
    private JTextField txfSC;
    private JLabel lblMsg;
    private JTextField txfMsg;
    private JLabel lblDetail;
    private JTextField txfDetail;
    private JButton btnHeadway;
    private JButton btnGIS;
    private JButton btnMessage;

    public AlertQue(){
        super(new BorderLayout());        
//        AVMSWebServices wsport =  Main.port;
//        LoginCheck loginCheck = wsport.loginPreferenceCheck(loginID);
//        String login = loginCheck.getLogin();
//        LoginPreferenceBean loginPreferenceBean = loginCheck.getLoginPreference();
//        System.out.println("login - " + login + " login preference - " + loginPreferenceBean.getGroupId());
//        System.out.println(" login preference - " + loginPreferenceBean.getGroup_id());
//        if (loginPreferenceBean.getUserId() != 0) {
//            ListOfQueue queList = wsport.queueList(loginPreferenceBean.getUserId(), loginPreferenceBean.getGroupId(), loginPreferenceBean.getRouteId());
//            initComponents();
//            AlertList = (ArrayList<AlertQueList>) queList.getAlertQueList();
//            DefaultTableModel dataForAlertQue = new DefaultTableModel() {
//                public boolean isCellEditable(int rowIndex, int vColIndex) {
//                    return false;
//                }
//            };
//            dataForAlertQue.addColumn("Incident Name");
//            dataForAlertQue.addColumn("Time");
//            dataForAlertQue.addColumn("VID");
//            dataForAlertQue.addColumn("Service");
//            dataForAlertQue.addColumn("Run");
//            dataForAlertQue.addColumn("Staff ID");
//            dataForAlertQue.addColumn("Status");
//            System.out.println("List size - " + AlertList.size());
//            if (AlertList.size() != 0) {
//                for (int i = 0; i < AlertList.size(); i++) {
//                    dataForAlertQue.insertRow(i, new Object[]{AlertList.get(i).getType(), AlertList.get(i).getTime(), AlertList.get(i).getVid(),
//                                AlertList.get(i).getService(), AlertList.get(i).getRun(), AlertList.get(i).getStaffId()});
//                }
//            }
//            alertQueTable.setModel(dataForAlertQue);
//        } else {
//            /*display for user to add in the preference.*/
//            wsport.updateLoginPreference(loginPreferenceBean.getUserId(), "8,9", "157");
//        }
//        add(mainContainer);




        SmvaBus mgr = new SmvaBus();
        LoginCheckBean loginCheckBean = new LoginCheckBean();
        LoginPreferenceBean loginPreferenceBean = new LoginPreferenceBean();
        String strWindowsUserName = "alfred.wong";
        loginCheckBean = mgr.getLoginCheck(strWindowsUserName);
        loginPreferenceBean = loginCheckBean.getLogin_preference();
//        int loginID = 110201;
//        loginPreferenceBean = rif.getLoginPreference(loginID);
//        System.out.println("Hello" +  rif.getMessage());  //getMessage() test
        System.out.println(" login preference - " + loginPreferenceBean.getGroup_id());
        if (loginPreferenceBean.getUser_id() != 0) {
            ListOfQueueBean queList = mgr.getAllQue(loginPreferenceBean.getUser_id(), loginPreferenceBean.getGroup_id(), loginPreferenceBean.getRoute_id());
            initComponents();
            AlertList = (ArrayList<AlertQueListBean>) queList.getAlertQueList();
            DefaultTableModel dataForAlertQue = new DefaultTableModel() {
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }
            };
            dataForAlertQue.addColumn("Incident Name");
            dataForAlertQue.addColumn("Time");
            dataForAlertQue.addColumn("VID");
            dataForAlertQue.addColumn("Service");
            dataForAlertQue.addColumn("Run");
            dataForAlertQue.addColumn("Staff ID");
            dataForAlertQue.addColumn("Status");
            System.out.println("List size - " + AlertList.size());
            if (AlertList.size() != 0) {
                for (int i = 0; i < AlertList.size(); i++) {
                    dataForAlertQue.insertRow(i, new Object[]{AlertList.get(i).getType(), AlertList.get(i).getTime(), AlertList.get(i).getVid(),
                                AlertList.get(i).getService(), AlertList.get(i).getRun(), AlertList.get(i).getStaff_id()});
                }
            }
            alertQueTable.setModel(dataForAlertQue);
        } else {
            /*display for user to add in the preference.*/
//            wsport.updateLoginPreference(loginPreferenceBean.getUserId(), "8,9", "157");
            mgr.setLoginPreference(loginPreferenceBean.getUser_id(), "8,9", "157");
        }
        add(mainContainer);
    }


    private void initComponents(){
        initAlertQueTableComponents();
        initAlertQueDetailsComponents();
        mainContainer = new JSplitPane();
        mainContainer.setDividerLocation(550);
        mainContainer.setDividerSize(2);
        mainContainer.setOrientation(JSplitPane.VERTICAL_SPLIT);
        mainContainer.setTopComponent(alertQueTablePane);
        mainContainer.setBottomComponent(alertQueDetailPane);
    }

    @SuppressWarnings("unchecked")
    private void initAlertQueTableComponents(){
        alertQueTableLabel = new JLabel();
        alertQueTablePane = new JPanel();
        alertQueTableScrollPane = new JScrollPane();
        alertQueTable = new JTable();
        alertQueTableLabel.setFont(new java.awt.Font("Arial", 1, 11));
        alertQueTableLabel.setText("   Alert Queue");
        alertQueTable.setModel(
                new DefaultTableModel(
                                        new Object [][] {
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
                                        new String [] {"Incident Name", "Time", "VIDeo", "Service", "Run", "Staff ID", "Status", "Message"}
                                    )
                {
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false, false, false
                    };
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                }
        );

        alertQueTable.getTableHeader().setReorderingAllowed(false);
        alertQueTable.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        alertQueTableMouseClicked(evt);
                    }
                }
        );
        alertQueTableScrollPane.setViewportView(alertQueTable);
        GroupLayout alertQueTablePaneLayout = new GroupLayout(alertQueTablePane);
        alertQueTablePane.setLayout(alertQueTablePaneLayout);
        alertQueTablePaneLayout.setHorizontalGroup(
            alertQueTablePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(alertQueTableLabel, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
            .addComponent(alertQueTableScrollPane, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        alertQueTablePaneLayout.setVerticalGroup(
            alertQueTablePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(alertQueTablePaneLayout.createSequentialGroup()
                .addComponent(alertQueTableLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alertQueTableScrollPane, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );
    }

    @SuppressWarnings("unchecked")
    private void initAlertQueDetailsComponents(){
        alertQueDetailPane = new JPanel();
        btnHeadway = new JButton("HeadWay");
        btnGIS = new JButton("GIS");
        btnMessage = new JButton("Message");

        btnHeadway.addActionListener(new ActionListener(){
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent e) {
//                MainFrame2 headwayFrame = new MainFrame2();
//                headwayFrame.createAndShowGUI();
            }
        });

        lblDesc = new JLabel();
        txfDesc = new JTextField();
        lblDateTime = new JLabel();
        txfDTDate = new JTextField();
        txfDTTime = new JTextField();
        lblOwner = new JLabel();
        txfOwner = new JTextField();
        lblBC = new JLabel();
        txfBC = new JTextField();
        lblSvc = new JLabel();
        txfSvc = new JTextField();
        lblRun = new JLabel();
        txfRun = new JTextField();
        lblDuty = new JLabel();
        txfDuty = new JTextField();
        lblLastITP = new JLabel();
        txfLastITP = new JTextField();
        lblTime = new JLabel();
        txfTime = new JTextField();
        lblInt = new JLabel();
        txfInt = new JTextField();
        lblVehStatus = new JLabel();
        txfVehStatus = new JTextField();
        lblVID = new JLabel();
        txfVID = new JTextField();
        lblCurSvc = new JLabel();
        txfCurSvc = new JTextField();
        lblDev = new JLabel();
        txfDev = new JTextField();
        lblCallStat = new JLabel();
        txfCallStat = new JTextField();
        lblOrigSC = new JLabel();
        txfOrigSC = new JTextField();
        lblSC = new JLabel();
        txfSC = new JTextField();
        lblMsg = new JLabel();
        txfMsg = new JTextField();
        lblDetail = new JLabel();
        txfDetail = new JTextField();

        lblDesc.setText("Desc:");
        txfDesc.setText(" ");
        lblDateTime.setText("Date/Time:");
        txfDTDate.setText(" ");
        txfDTTime.setText(" ");
        lblOwner.setText("Owner:");
        txfOwner.setText(" ");
        lblBC.setText("BC:");
        txfBC.setText(" ");
        lblSvc.setText("Svc:");
        txfSvc.setText(" ");
        lblRun.setText("Run:");
        txfRun.setText(" ");        
        lblDuty.setText("Duty:");
        txfDuty.setText(" ");
        lblLastITP.setText("Last ITP:");
        txfLastITP.setText(" ");
        lblTime.setText("Time:");
        txfTime.setText(" ");
        lblInt.setText("Int:");
        txfInt.setText(" ");
        lblVehStatus.setText("Vehicle Status:");
        txfVehStatus.setText(" ");
        lblVID.setText("Vehicle ID:");
        txfVID.setText(" ");
        lblCurSvc.setText("CurSvc:");
        txfCurSvc.setText(" ");
        lblDev.setText("Dev:");
        txfDev.setText(" ");
        lblCallStat.setText("Call Stat:");
        txfCallStat.setText(" ");
        lblOrigSC.setText("Orig SC:");
        txfOrigSC.setText(" ");
        lblSC.setText("SC:");
        txfSC.setText(" ");
        lblMsg.setText("Msg:");
        txfMsg.setText(" ");
        lblDetail.setText("Detail:");
        txfDetail.setText("      ");


        GroupLayout alertQueDetailPaneLayout = new GroupLayout(alertQueDetailPane);
        alertQueDetailPane.setLayout(alertQueDetailPaneLayout);
        alertQueDetailPaneLayout.setHorizontalGroup(
              alertQueDetailPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(alertQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(btnHeadway)
                        .addGap(20,20,20)
                        .addComponent(btnGIS)
                        .addGap(20,20,20)
                        .addComponent(btnMessage)
                        .addGap(20,20,20)
                    )
                   .addGroup(alertQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblDesc)
                        .addGap(5, 5, 5)
                        .addComponent(txfDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblDateTime)
                        .addGap(5, 5, 5)
                        .addComponent(txfDTDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDTTime)
                        .addGap(20, 20, 20)
                        .addComponent(lblOwner)
                        .addGap(5, 5, 5)
                        .addComponent(txfOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    )
                    .addGroup(alertQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblBC)
                        .addGap(5, 5, 5)
                        .addComponent(txfBC, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(5,5,5)
                        .addComponent(txfDuty, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    )
                    .addGroup(alertQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblLastITP)
                        .addGap(5, 5, 5)
                        .addComponent(txfLastITP)
                        .addGap(20, 20, 20)
                        .addComponent(lblTime)
                        .addGap(5, 5, 5)
                        .addComponent(txfTime)
                        .addGap(20,20,20)
                        .addComponent(lblInt)
                        .addGap(5, 5, 5)
                        .addComponent(txfInt, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    )
                    .addGroup(alertQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblVehStatus)
                        .addGap(5, 5, 5)
                        .addComponent(txfVehStatus)
                        .addGap(20, 20, 20)
                        .addComponent(lblVID)
                        .addGap(5, 5, 5)
                        .addComponent(txfVID)
                        .addGap(20, 20, 20)
                        .addComponent(lblCurSvc)
                        .addGap(5, 5, 5)
                        .addComponent(txfCurSvc, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    )
                    .addGroup(alertQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblDev)
                        .addGap(5, 5, 5)
                        .addComponent(txfDev)
                        .addGap(20, 20, 20)
                        .addComponent(lblCallStat)
                        .addGap(5, 5, 5)
                        .addComponent(txfCallStat)
                        .addGap(20, 20, 20)
                        .addComponent(lblOrigSC)
                        .addGap(5, 5, 5)
                        .addComponent(txfOrigSC)
                        .addGap(20, 20, 20)
                        .addComponent(lblSC)
                        .addGap(5, 5, 5)
                        .addComponent(txfSC, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    )
                    .addGroup(alertQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblMsg)
                        .addGap(5, 5, 5)
                        .addComponent(txfMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    )
                    .addGroup(alertQueDetailPaneLayout.createSequentialGroup()
                        .addComponent(lblDetail)
                        .addGap(5, 5, 5)
                        .addComponent(txfDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    )
                )
                .addContainerGap()
        ); 

        alertQueDetailPaneLayout.setVerticalGroup(
            alertQueDetailPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHeadway)
                    .addComponent(btnGIS)
                    .addComponent(btnMessage)
                )
                .addGap(10,10,10)
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesc)  
                    .addComponent(txfDesc)
                    .addComponent(lblDateTime)
                    .addComponent(txfDTDate)
                    .addComponent(txfDTTime)
                    .addComponent(lblOwner)
                    .addComponent(txfOwner)
                )
                .addGap(10, 10, 10)
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBC)
                    .addComponent(txfBC)
                    .addComponent(lblSvc)
                    .addComponent(txfSvc)
                    .addComponent(lblRun)
                    .addComponent(txfRun)
                    .addComponent(lblDuty)
                    .addComponent(txfDuty)
                )
                .addGap(10, 10, 10)
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastITP)
                    .addComponent(txfLastITP)
                    .addComponent(lblTime)
                    .addComponent(txfTime)
                    .addComponent(lblInt)
                    .addComponent(txfInt)
                )
                .addGap(10, 10, 10)
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVehStatus)
                    .addComponent(txfVehStatus)
                    .addComponent(lblVID)
                    .addComponent(txfVID)
                    .addComponent(lblCurSvc)
                    .addComponent(txfCurSvc)
                )
                .addGap(10, 10, 10)
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDev)
                    .addComponent(txfDev)
                    .addComponent(lblCallStat)
                    .addComponent(txfCallStat)
                    .addComponent(lblOrigSC)
                    .addComponent(txfOrigSC)
                    .addComponent(lblSC)
                    .addComponent(txfSC)
                )
                .addGap(10, 10, 10)
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMsg)
                    .addComponent(txfMsg)
                )
                .addGap(10, 10, 10)
                .addGroup(alertQueDetailPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetail)
                    .addComponent(txfDetail)
                )
                .addContainerGap()
        );
    }

    private void alertQueTableMouseClicked(MouseEvent evt) {
        String output = "";
        output = String.format("Row %d", alertQueTable.getSelectionModel().getLeadSelectionIndex());
        System.out.println(output);
        output = String.format("Column %d", alertQueTable.getColumnModel().getSelectionModel().getLeadSelectionIndex());
        System.out.println(output);

        if (evt.getClickCount() == 1) {
            txfDesc.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getDesc());
            txfDTDate.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getDate());
            txfDTTime.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getTime());
            txfOwner.setText(String.valueOf(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getOwner()));
            txfBC.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getBc());
            txfSvc.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getSvc());
            txfRun.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getRun());
            txfDuty.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getDuty());
            txfLastITP.setText(String.valueOf(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getLast_itp()));
            txfTime.setText(String.valueOf(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getTime()));
            txfInt.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getIntersection());
            txfVehStatus.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getVeh_status());
            txfVID.setText(String.valueOf(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getVid()));
            txfCurSvc.setText(String.valueOf(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getCursvc()));
            txfDev.setText(String.valueOf(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getDev()));
            txfCallStat.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getCal_status());
            txfOrigSC.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getOrig_sc());
            txfSC.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getSc());
            txfMsg.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getMsg());
            txfDetail.setText(AlertList.get(alertQueTable.getSelectionModel().getLeadSelectionIndex()).getSc());
        } else if (evt.getClickCount() == 2) {
//            MainFrame2 mf2 = new MainFrame2();
//            if (MainFrame1.ret_MF2.equals("true")) {
//                mf2.setVisible(true);
//                MainFrame1.ret_MF2 = "false";
//            }
        }
    }
}
