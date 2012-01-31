/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smva;

//import com.webservices.AVMSWebServices;
//import com.webservices.AVMSWebServicesService;
//import com.webservices.LoginCheck;
//import com.webservices.LoginPreferenceBean;
import java.lang.reflect.InvocationTargetException;
import javax.swing.Action;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.ColorModel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JSplitPane;

import com.smva.ejb.SMVASession;
import com.smva.jb.LoginCheckBean;//import com.avms.jb.loginCheck;////////////////////
import com.smva.jb.LoginPreferenceBean;//import com.avms.jb.loginPreferenceBean;//////////////////////
import java.util.Properties;
import javax.ejb.EJB;////////////////////////
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.SwingUtilities;
/**
 *
 * @author alfred.wong
 */
public class Main extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */

    static boolean ret_Config = false;
    static boolean ret_MF2 = false;
    static boolean logIn = true;
    static JMenuBar menubar = new JMenuBar();
    //static final AVMSWebServices port = null;
//    static AVMSWebServices port = null;
    private AlertQue alertQuePane;
    private QOS qosPane;
    private JSplitPane mainContainer;
    protected Action configAction;
//    static String loginID = System.getProperty("user.name");    // string should be named user name

//    @EJB/////////////////////////////
//    private static SMVASession rif;//////////////////////////// won't work on standalone
//    use getRifByIC to get rif instead
    public static SMVASession rif;


    public Main() {
        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            //properties.put("java.naming.provider.url", "jnp://localhost:1099");
            properties.put("java.naming.provider.url", "localhost:1099");
            Context ctx = new InitialContext(properties);
            System.out.println("Got context");
            rif = (SMVASession) ctx.lookup("smva/SMVASessionEJB/remote");
            //The jndi lookup string above is: "HelloWorld/HelloWorldBean/remote".
            //It consists of three parts:   target project(ear)name/ the bean name/ either remote or local indicator
            //Test is the name of application/project which contains the implementation of TestEJBBean.
            //TestEJBBean is the name of your EJB bean class which has the getMessage method.
            //remote indicates that you are looking a remote session bean.
            System.out.println(rif.getUserIDByNTLogin("alfred.wong"));

        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
        initComponents();
        initMenuBarComponents();
    }


    private void initComponents() {
        mainContainer = new JSplitPane();
        alertQuePane = new AlertQue();
        qosPane = new QOS();
        mainContainer.setDividerLocation(650);
        mainContainer.setDividerSize(2);
        mainContainer.setResizeWeight(0.5);
        mainContainer.setLeftComponent(alertQuePane);
        mainContainer.setRightComponent(qosPane);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainContainer, GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainContainer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE));
    }

    private void initMenuBarComponents() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        file.add(new JSeparator());
        JMenu edit = new JMenu("Edit");
        edit.setMnemonic(KeyEvent.VK_E);
        edit.add(new JSeparator());
        JMenu tools = new JMenu("Tools");
        tools.setMnemonic(KeyEvent.VK_T);
        tools.add(new JSeparator());

        JMenuItem file_new = new JMenuItem("New");
        file_new.addActionListener(this);
        JMenuItem file_open = new JMenuItem("Open");
        file_open.addActionListener(this);
        JMenuItem file_save = new JMenuItem("Save");
        file_save.addActionListener(this);
        JMenuItem file_close = new JMenuItem("Close");
        file_close.addActionListener(this);
        file_close.add(new JSeparator());
        JMenuItem edit_cut = new JMenuItem("Cut");
        edit_cut.addActionListener(this);
        JMenuItem edit_copy = new JMenuItem("Copy");
        edit_copy.addActionListener(this);
        edit_copy.add(new JSeparator());
        JMenuItem edit_paste = new JMenuItem("Paste");
        edit_paste.addActionListener(this);
        JMenuItem edit_insert = new JMenuItem("Insert");
        edit_insert.addActionListener(this);
        JMenuItem tools_config = new JMenuItem("Config");
        tools_config.addActionListener(this);
        file.add(file_new);
        file.add(file_open);
        file.add(file_save);
        file.add(file_close);
        edit.add(edit_cut);
        edit.add(edit_copy);
        edit.add(edit_paste);
        edit.add(edit_insert);
        tools.add(tools_config);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(tools);
    }

    private static void createAndShowGUI() {
        //LoginCheck();
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 11));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 11));
        Main mf1 = new Main();
        mf1.setTitle("Alert Que and QOS");
        mf1.setJMenuBar(menubar);
        mf1.pack();
        mf1.setLocationRelativeTo(null);
        mf1.setVisible(true);
        mf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        Rectangle bounds = null;
        for (GraphicsDevice curGs : gs) {
            GraphicsConfiguration[] gc = curGs.getConfigurations();
            for (GraphicsConfiguration curGc : gc) {
                bounds = curGc.getBounds();
                ColorModel cm = curGc.getColorModel();
                System.out.println(bounds.getX() + ", " + bounds.getY() + ", " + bounds.getWidth() + " x " + bounds.getHeight() + ", " + cm);
            }
        }
        mf1.setBounds(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
    }

    @SuppressWarnings("static-access")
    public void actionPerformed(ActionEvent event) {
        String strMenuName;
        strMenuName = event.getActionCommand();
        System.out.println("event name " + strMenuName);
        if (strMenuName.equals("Close")) {
            System.exit(0);
        } else if (strMenuName.equals("Config")) {
//            Config configPage = new Config();
            if (ret_Config == false) {
//                configPage.createAndShowGUI();
                ret_Config = true;
            }
        } else {
            //jTextField3.setText(strMenuName + " choosen.");
            System.out.println("choosen");
        }
    }

    private static void LoginCheck() {
/*
        AVMSWebServicesService service = new AVMSWebServicesService();
        //final AVMSWebServices port = service.getAVMSWebServicesPort();
        port = service.getAVMSWebServicesPort();
        LoginCheck loginCheck = port.loginPreferenceCheck(loginID);
        String login = loginCheck.getLogin();
*/
        LoginCheckBean loginCheckBean = new LoginCheckBean();
        //String strWindowsUserName = System.getProperty("user.name");
        String strWindowsUserName = "alfred.wong";
        loginCheckBean = rif.getLoginCheck(strWindowsUserName);//loginID///alfred.wong///////// string user.name is passed in as argument
        String login = loginCheckBean.getLogin();  // 'login' = 'valid' flag

//        System.out.println("loginID - " + loginID);
        System.out.println("loginID - " + strWindowsUserName);
        /*LoginPreferenceBean loginPreferenceBean = loginCheck.getLoginPreference();*/

        LoginPreferenceBean loginPreferenceB = loginCheckBean.getLogin_preference();///////////

        System.out.println("login check - " + login);
        if (login.equals("valid") && !login.equals("")) {
            logIn = true;
            /*System.out.println("log checked valid - " + loginPreferenceBean.getUserId());*/
            System.out.println("log checked valid - " + loginPreferenceB.getUser_id());/////
        } else {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Invalid Login", "Invalid Login", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
//    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeLater(new Runnable() {
//        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
