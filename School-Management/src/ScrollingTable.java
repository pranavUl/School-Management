import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;


//METHODS TO ADD: editRow(int row, Object[] new), updateTable(ArrayList<Object> arraylist, String[] columnNames)



public class ScrollingTable extends JTable {
    private JTable table;
    private JScrollPane sp;
    private Object[][] data;
    private String[] columnNames;
    public ScrollingTable(ArrayList<Object> arraylist, String[] cN, boolean[] editing, String type) {
        columnNames = cN;
        data = new Object[arraylist.size()][columnNames.length];
        Object[] row;
        for (int i = 0;i < arraylist.size(); i++) {
            row = new Object[columnNames.length];
            //{(Integer)(teachers.get(i).getID()), teachers.get(i).getFirstName(), teachers.get(i).getLastName(), teachers.get(i).getSections()}

            if (Objects.equals(type, "Teacher")) {
                row[0] = ((Teacher) arraylist.get(i)).getId();
                row[1] = ((Teacher) arraylist.get(i)).getFirstName();
                row[2] = ((Teacher) arraylist.get(i)).getLastName();
                row[3] = ((Teacher) arraylist.get(i)).getSections();
            }

            else if (Objects.equals(type, "Student")) {
                row[0] = ((Student) arraylist.get(i)).getId();
            }

            else if (Objects.equals(type, "Section")) {
                row[0] = ((Section) arraylist.get(i)).getId();
            }
            else if (Objects.equals(type, "Course")) {
                row[0] = ((Course) arraylist.get(i)).getId();
            }

            data[i] = row;

        }


        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return editing[columnIndex];
            }
        };

        for (String col : columnNames) {
            model.addColumn(col);
        }
        for (Object[] r : data) {
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

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
}
