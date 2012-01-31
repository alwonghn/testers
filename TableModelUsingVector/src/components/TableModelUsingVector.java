/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package components;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfred.wong
 */
public class TableModelUsingVector extends JFrame{

    private void makeGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Vector with data.
        Vector<String> v = new Vector<String>();
        v.add("first");
        v.add("second");

        // Create a DefaultTableModel, which will be used as the
        // model for the JTable.
        DefaultTableModel model = new DefaultTableModel();

        // Add a column of data from Vector into the model.
        model.addColumn("data", v);

        // Make a JTable, using the DefaultTableModel we just made
        // as its model.
        JTable table = new JTable(model);

        this.getContentPane().add(table);
        this.setSize(200,200);
        this.setLocation(200,200);
        this.validate();
        this.setVisible(true);
    } // end of make gui

    public static void main(String[] args)
    {
        new TableModelUsingVector().makeGUI();
    }
}
