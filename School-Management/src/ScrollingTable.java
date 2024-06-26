import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;

public class ScrollingTable extends JTable {
    
    private JTable table;
    private JScrollPane sp;
    private Object[][] data;
    private String[] columnNames;
    private boolean[] editables;
    private String type;
    
    @SuppressWarnings("removal")
    public ScrollingTable(ArrayList<Object> arraylist, String[] cN, boolean[] editing, String type) {
        this.type = type;
        this.columnNames = cN;
        this.data = new Object[arraylist.size()][columnNames.length];
        Object[] row;

        if (Objects.equals(type, "Roster")) {
            arraylist.sort((a, b) ->
                ((Student) b).getLastName().compareTo(((Student) a).getLastName())
            );
            arraylist.sort((a, b) ->
                ((Student) b).getFirstName().compareTo(((Student) a).getFirstName())
            );
            arraylist.sort((a, b) ->
                (new Integer(((Student) b).getId())).compareTo(new Integer(((Student) a).getId()))
            );
        }

        for (int i = 0;i < arraylist.size(); i++) {
            row = new Object[columnNames.length];

            if (Objects.equals(type, "Teacher")) {
                row[0] = ((Teacher) arraylist.get(i)).getId();
                row[1] = ((Teacher) arraylist.get(i)).getFirstName();
                row[2] = ((Teacher) arraylist.get(i)).getLastName();
            }

            else if (Objects.equals(type, "Sections Taught")) { //for Teacher view
                row[0] = ((Section) arraylist.get(i)).getId();
                row[1] = ((Section) arraylist.get(i)).getCourse();
            }

            else if (Objects.equals(type, "Student")) {
                row[0] = ((Student) arraylist.get(i)).getId();
                row[1] = ((Student) arraylist.get(i)).getFirstName();
                row[2] = ((Student) arraylist.get(i)).getLastName();
            }

            else if (Objects.equals(type, "Schedule")) {
                row[0] = ((Section) arraylist.get(i)).getId();
                row[1] = ((Section) arraylist.get(i)).getCourse();
                row[2] = ((Section) arraylist.get(i)).gettID();
                row[3] = ((Section) arraylist.get(i)).gettFirstName();
                row[4] = ((Section) arraylist.get(i)).gettLastName();
            }

            else if (Objects.equals(type, "Section")) {
                row[0] = ((Section) arraylist.get(i)).getId();
                row[1] = ((Section) arraylist.get(i)).getcID();
                row[2] = ((Section) arraylist.get(i)).getCourse();
                row[3] = ((Section) arraylist.get(i)).gettID();
                row[4] = ((Section) arraylist.get(i)).gettFirstName();
                row[5] = ((Section) arraylist.get(i)).gettLastName();
                System.out.println(((Section) arraylist.get(i)).getId() + " " + ((Section) arraylist.get(i)).getcID() + " " + ((Section) arraylist.get(i)).getCourse() + " " + ((Section) arraylist.get(i)).gettID() + " " + ((Section) arraylist.get(i)).gettFirstName() + " " + ((Section) arraylist.get(i)).gettLastName());
            }

            else if (Objects.equals(type, "Roster")) {
                
                row[0] = ((Student) arraylist.get(i)).getLastName();
                row[1] = ((Student) arraylist.get(i)).getFirstName();
                row[2] = ((Student) arraylist.get(i)).getId();

            }

            else if (Objects.equals(type, "Course")) {
                row[0] = ((Course) arraylist.get(i)).getId();
                row[1] = ((Course) arraylist.get(i)).getName();
                row[2] = ((Course) arraylist.get(i)).getType();
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

        /*table.getSelectionModel().addListSelectionListener(new ListSelectionListener() { //method copy and pasted from a stack overflow response
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selectedRow = table.convertRowIndexToModel(table.getSelectedRow());
                int selectedColumn = table.convertColumnIndexToModel(table.getSelectedColumn());
    
                Object selectedId = model.getValueAt(selectedRow, selectedColumn);

                System.out.println(selectedId);

                model.setValueAt(selectedId, selectedRow, selectedColumn);

                if (model.getColumnName(0).contains("Teacher")) {
                    try {
                        File file = new File("teachers.txt");
                        FileWriter fw = new FileWriter(file, false);
                        for (int i = 0; i < model.getRowCount(); i++) {
                            //fw.write(((Teacher) c).getId() + " " + ((Teacher) c).getFirstName() + " " + ((Teacher) c).getLastName() + " " + "\n");
                            fw.write(String.valueOf(model.getValueAt(i, 0)) + " " + model.getValueAt(i, 1) + " " + model.getValueAt(i, 2) + "\n");
                        }
                        fw.close();
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
                else if (model.getColumnName(0).contains("Section") && model.getColumnName(1).contains("Course ID")) {

                }
                else if (model.getColumnName(0).contains("Student")) {

                }
                else if (model.getColumnName(0).contains("Course")) {

                }

            }
        });*/
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
