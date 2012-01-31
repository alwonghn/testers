/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package components;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfred.wong
 */
public class TableModelUsingArrayList extends JFrame{

    /**
     * @param args the command line arguments
     */
    private void makeGUI(){


        // ArrayList containing the data to display in the table.
        ArrayList<KeyValuePair> list = new ArrayList<KeyValuePair>();
        list.add(new KeyValuePair("Foo1", "Bar1"));
        list.add(new KeyValuePair("Foo2", "Bar2"));
        list.add(new KeyValuePair("Foo3", "Bar3"));

        // Instantiate JTable and DefaultTableModel, and set it as the
        // TableModel for the JTable.
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.setColumnIdentifiers(new String[] {"Key", "Value"});

        // Populate the JTable (TableModel) with data from ArrayList
        for (KeyValuePair p : list)
        {
            model.addRow(new String[] {p.key, p.value});
        }



    }


    public static void main(String[] args) {
        new TableModelUsingArrayList().makeGUI();
    }

}

