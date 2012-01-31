/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package components;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfred.wong
 */
public class TableModelUsingHashMap extends JFrame {
    private void makeGUI()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // HashMap with some data.
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        // Create a DefaultTableModel, which will be used as the
        // model for the JTable.
        DefaultTableModel model = new DefaultTableModel();

        // Populate the model with data from HashMap.
        model.setColumnIdentifiers(new String[] {"key", "value"});

        for (String key : map.keySet())
                model.addRow(new Object[] {key, map.get(key)});

        // Make a JTable, using the DefaultTableModel we just made
        // as its model.
        JTable table = new JTable(model);

        this.getContentPane().add(table);
        this.setSize(200,200);
        this.setLocation(200,200);
        this.validate();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new TableModelUsingHashMap().makeGUI();
    }
}
