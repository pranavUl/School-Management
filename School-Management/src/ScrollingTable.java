import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ScrollingTable extends JTable {
    private JTable table;
    private JScrollPane sp;
    public ScrollingTable(ArrayList<Object> arraylist, String[] columnNames, boolean[] editing) {

        Object[][] array2 = new Object[arraylist.size()][columnNames.length];
        Object[] row;
        for (int i = 0;i < arraylist.size(); i++) {
            row = new Object[columnNames.length];
            //{(Integer)(teachers.get(i).getID()), teachers.get(i).getFirstName(), teachers.get(i).getLastName(), teachers.get(i).getSections()}


            for (int k = 0; k < columnNames.length; k++) {
                row[i] = 
                array2[i] = row;
            }

        }


        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return editing[columnIndex];
            }
        };

        for (String col : columnNames) {
            model.addColumn(col);
        }
        for (Object[] r : array2) {
            model.insertRow(model.getRowCount(), r);
        }

        table = new JTable(model);
        sp = new JScrollPane(table);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getSp() {
        return sp;
    }

    public void setSp(JScrollPane sp) {
        this.sp = sp;
    }
}
