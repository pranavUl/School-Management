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
    private boolean[] editables;
    private String type;
    public ScrollingTable(ArrayList<Object> arraylist, String[] cN, boolean[] editing, String type) {
        this.type = type;
        this.columnNames = cN;
        this.data = new Object[arraylist.size()][columnNames.length];
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
                row[1] = ((Student) arraylist.get(i)).getFirstName();
                row[2] = ((Student) arraylist.get(i)).getLastName();
                row[3] = ((Student) arraylist.get(i)).getSchedule();
            }

            else if (Objects.equals(type, "Section")) {
                row[0] = ((Section) arraylist.get(i)).getId();
                row[1] = ((Section) arraylist.get(i)).getCourses();
                row[2] = ((Section) arraylist.get(i)).getTeachers();
            }
            else if (Objects.equals(type, "Course")) {
                row[0] = ((Course) arraylist.get(i)).getId();
                row[1] = ((Course) arraylist.get(i)).getName();
                row[2] = ((Course) arraylist.get(i)).getType();
            }
            else if (Objects.equals(type, "SectionsTaught")) { //for Teacher view
                row[0] = ((Section) arraylist.get(i)).getId();
                StringBuilder courses = new StringBuilder();
                if (((Section) arraylist.get(i)).getCourses() != null) {
                    for (int k = 0; k < ((Section) arraylist.get(i)).getCourses().size(); k++) {
                        courses.append(((Section) arraylist.get(i)).getCourses().get(k).getName()).append(" ");
                    }
                    row[1] = courses.toString();
                }
                else {
                    row[1] = "";
                }
            }
            else if (Objects.equals(type, "Roster")) { // for Section
                row[0] = ((Student) arraylist.get(i)).getId();
                row[1] = ((Student) arraylist.get(i)).getFirstName();
                row[2] = ((Student) arraylist.get(i)).getLastName();

                //NEED TO ADD ROSTER SORTER

            }

            data[i] = row;

        }

        this.editables = editing;

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

        this.table = new JTable(model);
        this.sp = new JScrollPane(table);
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

    public void updateScrollingTable(ArrayList<Object> newArrayList) {
        /*
        copypaste constructor
        make a new object[][] array based on newarraylist and fill in newarraylist values, then set this.data = newobject[][]array
         */
    }
}
