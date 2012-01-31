/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smva.ui;
import smva.ui.QOS.DataAdt;
import smva.ui.QOS.SvcAdt;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;
/**
 *
 * @author alfred.wong
 */
public class ServiceQOSPane extends JComponent implements MouseListener {

    private String svcNo;

    public ServiceQOSPane(SvcAdt paneData){
        initComponents(paneData);
        this.addMouseListener(this);
    }

    private void initComponents(SvcAdt paneData){

        paneData.calculateSvcNoAlLvl();
        DataAdt svcNoAdt = paneData.getSvcNo();
        svcNo = svcNoAdt.getDataStr();
        Color svcNoAlLvl = svcNoAdt.getAlertLvl();
        JLabel lbl_svcNo = new JLabel();
        lbl_svcNo.setText("<html><h4><u>Service                   "+svcNo+"</u></h4></html>");

        int deployed = paneData.getDeployed();
        JLabel lbl_deployed = new JLabel();
        lbl_deployed.setText("<html><p>"+"deployed                           :  "+deployed+"</p></html>");

        double svcTrip = paneData.getSvcTrip();
        JLabel lbl_trip = new JLabel();
        lbl_trip.setText("<html><p>"+"Trip                                    : "+svcTrip+" %"+"</p></html>");
        lbl_trip.setForeground(Color.BLACK);

        DataAdt svcHw5nAdt = paneData.getSvcHw5n();
        int svcHw5nDataInt = svcHw5nAdt.getDataInt();
        Color svcHw5nAlt = svcHw5nAdt.getAlertLvl();
        JLabel lbl_svcHw5n = new JLabel();
        if(svcHw5nDataInt>0){
            lbl_svcHw5n.setText("<html><p>"+"Headway -5                    : <font color=\'RED\'>"+svcHw5nDataInt+"</font></p></html>");
        }else{
            lbl_svcHw5n.setText("<html><p>"+"Headway -5                    : "+svcHw5nDataInt+"</p></html>");
            lbl_svcHw5n.setForeground(Color.BLACK);
        }

        DataAdt svcHw5pAdt = paneData.getSvcHw5p();
        int svcHw5pDataInt = svcHw5pAdt.getDataInt();
        Color svcHw5pAlt = svcHw5pAdt.getAlertLvl();
        JLabel lbl_svcHw5p = new JLabel();
        if(svcHw5pDataInt>0){
            lbl_svcHw5p.setText("<html><p>"+"Headway +5                  : <font color=\'RED\'>"+svcHw5pDataInt+"</font></p></html>");
        }else{
            lbl_svcHw5p.setText("<html><p>"+"Headway +5                  : "+svcHw5pDataInt+"</p></html>");
            lbl_svcHw5p.setForeground(Color.BLACK);
        }

        DataAdt svcHw4nAdt = paneData.getSvcHw4n();
        int svcHw4nDataInt = svcHw4nAdt.getDataInt();
        Color svcHw4nAlt = svcHw4nAdt.getAlertLvl();
        JLabel lbl_svcHw4n = new JLabel();
        if(svcHw4nDataInt>0){
            lbl_svcHw4n.setText("<html><p>"+"Headway -4                   : <font color=\'ORANGE\'>"+svcHw4nDataInt+"</font></p></html>");
        }else{
            lbl_svcHw4n.setText("<html><p>"+"Headway -4                   : "+svcHw4nDataInt+"</p></html>");
            lbl_svcHw4n.setForeground(Color.BLACK);
        }

        DataAdt svcHw4pAdt = paneData.getSvcHw4p();
        int svcHw4pDataInt = svcHw4pAdt.getDataInt();
        Color svcHw4pAlt = svcHw4pAdt.getAlertLvl();
        JLabel lbl_svcHw4p = new JLabel();
        if(svcHw4pDataInt>0){
            lbl_svcHw4p.setText("<html><p>"+"Headway +4                  : <font color=\'ORANGE\'>"+svcHw4pDataInt+"</font></p></html>");
        }else{
            lbl_svcHw4p.setText("<html><p>"+"Headway +4                  : "+svcHw4pDataInt+"</p></html>");
            lbl_svcHw4p.setForeground(Color.BLACK);
        }

        DataAdt svcHw3nAdt = paneData.getSvcHw3n();
        int svcHw3nDataInt = svcHw3nAdt.getDataInt();
        Color svcHw3nAlt = svcHw3nAdt.getAlertLvl();
        JLabel lbl_svcHw3n = new JLabel();
        if(svcHw3nDataInt>0){
            lbl_svcHw3n.setText("<html><p>"+"Headway -3                   : <font color=\'YELLOW\'>"+svcHw3nDataInt+"</font></p></html>");
        }else{
            lbl_svcHw3n.setText("<html><p>"+"Headway -3                   : "+svcHw3nDataInt+"</p></html>");
            lbl_svcHw3n.setForeground(Color.BLACK);
        }

        DataAdt svcHw3pAdt = paneData.getSvcHw3p();
        int svcHw3pDataInt = svcHw3pAdt.getDataInt();
        Color svcHw3pAlt = svcHw3pAdt.getAlertLvl();
        JLabel lbl_svcHw3p = new JLabel();
        if(svcHw3pDataInt>0){
            lbl_svcHw3p.setText("<html><p>"+"Headway +3                  : <font color=\'YELLOW\'>"+svcHw3pDataInt+"</font></p></html>");
        }else{
            lbl_svcHw3p.setText("<html><p>"+"Headway +3                  : "+svcHw3pDataInt+"</p></html>");
            lbl_svcHw3p.setForeground(Color.BLACK);
        }

        DataAdt svcHw2nAdt = paneData.getSvcHw2n();
        int svcHw2nDataInt = svcHw2nAdt.getDataInt();
        Color svcHw2nAlt = svcHw2nAdt.getAlertLvl();
        JLabel lbl_svcHw2n = new JLabel();
        if(svcHw2nDataInt>0){
            lbl_svcHw2n.setText("<html><p>"+"Headway -2                   : <font color=\'GREEN\'>"+svcHw2nDataInt+"</font></p></html>");
        }else{
            lbl_svcHw2n.setText("<html><p>"+"Headway -2                   : "+svcHw2nDataInt+"</p></html>");
            lbl_svcHw2n.setForeground(Color.BLACK);
        }

        DataAdt svcHw2pAdt = paneData.getSvcHw2p();
        int svcHw2pDataInt = svcHw2pAdt.getDataInt();
        Color svcHw2pAlt = svcHw2pAdt.getAlertLvl();
        JLabel lbl_svcHw2p = new JLabel();
        if(svcHw2pDataInt>0){
            lbl_svcHw2p.setText("<html><p>"+"Headway +2                  : <font color=\'GREEN\'>"+svcHw2pDataInt+"</font></p></html>");
        }else{
            lbl_svcHw2p.setText("<html><p>"+"Headway +2                  : "+svcHw2pDataInt+"</p></html>");
            lbl_svcHw2p.setForeground(Color.BLACK);
        }

        DataAdt svcLoading90belowAdt = paneData.getSvcLoading90below();
        int svcLoading90below = svcLoading90belowAdt.getDataInt();
        Color svcLoading90belowAlt =  svcLoading90belowAdt.getAlertLvl();
        JLabel lbl_svcLoad90bel = new JLabel();
        if(svcLoading90below>0){
            lbl_svcLoad90bel.setText("<html><p>"+"Loading&lt;90%                  : <font color=\'RED\'>"+svcLoading90below+"</font></p></html>");
        }else{
            lbl_svcLoad90bel.setText("<html><p>"+"Loading&lt;90%                 : "+svcLoading90below+"</p></html>");
            lbl_svcLoad90bel.setForeground(Color.BLACK);
        }

        DataAdt svcLoading90Adt = paneData.getSvcLoading90();
        int svcLoading90 = svcLoading90Adt.getDataInt();
        Color svcLoading90Alt =  svcLoading90Adt.getAlertLvl();
        JLabel lbl_svcLoad90 = new JLabel();
        if(svcLoading90>0){
            lbl_svcLoad90.setText("<html><p>"+"Loading 90%                  : <font color=\'ORANGE\'>"+svcLoading90+"</font></p></html>");
        }else{
            lbl_svcLoad90.setText("<html><p>"+"Loading 90%                  : "+svcLoading90+"</p></html>");
            lbl_svcLoad90.setForeground(Color.BLACK);
        }

        DataAdt svcLoading93Adt = paneData.getSvcLoading93();
        int svcLoading93 = svcLoading93Adt.getDataInt();
        Color svcLoading93Alt =  svcLoading93Adt.getAlertLvl();
        JLabel lbl_svcLoad93 = new JLabel();
        if(svcLoading93>0){
            lbl_svcLoad93.setText("<html><p>"+"Loading 93%                  : <font color=\'YELLOW\'>"+svcLoading93+"</font></p></html>");
        }else{
            lbl_svcLoad93.setText("<html><p>"+"Loading 93%                  : "+svcLoading93+"</p></html>");
            lbl_svcLoad93.setForeground(Color.BLACK);
        }

        DataAdt svcLoading95Adt = paneData.getSvcLoading95();
        int svcLoading95 = svcLoading95Adt.getDataInt();
        Color svcLoading95Alt =  svcLoading95Adt.getAlertLvl();
        JLabel lbl_svcLoad95 = new JLabel();
        if(svcLoading95>0){
            lbl_svcLoad95.setText("<html><p>"+"Loading 95%                  : <font color=\'GREEN\'>"+svcLoading95+"</font></p></html>");
        }else{
            lbl_svcLoad95.setText("<html><p>"+"Loading 95%                  : "+svcLoading95+"</p></html>");
            lbl_svcLoad95.setForeground(Color.BLACK);
        }
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Border bor_alert = BorderFactory.createLineBorder(svcNoAlLvl,2);
        Border bor_etched = BorderFactory.createEtchedBorder(0);
        Border bor_empty = BorderFactory.createEmptyBorder(3,50,1,20);
        Border bor_compound1 = BorderFactory.createCompoundBorder(bor_etched, bor_alert);
        Border bor_compound2 = BorderFactory.createCompoundBorder(bor_compound1, bor_empty);
        setBorder(bor_compound2);
        setOpaque(true);  

        add(lbl_svcNo);
        add(lbl_deployed);
        add(lbl_trip);
        add(lbl_svcHw5n);
        add(lbl_svcHw5p);
        add(lbl_svcHw4n);
        add(lbl_svcHw4p);
        add(lbl_svcHw3n);
        add(lbl_svcHw3p);
        add(lbl_svcHw2n);
        add(lbl_svcHw2p);
        add(lbl_svcLoad90bel);
        add(lbl_svcLoad90);
        add(lbl_svcLoad93);
        add(lbl_svcLoad95);
    }
    public void mousePressed(MouseEvent evt) {
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

    @SuppressWarnings("static-access")
    public void mouseClicked(MouseEvent evt) {
        int clickCount = evt.getClickCount();
        if(clickCount==1){
            if (Main.ret_MF2 == false) {
                MainFrame2 headwayFrame = new MainFrame2(svcNo);
                headwayFrame.createAndShowGUI();
//                Main.ret_MF2 = true;
            }
            System.out.println("clickCount = " + clickCount );
        }else if (clickCount==2){
            // TODO opens GIS window
            System.out.println("clickCount = " + clickCount );
        }else{

        }
    }
}
