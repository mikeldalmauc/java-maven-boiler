package com.example;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.example.model.Model;
import com.example.model.Package;

public class View implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.view((Model) evt.getSource());
    }

    /**
     * View
     */
    private JFrame jframe;
    private JTextField count;

    public View(Model model) {

        jframe = new JFrame("Counter");
        jframe.setSize(500, 520);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);

        // Configurar el layout
        jframe.setLayout(new BoxLayout(jframe.getContentPane(), BoxLayout.Y_AXIS));

        // Crear componentes
        count = new JTextField(1);
        count.setEditable(false);
        count.setText(model.getCount() + "");
        jframe.add("count", count);

        // Boton up
        JButton boton1 = new JButton("up");
        jframe.add("up", boton1);
        boton1.addActionListener(e -> Update.update(Msg.UP, model));

        // Boton down
        JButton boton2 = new JButton("down");
        jframe.add("down", boton2);
        boton2.addActionListener(e -> Update.update(Msg.DOWN, model));


        // Create and display the GUI
        ObjectTableModel tableModel = new ObjectTableModel(model.getPackages());
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        jframe.add(scrollPane, BorderLayout.CENTER);    }

    /**
     * View function
     * 
     * @param model
     */

    public void view(Model model) {
        count.setText(model.getCount() + "");
    }

    public JFrame getJframe() {
        return this.jframe;
    }

    class ObjectTableModel extends AbstractTableModel {
        private List<Package> objectList;
        private String[] columnNames = { "packageId", "destinationAddress", "weight", "length", "width", "height" };

        public ObjectTableModel(List<Package> objectList) {
            this.objectList = objectList;
        }

        @Override
        public int getRowCount() {
            return objectList.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Package object = objectList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return object.getPackageId();
                case 1:
                    return object.getDestinationAddress();
                case 2:
                    return object.getWeight();
                case 3:
                    return object.getLength();
                case 4:
                    return object.getWidth();
                case 5:
                    return object.getHeight();
                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }

}
