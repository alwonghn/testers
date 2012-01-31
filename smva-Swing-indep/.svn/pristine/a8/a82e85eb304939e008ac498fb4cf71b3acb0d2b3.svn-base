/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smva.ui;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author alfred.wong
 */
public class ServiceTab extends JPanel {

    private JSplitPane mainContainer;
    private Headway headwayPane;
    private RunQue runQuePane;

    public ServiceTab(String Svc) {
        initComponents(Svc);
        add(mainContainer);
    }

    private void initComponents(String Svc) {
        headwayPane = new Headway(Integer.valueOf(Svc));
        runQuePane = new RunQue(Svc);
        mainContainer = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        mainContainer.setContinuousLayout(true);
        mainContainer.setDividerSize(2);
        mainContainer.setDividerLocation(580);
//        mainContainer.setResizeWeight(0.5);
        mainContainer.setTopComponent(headwayPane);
        mainContainer.setBottomComponent(runQuePane);
    }
}
