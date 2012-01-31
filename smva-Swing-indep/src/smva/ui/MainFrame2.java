/*
 * ToDo:  unimplement action listener if it is for menu events only
 * 
 */
package smva.ui;

//import com.webservices.AVMSWebServices;
//import com.webservices.LoginCheck;
//import com.webservices.LoginPreferenceBean;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import smva.jb.LoginCheckBean;
import smva.jb.LoginPreferenceBean;
import smva.mgr.SmvaBus;

public class MainFrame2 extends JFrame implements WindowListener {

    private static JTabbedPane mainContainer;
    private String svcNo = null;
    static String loginID = System.getProperty("user.name");

    public MainFrame2() {
        initTabComponents();
    }

    public MainFrame2(String svcNo) {
        this.svcNo = svcNo;
        initTabComponents();
    }

    private void initTabComponents() {
//        mainContainer = new JTabbedPane();
//        AVMSWebServices wsport = Main.port;
//        LoginCheck loginCheck = wsport.loginPreferenceCheck(loginID);
//        LoginPreferenceBean loginPreferenceBean = loginCheck.getLoginPreference();
//        System.out.println("login - " + loginCheck.getLogin() + " login preference - " + loginPreferenceBean.getGroupId());
//        ArrayList<String> alSvc = new ArrayList<String>();
//        String strSvcId = loginPreferenceBean.getRouteId();
//        StringTokenizer st = new StringTokenizer(strSvcId, ",");
//        while (st.hasMoreTokens()) {
//            String strSvc = (String) (st.nextToken());
//            strSvc = strSvc.trim();
//            alSvc.add(strSvc);
//        }
//        if (svcNo != null) {
//            for (String s : alSvc) {
//                if (svcNo.equalsIgnoreCase(s)) {
//                    sendTopAlSvc(svcNo, alSvc);
//                }
//            }
//        }
//        for (String s : alSvc) {
//            ServiceTab svcTab = new ServiceTab(s);
//            mainContainer.addTab(s, svcTab);
//        }

        mainContainer = new JTabbedPane();
//        AVMSWebServices wsport = Main.port;
//        LoginCheck loginCheck = wsport.loginPreferenceCheck(loginID);
        SmvaBus mgr = new SmvaBus();
        LoginCheckBean loginCheck = mgr.getLoginCheck(loginID);//
        LoginPreferenceBean loginPreferenceBean = loginCheck.getLogin_preference();
        System.out.println("login - " + loginCheck.getLogin() + " login preference - " + loginPreferenceBean.getGroup_id());
        ArrayList<String> alSvc = new ArrayList<String>();
        String strSvcId = loginPreferenceBean.getRoute_id();
        StringTokenizer st = new StringTokenizer(strSvcId, ",");
        while (st.hasMoreTokens()) {
            String strSvc = (String) (st.nextToken());
            strSvc = strSvc.trim();
            alSvc.add(strSvc);
        }
        if (svcNo != null) {
            for (String s : alSvc) {
                if (svcNo.equalsIgnoreCase(s)) {
                    sendTopAlSvc(svcNo, alSvc);
                }
            }
        }
        for (String s : alSvc) {
            ServiceTab svcTab = new ServiceTab(s);
            mainContainer.addTab(s, svcTab);
        }
    }

    static void sendTopAlSvc(String svcNum, ArrayList alSvc) {
        while (alSvc.indexOf(svcNum) != 0) {
            int i = alSvc.indexOf(svcNum);
            Collections.swap(alSvc, i, i - 1);
        }
    }

    static void createAndShowGUI() {
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 11));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 11));
        MainFrame2 mf2 = new MainFrame2();
        mf2.setTitle("Headway and Running Queue");
        mf2.pack();
        mf2.setLocationRelativeTo(null);
        mf2.setVisible(true);
        //mf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //mf2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        Rectangle bounds = null;
        for (GraphicsDevice curGs : gs) {
            GraphicsConfiguration[] gc = curGs.getConfigurations();
            for (GraphicsConfiguration curGc : gc) {
                bounds = curGc.getBounds();
                ColorModel cm = curGc.getColorModel();
                System.out.println(bounds.getX() + ", " + bounds.getY() + ", " + bounds.getWidth() + " x " + bounds.getHeight() + ", " + cm);    // remove from production
            }
        }
//        mf2.setBounds(bounds);
        mf2.setBounds((int) bounds.getWidth(), 0, (int) bounds.getWidth(), (int) bounds.getHeight());
        mf2.getContentPane().add(mainContainer);
        if (Main.ret_MF2 == false) {
            Main.ret_MF2 = true;
        }
    }

    public void windowActivated(WindowEvent e) {
        
    }
    public void windowDeactivated(WindowEvent e) {
        
    }
    public void windowClosed(WindowEvent e) {
        mainContainer = null;
        dispose();
        Main.ret_MF2 = false;
        System.exit(0);
    }
    public void windowClosing(WindowEvent e) {
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainContainer = null;
                dispose();
            }
        };
        
    }
    public void windowIconified(WindowEvent e) {

    }
    public void windowDeiconified(WindowEvent e) {
        
    }
    public void windowOpened(WindowEvent e) {

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });
    }
}
