package smva.ui;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package avms;
//import com.webservices.AVMSWebServices;
//import com.webservices.AVMSWebServicesService;
//import com.webservices.LoginCheck;
//import com.webservices.LoginPreferenceBean;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.Point;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//import javax.swing.AbstractButton;
//import javax.swing.BorderFactory;
//import javax.swing.BoxLayout;
//import javax.swing.DefaultListModel;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.ListSelectionModel;
//import javax.swing.UIManager;
//import javax.swing.border.Border;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
///**
// *
// * @author alfred.wong
// */
//public class Config extends JFrame implements ListSelectionListener {
//
//    private ArrayList<String> alGrp;
//    private ArrayList<String> alSvc;
//    LoginPreferenceBean beanLoginPreference;
//    private static JPanel mainContainer;
//
//    private JPanel paneGrpConfig;
//    private JButton btnAddGrp;
//    private static final String strAddGrp = ">";
//    private JButton btnAddGrpAll;
//    private static final String strAddGrpAll = ">>>";
//    private JButton btnRemoveGrp;
//    private static final String strRemoveGrp = "<";
//    private JButton btnRemoveGrpAll;
//    private static final String strRemoveGrpAll = "<<<";
//    private JList listGrp;
//    private DefaultListModel modelListGrp;
//    private JList listGrpChosen;
//    private DefaultListModel modelListGrpChosen;
//
//    private JPanel paneSvcConfig;
//    private JList listSvc;
//    private DefaultListModel modelListSvc;
//    private JList listSvcChosen;
//    private DefaultListModel modelListSvcChosen;
//    private JButton btnAddSvc;
//    private static final String strAddSvc = ">";
//    private JButton btnAddSvcAll;
//    private static final String strAddSvcAll = ">>>";
//    private JButton btnRemoveSvc;
//    private static final String strRemoveSvc = "<";
//    private JButton btnRemoveSvcAll;
//    private static final String strRemoveSvcAll = "<<<";
//
//    private JPanel btnPane;
//    private JButton btnOK;
//
//    protected String currGrpAddChoice;
//    protected String currGrpRemoveChoice;
//    protected String currSvcAddChoice;
//    protected String currRemoveChoice;
//
//    public Config() {
////        AVMSWebServices wsport = MainFrame1.port;
////        LoginCheck loginCheck = wsport.loginPreferenceCheck();
//        beanLoginPreference = loginCheck.getLoginPreference();
//        System.out.println("login - " + loginCheck.getLogin() + " login preference config - " + beanLoginPreference.getGroupId());
//        initGrpConfigComponents();
//        initSvcConfigComponents();
//        initComponents();
//        mainContainer = new JPanel();
//        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));
//        mainContainer.add(paneGrpConfig);
//        mainContainer.add(paneSvcConfig);
//        mainContainer.add(btnOK);
//    }
//
//    private void initGrpConfigComponents(){
//        modelListGrp = new DefaultListModel();
//        modelListGrpChosen = new DefaultListModel();
//        alGrp = new ArrayList<String>();
//        String strGrpId = beanLoginPreference.getGroupId();
//        StringTokenizer st = new StringTokenizer(strGrpId,",");
//        while (st.hasMoreTokens()){
//            String strGrp = (String)(st.nextToken());
//            strGrp = strGrp.trim();
//            alGrp.add(strGrp);
//        }
//        for(String g: alGrp){
//            modelListGrp.addElement(g);
//        }
//
//        listGrp = new JList(modelListGrp);
//        listGrp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        listGrp.setSelectedIndex(0);
//        listGrp.addListSelectionListener(this);
//        //grpList.setVisibleRowCount(20);
//        JScrollPane grpListScrollPane = new JScrollPane(listGrp);
//
//        listGrpChosen = new JList(modelListGrpChosen);
//        listGrpChosen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        listGrpChosen.setSelectedIndex(0);
//        listGrpChosen.addListSelectionListener(this);
//        //grpChosenList.setVisibleRowCount(20);
//        JScrollPane grpChosenScrollPane = new JScrollPane(listGrpChosen);
//
//        btnAddGrp = new JButton(strAddGrp);
//        //btnAddGrp.setEnabled(false); //
//        btnAddGrp.setHorizontalTextPosition(AbstractButton.CENTER);
//        btnAddGrp.setMaximumSize(new Dimension(200,100));
//        btnAddGrp.setAlignmentX(Component.CENTER_ALIGNMENT);
//        btnAddGrp.setActionCommand(strAddGrp);
//
//        AddGrpBtnListener addGrpBtnListener = new AddGrpBtnListener(btnAddGrp);
//        btnAddGrp.addActionListener(addGrpBtnListener);
//
//        // add all button
//        btnAddGrpAll = new JButton(strAddGrpAll);
//        //btnAddGrpAll.setEnabled(false); //
//        btnAddGrpAll.setHorizontalTextPosition(AbstractButton.CENTER);
//        btnAddGrpAll.setMaximumSize(new Dimension(200,100));
//        btnAddGrpAll.setAlignmentX(Component.CENTER_ALIGNMENT);
//        btnAddGrpAll.setActionCommand(strAddGrpAll);
//
///*
//        AddSvcBtnListener addBtnListener = new AddSvcBtnListener(btnAdd);
//        btnAdd.addActionListener(addBtnListener);
//*/
//
//        // remove button
//        btnRemoveGrp = new JButton(strRemoveGrp);
//        btnRemoveGrp.setHorizontalTextPosition(AbstractButton.CENTER);
//        btnRemoveGrp.setMaximumSize(new Dimension(200,100));
//        btnRemoveGrp.setAlignmentX(Component.CENTER_ALIGNMENT);
//        btnRemoveGrp.setActionCommand(strRemoveGrp);
///*
//        RemoveSvcBtnListener removeBtnListener = new RemoveSvcBtnListener();
//        btnRemove.addActionListener(removeBtnListener);
// */
//
//        // remove all button
//        btnRemoveGrpAll = new JButton(strRemoveGrpAll);
//        btnRemoveGrpAll.setHorizontalTextPosition(AbstractButton.CENTER);
//        btnRemoveGrpAll.setMaximumSize(new Dimension(200,100));
//        btnRemoveGrpAll.setAlignmentX(Component.CENTER_ALIGNMENT);
//        btnRemoveGrpAll.setActionCommand(strRemoveGrpAll);
///*
//        RemoveSvcBtnListener removeBtnListener = new RemoveSvcBtnListener();
//        btnRemove.addActionListener(removeBtnListener);
// */
//
//
////        newAddChoice = choicesListModel.getElementAt(choicesList.getSelectedIndex()).toString();
////
////        newRemoveChoice = chosenListModel.getElementAt(chosenList.getSelectedIndex()).toString();
//
//        //Create a panel that using BoxLayout top2bott to contain choicesList.
//        JPanel grpListPane = new JPanel();
//        grpListPane.setLayout(new BoxLayout(grpListPane,BoxLayout.PAGE_AXIS));
//        grpListPane.add(grpListScrollPane);
//        grpListPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//
//        //Create a panel that uses BorderLayout to contain Add and Remove buttons
//        JPanel grpButtonsPane = new JPanel();
//        grpButtonsPane.setLayout(new BoxLayout(grpButtonsPane,BoxLayout.PAGE_AXIS));
////        buttonPane.add(Box.createHorizontalStrut(5));
////        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
////        buttonPane.add(Box.createHorizontalStrut(5));
//        grpButtonsPane.add(btnAddGrp);
//        grpButtonsPane.add(btnAddGrpAll);
//        grpButtonsPane.add(btnRemoveGrp);
//        grpButtonsPane.add(btnRemoveGrpAll);
//        grpButtonsPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//
//
//        //Create a panel that uses BoxLayout top2bott to contain chosenList
//        JPanel grpChosenPane = new JPanel();
//        grpChosenPane.setLayout(new BoxLayout(grpChosenPane,BoxLayout.PAGE_AXIS));
//        grpChosenPane.add(grpChosenScrollPane);
//        grpChosenPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//
//        //Create a panel that uses BoxLayout to contain the above 3 panels
//        paneGrpConfig = new JPanel();
//        paneGrpConfig.setLayout(new BoxLayout(paneGrpConfig,BoxLayout.LINE_AXIS));
//        paneGrpConfig.add(grpListPane);
//        paneGrpConfig.add(grpButtonsPane);
//        paneGrpConfig.add(grpChosenPane);
//        Border grpTitleBdr = BorderFactory.createTitledBorder("Group Config");
//        Border grpEmptyBdr = BorderFactory.createEmptyBorder(5, 5, 5, 5);
//        Border grpCompoundBdr = BorderFactory.createCompoundBorder(grpTitleBdr, grpEmptyBdr);
//        paneGrpConfig.setBorder(grpCompoundBdr);
//
//    }
//
//    private void initSvcConfigComponents(){
//        modelListSvc = new DefaultListModel();
//        modelListSvcChosen = new DefaultListModel();
//        alSvc = new ArrayList<String>();
//        String strSvcId = beanLoginPreference.getRouteId();
//        StringTokenizer st = new StringTokenizer(strSvcId,",");
//        while (st.hasMoreTokens()){
//            String strSvc = (String)(st.nextToken());
//            strSvc = strSvc.trim();
//            alSvc.add(strSvc);
//        }
//        for(String s: alSvc){
//            modelListSvc.addElement(s);
//        }
//        listSvc = new JList(modelListSvc);
//        listSvc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        listSvc.setSelectedIndex(0);
//        listSvc.addListSelectionListener(this);
//        //svcList.setVisibleRowCount(5);
//        JScrollPane svcListScrollPane = new JScrollPane(listSvc);
//        listSvcChosen = new JList(modelListSvcChosen);
//        listSvcChosen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        listSvcChosen.setSelectedIndex(0);
//        listSvcChosen.addListSelectionListener(this);
//        //svcChosenList.setVisibleRowCount(5);
//        JScrollPane svcChosenScrollPane = new JScrollPane(listSvcChosen);
//
//        // Create the buttons
//        // add button
//        btnAddSvc = new JButton(strAddSvc);
//        //btnAddSvc.setEnabled(false); //
//        btnAddSvc.setHorizontalTextPosition(AbstractButton.CENTER);
//        btnAddSvc.setMaximumSize(new Dimension(200,100));
//        btnAddSvc.setAlignmentX(Component.CENTER_ALIGNMENT);
//        btnAddSvc.setActionCommand(strAddSvc);
///*
//        AddSvcBtnListener addBtnListener = new AddSvcBtnListener(btnAdd);
//        btnAdd.addActionListener(addBtnListener);
//*/
//        // add all button
//        btnAddSvcAll = new JButton(strAddSvcAll);
//        //btnAddSvcAll.setEnabled(false); //
//        btnAddSvcAll.setHorizontalTextPosition(AbstractButton.CENTER);
//        btnAddSvcAll.setMaximumSize(new Dimension(200,100));
//        btnAddSvcAll.setAlignmentX(Component.CENTER_ALIGNMENT);
//        btnAddSvcAll.setActionCommand(strAddSvcAll);
//
///*
//        AddSvcBtnListener addBtnListener = new AddSvcBtnListener(btnAdd);
//        btnAdd.addActionListener(addBtnListener);
//*/
//
//
//        // remove button
//        btnRemoveSvc = new JButton(strRemoveSvc);
//        btnRemoveSvc.setHorizontalTextPosition(AbstractButton.CENTER);
//        btnRemoveSvc.setMaximumSize(new Dimension(200,100));
//        btnRemoveSvc.setAlignmentX(Component.CENTER_ALIGNMENT);
//        btnRemoveSvc.setActionCommand(strRemoveSvc);
///*
//        RemoveSvcBtnListener removeBtnListener = new RemoveSvcBtnListener();
//        btnRemove.addActionListener(removeBtnListener);
// */
//
//        // remove all button
//        btnRemoveSvcAll = new JButton(strRemoveSvcAll);
//        btnRemoveSvcAll.setHorizontalTextPosition(AbstractButton.CENTER);
//        btnRemoveSvcAll.setMaximumSize(new Dimension(200,100));
//        btnRemoveSvcAll.setAlignmentX(Component.CENTER_ALIGNMENT);
//        btnRemoveSvcAll.setActionCommand(strRemoveSvcAll);
///*
//        RemoveSvcBtnListener removeBtnListener = new RemoveSvcBtnListener();
//        btnRemove.addActionListener(removeBtnListener);
// */
//
////        newAddChoice = choicesListModel.getElementAt(choicesList.getSelectedIndex()).toString();
////
////        newRemoveChoice = chosenListModel.getElementAt(chosenList.getSelectedIndex()).toString();
//
//
//        //Create a panel that using BoxLayout top2bott to contain choicesList.
//        JPanel svcListPane = new JPanel();
//        svcListPane.setLayout(new BoxLayout(svcListPane,BoxLayout.PAGE_AXIS));
//        svcListPane.add(svcListScrollPane);
//        svcListPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//
//
//        //Create a panel that uses BorderLayout to contain Add and Remove buttons
//        JPanel svcButtonsPane = new JPanel();
//        svcButtonsPane.setLayout(new BoxLayout(svcButtonsPane,BoxLayout.PAGE_AXIS));
//        svcButtonsPane.add(btnAddSvc);
////        buttonPane.add(Box.createHorizontalStrut(5));
////        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
////        buttonPane.add(Box.createHorizontalStrut(5));
//        svcButtonsPane.add(btnAddSvc);
//        svcButtonsPane.add(btnAddSvcAll);
//        svcButtonsPane.add(btnRemoveSvc);
//        svcButtonsPane.add(btnRemoveSvcAll);
//        svcButtonsPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//
//
//        //Create a panel that uses BoxLayout top2bott to contain chosenList
//        JPanel svcChosenPane = new JPanel();
//        svcChosenPane.setLayout(new BoxLayout(svcChosenPane,BoxLayout.PAGE_AXIS));
//        svcChosenPane.add(svcChosenScrollPane);
//        svcChosenPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//
//
//        //Create a panel that uses BoxLayout to contain the above 3 panels
//        paneSvcConfig = new JPanel();
//        paneSvcConfig.setLayout(new BoxLayout(paneSvcConfig,BoxLayout.LINE_AXIS));
//        paneSvcConfig.add(svcListPane);
//        paneSvcConfig.add(svcButtonsPane);
//        paneSvcConfig.add(svcChosenPane);
//        Border svcBorder = BorderFactory.createTitledBorder("Route Config");
//        Border svcEmptyBdr = BorderFactory.createEmptyBorder(5, 5, 5, 5);
//        Border svcCompoundBdr = BorderFactory.createCompoundBorder(svcBorder, svcEmptyBdr);
//        paneSvcConfig.setBorder(svcCompoundBdr);
//
////port.updateLoginPreference(loginPreferenceBean.getUserId(), "8,9", "157");
////Border ridBorder = BorderFactory.createTitledBorder("Area Groups");
//
//    }
//
//    private void initComponents() {
//        btnOK = new JButton("Save");
//        btnPane = new JPanel();
//        FlowLayout btnPaneLayout = new FlowLayout();
//        btnPane.setLayout(btnPaneLayout);
//        btnPaneLayout.setAlignment(FlowLayout.TRAILING);
//        btnPane.add(btnOK);
//    }
//
//    //This listener is shared by the text field and the hire button.
//    class AddGrpBtnListener implements ActionListener, DocumentListener {
//        private boolean alreadyEnabled = false;
//        private JButton button;
//
//        public AddGrpBtnListener(JButton button) {
//            this.button = button;
//        }
//
//        //Required by ActionListener.
//        public void actionPerformed(ActionEvent e) {
//            String name = currGrpAddChoice;
//
////            //User didn't type in a unique name...
////            if (name.equals("") || alreadyInList(name)) {
////                Toolkit.getDefaultToolkit().beep();
//////                employeeName.requestFocusInWindow();
//////                employeeName.selectAll();
////                return;
////            }
//
//            int idxSelListGrp = listGrp.getSelectedIndex();
//            modelListGrp.remove(idxSelListGrp);
//
//
//            int index = listGrpChosen.getSelectedIndex(); //get selected index
//            if (index == -1) { //no selection, so insert at beginning
//                index = 0;
//            } else {           //add after the selected item
//                index++;
//            }
//
//            //listModel.insertElementAt(employeeName.getText(), index);
//            //If we just wanted to add to the end, we'd do this:
//            modelListGrpChosen.addElement(name);
//
////            //Reset the text field.
////            employeeName.requestFocusInWindow();
////            employeeName.setText("");
//
//            //Select the new item and make it visible.
//            listSvcChosen.setSelectedIndex(index);
//            listSvcChosen.ensureIndexIsVisible(index);
//        }
//
//        //This method tests for string equality. You could certainly
//        //get more sophisticated about the algorithm.  For example,
//        //you might want to ignore white space and capitalization.
//        protected boolean alreadyInList(String name) {
//            return modelListSvcChosen.contains(name);
//        }
//
//        //Required by DocumentListener.
//        public void insertUpdate(DocumentEvent e) {
//            enableButton();
//        }
//
//        //Required by DocumentListener.
//        public void removeUpdate(DocumentEvent e) {
//            handleEmptyTextField(e);
//        }
//
//        //Required by DocumentListener.
//        public void changedUpdate(DocumentEvent e) {
//            if (!handleEmptyTextField(e)) {
//                enableButton();
//            }
//        }
//
//        private void enableButton() {
//            if (!alreadyEnabled) {
//                button.setEnabled(true);
//            }
//        }
//
//        private boolean handleEmptyTextField(DocumentEvent e) {
//            if (e.getDocument().getLength() <= 0) {
//                button.setEnabled(false);
//                alreadyEnabled = false;
//                return true;
//            }
//            return false;
//        }
//    }
//
//
//    //This listener is shared by the text field and the hire button.
//    class AddSvcBtnListener implements ActionListener, DocumentListener {
//        private boolean alreadyEnabled = false;
//        private JButton button;
//
//        public AddSvcBtnListener(JButton button) {
//            this.button = button;
//        }
//
//        //Required by ActionListener.
//        public void actionPerformed(ActionEvent e) {
//            String name = currSvcAddChoice;
//
//            //User didn't type in a unique name...
//            if (name.equals("") || alreadyInList(name)) {
//                Toolkit.getDefaultToolkit().beep();
////                employeeName.requestFocusInWindow();
////                employeeName.selectAll();
//                return;
//            }
//
//            int index = listSvcChosen.getSelectedIndex(); //get selected index
//            if (index == -1) { //no selection, so insert at beginning
//                index = 0;
//            } else {           //add after the selected item
//                index++;
//            }
//
//            //listModel.insertElementAt(employeeName.getText(), index);
//            //If we just wanted to add to the end, we'd do this:
//            modelListSvcChosen.addElement(name);
//
////            //Reset the text field.
////            employeeName.requestFocusInWindow();
////            employeeName.setText("");
//
//            //Select the new item and make it visible.
//            listSvcChosen.setSelectedIndex(index);
//            listSvcChosen.ensureIndexIsVisible(index);
//        }
//
//        //This method tests for string equality. You could certainly
//        //get more sophisticated about the algorithm.  For example,
//        //you might want to ignore white space and capitalization.
//        protected boolean alreadyInList(String name) {
//            return modelListSvcChosen.contains(name);
//        }
//
//        //Required by DocumentListener.
//        public void insertUpdate(DocumentEvent e) {
//            enableButton();
//        }
//
//        //Required by DocumentListener.
//        public void removeUpdate(DocumentEvent e) {
//            handleEmptyTextField(e);
//        }
//
//        //Required by DocumentListener.
//        public void changedUpdate(DocumentEvent e) {
//            if (!handleEmptyTextField(e)) {
//                enableButton();
//            }
//        }
//
//        private void enableButton() {
//            if (!alreadyEnabled) {
//                button.setEnabled(true);
//            }
//        }
//
//        private boolean handleEmptyTextField(DocumentEvent e) {
//            if (e.getDocument().getLength() <= 0) {
//                button.setEnabled(false);
//                alreadyEnabled = false;
//                return true;
//            }
//            return false;
//        }
//    }
//
//    class RemoveSvcBtnListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            //This method can be called only if
//            //there's a valid selection
//            //so go ahead and remove whatever's selected.
//            int index = listSvcChosen.getSelectedIndex();
//            modelListSvcChosen.remove(index);
//
//            int size = modelListSvcChosen.getSize();
//
//            if (size == 0) { //Nobody's left, disable firing.
//                btnRemoveSvc.setEnabled(false);
//
//            } else { //Select an index.
//                if (index == modelListSvcChosen.getSize()) {
//                    //removed item in last position
//                    index--;
//                }
//
//                listSvcChosen.setSelectedIndex(index);
//                listSvcChosen.ensureIndexIsVisible(index);
//            }
//        }
//    }
//
//
//    //This method is required by ListSelectionListener.
//    public void valueChanged(ListSelectionEvent e) {
//        if (e.getValueIsAdjusting() == false) {
//
//            if (listSvc.getSelectedIndex() == -1) {
//            //No selection, disable fire button.
//                btnAddSvc.setEnabled(false);
//
//            } else {
//            //Selection, enable the fire button.
//                btnAddSvc.setEnabled(true);
//            }
//
//            if (listSvcChosen.getSelectedIndex() == -1) {
//            //No selection, disable fire button.
//                btnRemoveSvc.setEnabled(false);
//
//            } else {
//            //Selection, enable the fire button.
//                btnRemoveSvc.setEnabled(true);
//            }
//        }
//    }
//
//
//    static void createAndShowGUI(){
//        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 11));
//        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 11));
//        Config frame = new Config();
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        //newContentPane.setOpaque(true);
//        //frame.setContentPane(newContentPane);
//        frame.add(mainContainer);
//        frame.setLocation(new Point(600, 200));
//        frame.pack();
//        if(!MainFrame1.ret_Config){
//            frame.setVisible(true);
//        }
//    }
//
//    public void actionPerformed(ActionEvent event) {
//
//    }
//
//    public static void main(String args[]) {
//        javax.swing.SwingUtilities.invokeLater(new Runnable(){
//            public void run(){
//                createAndShowGUI();
//            }
//        });
//    }
//
//
//}
