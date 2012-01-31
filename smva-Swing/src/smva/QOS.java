/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smva;
import com.smva.ejb.SMVASession;
import com.smva.jb.LoginCheckBean;
import com.smva.jb.LoginPreferenceBean;
import smva.QOS.SvcAdt;
//import com.webservices.AVMSWebServices;
//import com.webservices.LoginCheck;
//import com.webservices.HeadwayBean;
//import com.webservices.RunningVehicle;
//import com.webservices.LoginPreferenceBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
/**
 *
 * @author alfred.wong
 */
public class QOS extends JPanel implements MouseListener {

    protected ArrayList<SvcAdt> alQosPaneData;
    private String strSvcId;
    private ArrayList<String> alSvc;
//    private ArrayList<RunningVehicle> alDir1RunningVeh;
//    private ArrayList<RunningVehicle> alDir2RunningVeh;
//    private ArrayList<RunningVehicle> alAllRunningVeh;
    private JPanel mainContainer;
    private int qosGridXSettg = 3;
    private int qosGridYSettg = 3;



static String loginID = System.getProperty("user.name");
    public QOS(){
        super(new BorderLayout());
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 11));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 11));
        mainContainer = new JPanel();
        initComponents();
        initCompDisplay();
        add(mainContainer);
    }

    private void initComponents(){

//        AVMSWebServices wsport = Main.port;
//        LoginCheck loginCheck = wsport.loginPreferenceCheck(loginID);
//        LoginPreferenceBean loginPreferenceBean = loginCheck.getLoginPreference();
//        System.out.println("login - " + loginCheck.getLogin() + " login preference - " + loginPreferenceBean.getGroupId());

        SMVASession rif = Main.rif;
        LoginCheckBean loginCheckBean = new LoginCheckBean();
        String strWindowsUserName = "alfred.wong";
        loginCheckBean = rif.getLoginCheck(strWindowsUserName);
        LoginPreferenceBean loginPreferenceBean = loginCheckBean.getLogin_preference();


        alSvc = new ArrayList<String>();
        //strSvcId = loginPreferenceBean.getRouteId();
        strSvcId = loginPreferenceBean.getRoute_id();
        StringTokenizer st = new StringTokenizer(strSvcId,",");
        while (st.hasMoreTokens()){
            String strSvc = (String)(st.nextToken());
            strSvc = strSvc.trim();
            alSvc.add(strSvc);
        }
//        alQosPaneData = new ArrayList<SvcAdt>();
//        for(String s: alSvc){
//            SvcAdt svcAdt = new SvcAdt(s);
//            int sInt = Integer.parseInt(s);
//            HeadwayBean headwayList = wsport.headwayList(sInt);
//            alDir1RunningVeh = (ArrayList)headwayList.getDir1RunningVehicle();
//            alDir2RunningVeh = (ArrayList)headwayList.getDir2RunningVehicle();
//            alAllRunningVeh = new ArrayList<RunningVehicle>();
//            for(RunningVehicle rv1 : alDir1RunningVeh){
//                alAllRunningVeh.add(rv1);
//            }
//            for(RunningVehicle rv2 : alDir2RunningVeh){
//                alAllRunningVeh.add(rv2);
//            }
//            int totRunVeh = alAllRunningVeh.size();
//            svcAdt.setDeployed(totRunVeh);
//            for(RunningVehicle rv : alAllRunningVeh){
//                int hwdev = rv.getScheduledHeadway()-rv.getActualHeadway();
//                if(hwdev <= -5){
//                    svcAdt.addOneSvcHw5n();
//                }
//                if(hwdev >= +5){
//                    svcAdt.addOneSvcHw5p();
//                }
//                if(hwdev == -4){
//                    svcAdt.addOneSvcHw4n();
//                }
//                if(hwdev == +4){
//                    svcAdt.addOneSvcHw4p();
//                }
//                if(hwdev == -3){
//                    svcAdt.addOneSvcHw3n();
//                }
//                if(hwdev == +3){
//                    svcAdt.addOneSvcHw3p();
//                }
//                if(hwdev == -2){
//                    svcAdt.addOneSvcHw2n();
//                }
//                if(hwdev == +2){
//                    svcAdt.addOneSvcHw2p();
//                }
//                double svcLoading = rv.getPassengerCount() / rv.getPassengerCapacity();
//                if(svcLoading >= 0.95){
//                    svcAdt.addOneSvcLoadg95();
//                }
//                if(svcLoading >= 0.93 && svcLoading < 0.95){
//                    svcAdt.addOneSvcLoadg93();
//                }
//                if (svcLoading >= 0.90 && svcLoading < 0.93){
//                    svcAdt.addOneSvcLoadg90();
//                }
//                if (svcLoading < 0.90){
//                    svcAdt.addOneSvcLoadg90below();
//                }
//                // TODO trip
//            }
//            alQosPaneData.add(svcAdt);
//        }
//        checkGridFill(alQosPaneData.size());
    }

    private void initCompDisplay(){
        GridLayout QOSPaneLayout = new GridLayout(qosGridXSettg,qosGridYSettg);
        mainContainer.setLayout(QOSPaneLayout);
        Collections.sort(alQosPaneData);
        for(SvcAdt pd : alQosPaneData){
//            SvcAdt paneData = (SvcAdt)pd;
//            ServiceQOSPane qosPane = new ServiceQOSPane(paneData);
//            mainContainer.add(qosPane);
        }
    }

    private void checkGridFill(int listSize){
        if(listSize<(qosGridXSettg * qosGridYSettg)){
            int reqdFillNo = (qosGridXSettg * qosGridYSettg)-listSize;
            for(int i=0; i<reqdFillNo; i++){
                SvcAdt svcAdtD = new SvcAdt("0");
                alQosPaneData.add(svcAdtD);
            }
        }
    }

    public void mousePressed(MouseEvent evt) {
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

    public void mouseClicked(MouseEvent evt) {
    }

    static void createAndShowGUI(){
        JFrame frame = new JFrame("QOS standalone tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new QOS());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }

    public class SvcAdt extends JPanel implements Comparable{
        private DataAdt svcNo = null;
        private int deployed = 0;
        private double svcTrip = 0;
        private DataAdt svcHw5n = null;
        private DataAdt svcHw5p = null;
        private DataAdt svcHw4n = null;
        private DataAdt svcHw4p = null;
        private DataAdt svcHw3n = null;
        private DataAdt svcHw3p = null;
        private DataAdt svcHw2n = null;
        private DataAdt svcHw2p = null;
        private DataAdt svcLoading95 = null;
        private DataAdt svcLoading93 = null;
        private DataAdt svcLoading90 = null;
        private DataAdt svcLoading90below = null;
        public int redBal = 0;
        public int orangeBal = 0;
        public int yellowBal = 0;
        public int greenBal = 0;

        public SvcAdt(String s){
                svcNo = new DataAdt(s);
                svcHw5n = new DataAdt();
                svcHw5n.setAlertLvl(Color.RED);
                svcHw5p = new DataAdt();
                svcHw5p.setAlertLvl(Color.RED);
                svcHw4n = new DataAdt();
                svcHw4n.setAlertLvl(Color.ORANGE);
                svcHw4p = new DataAdt();
                svcHw4p.setAlertLvl(Color.ORANGE);
                svcHw3n = new DataAdt();
                svcHw3n.setAlertLvl(Color.YELLOW);
                svcHw3p = new DataAdt();
                svcHw3p.setAlertLvl(Color.YELLOW);
                svcHw2n = new DataAdt();
                svcHw2n.setAlertLvl(Color.GREEN);
                svcHw2p = new DataAdt();
                svcHw2p.setAlertLvl(Color.GREEN);
                svcLoading90below = new DataAdt();
                svcLoading90below.setAlertLvl(Color.RED);
                svcLoading90 = new DataAdt();
                svcLoading90.setAlertLvl(Color.ORANGE);
                svcLoading93 = new DataAdt();
                svcLoading93.setAlertLvl(Color.YELLOW);
                svcLoading95 = new DataAdt();
                svcLoading95.setAlertLvl(Color.GREEN);
        }
        public DataAdt getSvcNo() { return svcNo;}        
        public void setSvcNo(DataAdt svcNo) { this.svcNo = svcNo;}

        public int getDeployed() { return deployed;}
        public void setDeployed(int deployed) { this.deployed = deployed;}

        public double getSvcTrip() { return svcTrip;}
        public void setSvcTrip(double svcTrip) { this.svcTrip = svcTrip;}
        
        public DataAdt getSvcHw5n() { return svcHw5n;}
        public void setSvcHw5n(DataAdt svcHw5n) { this.svcHw5n = svcHw5n;}
        public void addOneSvcHw5n(){ 
            svcHw5n.addOneToDataInt();
            redBal++;
        }

        public DataAdt getSvcHw5p() { return svcHw5p;}
        public void setSvcHw5p(DataAdt svcHw5p) { this.svcHw5p = svcHw5p;}
        public void addOneSvcHw5p(){ 
            svcHw5p.addOneToDataInt();
            redBal++;
        }

        public DataAdt getSvcHw4n() { return svcHw4n;}
        public void setSvcHw4n(DataAdt svcHw4n) { this.svcHw4n = svcHw4n;}
        public void addOneSvcHw4n(){
            svcHw4n.addOneToDataInt();
            orangeBal++;
        }

        public DataAdt getSvcHw4p() { return svcHw4p;}
        public void setSvcHw4p(DataAdt svcHw4p) { this.svcHw4p = svcHw4p;}
        public void addOneSvcHw4p(){
            svcHw4p.addOneToDataInt();
            orangeBal++;
        }
        
        public DataAdt getSvcHw3n() { return svcHw3n;}
        public void setSvcHw3n(DataAdt svcHw3n) { this.svcHw3n = svcHw3n;}
        public void addOneSvcHw3n(){
            svcHw3n.addOneToDataInt();
            yellowBal++;
        }

        public DataAdt getSvcHw3p() { return svcHw3p;}
        public void setSvcHw3p(DataAdt svcHw3p) { this.svcHw3p = svcHw3p;}
        public void addOneSvcHw3p(){
            svcHw3p.addOneToDataInt();
            yellowBal++;
        }

        public DataAdt getSvcHw2n() { return svcHw2n; }
        public void setSvcHw2n(DataAdt svcHw2n) { this.svcHw2n = svcHw2n;}
        public void addOneSvcHw2n(){
            svcHw2n.addOneToDataInt();
            greenBal++;
        }

        public DataAdt getSvcHw2p() { return svcHw2p;}
        public void setSvcHw2p(DataAdt svcHw2p) { this.svcHw2p = svcHw2p;}
        public void addOneSvcHw2p(){
            svcHw2p.addOneToDataInt();
            greenBal++;
        }

        public DataAdt getSvcLoading90below() { return svcLoading90below;}
        public void setSvcLoading90below(DataAdt svcLoading90below) { this.svcLoading90below = svcLoading90below;}
        public void addOneSvcLoadg90below(){
            svcLoading90below.addOneToDataInt();
            redBal++;
        }

        public DataAdt getSvcLoading90() { return svcLoading90;}
        public void setSvcLoading90(DataAdt svcLoading90) { this.svcLoading90 = svcLoading90;}
        public void addOneSvcLoadg90(){
            svcLoading90.addOneToDataInt();
            orangeBal++;
        }

        public DataAdt getSvcLoading93() { return svcLoading93;}
        public void setSvcLoading93(DataAdt svcLoading93) { this.svcLoading93 = svcLoading93;}
        public void addOneSvcLoadg93(){
            svcLoading93.addOneToDataInt();
            yellowBal++;
        }

        public DataAdt getSvcLoading95() { return svcLoading95;}
        public void setSvcLoading95(DataAdt svcLoading95) { this.svcLoading95 = svcLoading95;}
        public void addOneSvcLoadg95(){
            svcLoading95.addOneToDataInt();
            greenBal++;
        }

        public int getGreenBal() { return greenBal;}
        public int getOrangeBal() { return orangeBal;}
        public int getRedBal() { return redBal; }
        public int getYellowBal() { return yellowBal; }

        public int compareTo(Object obj){
            SvcAdt tmp = (SvcAdt)obj;
            if(this.getYellowBal()>=0||this.getOrangeBal()>=0||this.getRedBal()>=0){ // guard against negative integer
                if(this.getYellowBal()>tmp.getYellowBal()){
                    if(this.getOrangeBal()>tmp.getOrangeBal()){
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1;  //1. all 3 are more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return -1; //2. yellow is more and orange is more but red is equal 1
                        }else{
                            return 1; //3. yellow is more and orange is more but red is less -1
                        }
                    }else if(this.getOrangeBal()==tmp.getOrangeBal()){
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1; // 4. yellow is more but orange is equal but red is more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return -1; //5. yellow is more and orange is equal but red is equal 1
                        }else{
                            return 1; //6. yellow is more and orange is equal but red is less -1
                        }
                    }else{
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1; // 7. yellow is more but orange is less but red is more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return 1; //8. yellow is more and orange is less but red is equal -1
                        }else{
                            return 1; //9. yellow is more and orange is less but red is less -1
                        }
                    }
                }else if(this.getYellowBal()==tmp.getYellowBal()){
                    if(this.getOrangeBal()>tmp.getOrangeBal()){
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1;  //10. yellow is equal and orange is more and red is more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return -1; //11. yellow is equal and orange is more but red is equal 1
                        }else{
                            return 1; //12. yellow is equal and orange is more but red is less -1
                        }
                    }else if(this.getOrangeBal()==tmp.getOrangeBal()){
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1; // 13. yellow is equal but orange is equal but red is more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return 0; //14. yellow is equal and orange is equal and red is equal 0
                        }else{
                            return 1; //15. yellow is equal and orange is equal but red is less -1
                        }
                    }else{
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1; // 16. yellow is equal but orange is less but red is more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return 1; //17. yellow is equal and orange is less but red is equal -1
                        }else{
                            return 1; //18. yellow is equal and orange is less but red is less -1
                        }
                    }
                }else{
                    if(this.getOrangeBal()>tmp.getOrangeBal()){
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1;  //19. yellow is less and orange is more and red is more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return -1; //20. yellow is less and orange is more but red is equal 1
                        }else{
                            return 1; //21. yellow is less and orange is more but red is less -1
                        }
                    }else if(this.getOrangeBal()==tmp.getOrangeBal()){
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1; // 22. yellow is less but orange is equal but red is more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return 1; //23. yellow is less and orange is equal and red is equal -1
                        }else{
                            return 1; //24. yellow is less and orange is equal but red is less -1
                        }
                    }else{
                        if(this.getRedBal()>tmp.getRedBal()){
                            return -1; // 25. yellow is less but orange is less but red is more 1
                        }else if(this.getRedBal()==tmp.getRedBal()){
                            return 1; //26. yellow is less and orange is less but red is equal -1
                        }else{
                            return 1; //27. yellow is less and orange is less but red is less -1
                        }
                    }
                }
            }
            return 0;
        }

        public void calculateSvcNoAlLvl(){
            if(this.yellowBal>0||this.orangeBal>0||this.redBal>0){
                if(this.orangeBal>0||this.redBal>0){
                    if(this.redBal>0){
                        this.svcNo.setAlertLvl(Color.RED);
                    }else{
                        this.svcNo.setAlertLvl(Color.ORANGE);
                    }
                }else{
                    this.svcNo.setAlertLvl(Color.YELLOW);
                }
            }else{
                this.svcNo.setAlertLvl(Color.LIGHT_GRAY);
            }
        }        
    }

    public class DataAdt {
        private int dataInt = 0;
        private String dataStr = null;
        private Color alertLvl = null;

        public DataAdt(){
        }
        public DataAdt(String dataStr){
            this.dataStr = dataStr;
        }

        public String getDataStr() { return dataStr;}
        public void setDataStr(String dataStr) { this.dataStr = dataStr;}

        public int getDataInt() { return dataInt;}
        public void setDataInt(int dataInt) { this.dataInt = dataInt;}
        public void addOneToDataInt(){ dataInt++;}

        public Color getAlertLvl() { return alertLvl;}
        public void setAlertLvl(Color alertLvl) { this.alertLvl = alertLvl;}
    }

}








