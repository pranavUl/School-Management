import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Frame {
    public static void main(String[] args) {

        JFrame frame = new JFrame("SCHOOL MANAGEMENT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000 ,1000);
        frame.setLayout(null);

        JPanel teacherPanel = new JPanel();
        teacherPanel.setSize(1000 ,1000);
        teacherPanel.setLayout(null);
        teacherPanel.setVisible(false);

        JPanel studentPanel = new JPanel();
        studentPanel.setSize(1000 ,1000);
        studentPanel.setLayout(null);
        teacherPanel.setVisible(false);

        JPanel coursePanel = new JPanel();
        coursePanel.setSize(1000 ,1000);
        coursePanel.setLayout(null);
        teacherPanel.setVisible(false);

        JPanel sectionPanel = new JPanel();
        sectionPanel.setSize(1000 ,1000);
        sectionPanel.setLayout(null);
        teacherPanel.setVisible(false);

        JPanel aboutPanel = new JPanel();
        sectionPanel.setSize(1000 ,1000);
        sectionPanel.setLayout(null);
        teacherPanel.setVisible(false);


        //menu setup
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        //file menu
        JMenuItem exportDataSelect = new JMenuItem("Export Data");
        fileMenu.add(exportDataSelect);
        JMenuItem importDataSelect = new JMenuItem("Import Data");
        fileMenu.add(importDataSelect);
        JMenuItem purgeSelect = new JMenuItem("Purge");
        fileMenu.add(purgeSelect);
        JMenuItem exitSelect = new JMenuItem("Exit");
        fileMenu.add(exitSelect);

        //view menu
        JMenuItem teacherViewSelect = new JMenuItem("Teacher");
        viewMenu.add(teacherViewSelect);
        JMenuItem studentViewSelect = new JMenuItem("Student");
        viewMenu.add(studentViewSelect);
        JMenuItem courseViewSelect = new JMenuItem("Course");
        viewMenu.add(courseViewSelect);
        JMenuItem sectionViewSelect = new JMenuItem("Section");
        viewMenu.add(sectionViewSelect);

        //help menu
        JMenuItem aboutSelect = new JMenuItem("About");
        helpMenu.add(aboutSelect);


        //JLabel titleScreen = new JLabel("welcome to school");
        //titleScreen.setBounds(400, 475, 200, 50);
        //frame.getContentPane().add(titleScreen);

        teacherViewSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                studentPanel.setVisible(false);
                sectionPanel.setVisible(false);
                coursePanel.setVisible(false);
                aboutPanel.setVisible(false);
                teacherPanel.setVisible(true);

                //get all teachers into an arraylist from db later
                ArrayList<Object> teachers = new ArrayList<Object>();
                teachers.add(new Teacher(125, "h", "s", null));
                teachers.add(new Teacher(1251435, "ja", "ahe", null));
                teachers.add(new Teacher(1263565, "wt", "rd", null));
                teachers.add(new Teacher(165525, "pir", "go", null));


                //teacher table display
                String[] columnNamesT = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};
                JScrollPane teacherTable = (new ScrollingTable(teachers, columnNamesT, new boolean[]{false, true, true, false}, "Teacher")).getSp();
                teacherTable.setBounds(50, 50, 500, 800);
                teacherPanel.add(teacherTable);



                //do stuff to get all sections into an arraylist
                ArrayList<Object> sections = new ArrayList<>();
                sections.add(new Section(125, "Math", null, null, null));
                sections.add(new Section(1251435, "Social Studies", null, null, null));

                JLabel sectionTableLabel = new JLabel("SECTION KEY/LEGEND:");
                sectionTableLabel.setBounds(600, 50, 350, 25);
                teacherPanel.add(sectionTableLabel);
                String[] columnNamesSecKey = {"Section ID", "Section"};
                JScrollPane sectionKeyTable = (new ScrollingTable(sections, columnNamesSecKey, new boolean[]{false, false}, "SectionsTaught")).getSp();
                sectionKeyTable.setBounds(600, 100, 350, 300);
                teacherPanel.add(sectionKeyTable);

                //add or remove a teacher
                JTextField firstName = new JTextField("");
                JLabel firstNameLabel = new JLabel("First Name: ");
                JTextField lastName = new JTextField("");
                JLabel lastNameLabel = new JLabel("Last Name: ");
                firstName.setBounds(750, 450, 200, 50);
                lastName.setBounds(750, 525, 200, 50);
                firstNameLabel.setBounds(600, 450, 125, 50);
                lastNameLabel.setBounds(600, 525, 125, 50);

                JButton add = new JButton("ADD");
                JButton delete = new JButton("DELETE");
                add.setBounds(600, 600, 150, 50);
                delete.setBounds(800, 600, 150, 50);

                teacherPanel.add(firstNameLabel);
                teacherPanel.add(firstName);
                teacherPanel.add(lastNameLabel);
                teacherPanel.add(lastName);
                teacherPanel.add(add);
                teacherPanel.add(delete);


                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
        
                        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "enter a full name", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            teachers.add(new Teacher(410243 /*sql id*/, firstName.getText(), lastName.getText(), null));
                            /* ***alphabetize from rolodex***
                            contactList.sort((a, b) ->

                                    a.getFirstName().compareTo(b.getFirstName())
                            );
                            contactList.sort((a, b) ->
                                    a.getLastName().compareTo(b.getLastName())
                            );
                            model.clear();
                            for (Contact co : contactList) {
                                model.addElement(co);
                            }
                            list.setModel(model);*/
                            /*firstName.setText("");
                            lastName.setText("");

                            String[] columnNamesT = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};

                            Object[][] teachersArray = new Object[teachers.size()][4];
                            Object[] row;
                            for (int i = 0;i < teachers.size(); i++) {
                                row = new Object[]{((Integer)((Teacher) teachers.get(i)).getID()), ((Teacher) teachers.get(i)).getFirstName(), ((Teacher) teachers.get(i)).getLastName(), ((Teacher) teachers.get(i)).getSections()};
                                teachersArray[i] = row;
                            }
                            JTable teacherTable = new JTable(teachersArray, columnNamesT);
                            JScrollPane teacherSp = new JScrollPane(teacherTable);
                            teacherSp.setBounds(50, 50, 500, 800);
                            frame.getContentPane().add(teacherSp);*/

                        }
                    }
                });

                /*delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "enter a full name", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {

                            boolean found = false;
                            for (int i = teachers.size() - 1; i >=0; i--) {
                                if(teachers.get(i).getFirstName().equals(firstName.getText()) && teachers.get(i).getLastName().equals(lastName.getText())) {
                                    teachers.remove(teachers.get(i));
                                    found = true;
                                }
                            }
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "teacher does not exist", "fail!", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }

                            firstName.setText("");
                            lastName.setText("");

                            String[] columnNamesT = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};

                            Object[][] teachersArray = new Object[teachers.size()][4];
                            Object[] row;
                            for (int i = 0;i < teachers.size(); i++) {
                                row = new Object[]{(Integer)(teachers.get(i).getID()), teachers.get(i).getFirstName(), teachers.get(i).getLastName(), teachers.get(i).getSections()};
                                teachersArray[i] = row;
                            }
                            JTable teacherTable = new JTable(teachersArray, columnNamesT);
                            JScrollPane teacherSp = new JScrollPane(teacherTable);
                            teacherSp.setBounds(50, 50, 500, 800);
                            frame.getContentPane().add(teacherSp);

                        }
                    }
                });*/


            }
        });

        studentViewSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                teacherPanel.setVisible(false);
                sectionPanel.setVisible(false);
                coursePanel.setVisible(false);
                aboutPanel.setVisible(false);
                studentPanel.setVisible(true);

                //test schedule
                ArrayList<Object> schedule1 = new ArrayList<Object>();
                schedule1.add(new Course(134512, "Calculus BC", "AP"));
                schedule1.add(new Course(134565, "US History", "AP"));
                schedule1.add(new Course(654665, "Computer Science A", "AP"));
                schedule1.add(new Course(153655, "Band", "Academic"));
                schedule1.add(new Course(652622, "Physics 1", "AP"));
                schedule1.add(new Course(652645, "English Language and Composition", "AP"));
                schedule1.add(new Course(652454, "Statistics", "AP"));

                //get all Student into an arraylist from db later
                ArrayList<Object> students = new ArrayList<Object>();
                students.add(new Student(125, "hstudent", "syes", schedule1));
                students.add(new Student(1251435, "ja", "ahsdfhhe", null));
                students.add(new Student(1263565, "wt", "hrd", null));
                students.add(new Student(165525, "pir", "go", null));











                //Student table display
                String[] columnNamesT = {"Course ID", "Course", "Level"};
                JScrollPane studentTable = (new ScrollingTable(schedule1, columnNamesT, new boolean[]{false, true, true}, "Course")).getSp();
                studentTable.setBounds(50, 50, 500, 800);
                studentPanel.add(studentTable);



                //need to add schedule


                //add or remove a student
                JTextField firstName = new JTextField("");
                JLabel firstNameLabel = new JLabel("First Name: ");
                JTextField lastName = new JTextField("");
                JLabel lastNameLabel = new JLabel("Last Name: ");
                firstName.setBounds(750, 450, 200, 50);
                lastName.setBounds(750, 525, 200, 50);
                firstNameLabel.setBounds(600, 450, 125, 50);
                lastNameLabel.setBounds(600, 525, 125, 50);

                JButton add = new JButton("ADD");
                JButton delete = new JButton("DELETE");
                add.setBounds(600, 600, 150, 50);
                delete.setBounds(800, 600, 150, 50);

                studentPanel.add(firstNameLabel);
                studentPanel.add(firstName);
                studentPanel.add(lastNameLabel);
                studentPanel.add(lastName);
                studentPanel.add(add);
                studentPanel.add(delete);


                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "enter a full name", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            students.add(new Teacher(410243 /*sql id*/, firstName.getText(), lastName.getText(), null));
                            /* ***alphabetize from rolodex***
                            contactList.sort((a, b) ->

                                    a.getFirstName().compareTo(b.getFirstName())
                            );
                            contactList.sort((a, b) ->
                                    a.getLastName().compareTo(b.getLastName())
                            );
                            model.clear();
                            for (Contact co : contactList) {
                                model.addElement(co);
                            }
                            list.setModel(model);*/
                            /*firstName.setText("");
                            lastName.setText("");

                            String[] columnNamesT = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};

                            Object[][] teachersArray = new Object[teachers.size()][4];
                            Object[] row;
                            for (int i = 0;i < teachers.size(); i++) {
                                row = new Object[]{((Integer)((Teacher) teachers.get(i)).getID()), ((Teacher) teachers.get(i)).getFirstName(), ((Teacher) teachers.get(i)).getLastName(), ((Teacher) teachers.get(i)).getSections()};
                                teachersArray[i] = row;
                            }
                            JTable teacherTable = new JTable(teachersArray, columnNamesT);
                            JScrollPane teacherSp = new JScrollPane(teacherTable);
                            teacherSp.setBounds(50, 50, 500, 800);
                            frame.getContentPane().add(teacherSp);*/

                        }
                    }
                });

                /*delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "enter a full name", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {

                            boolean found = false;
                            for (int i = teachers.size() - 1; i >=0; i--) {
                                if(teachers.get(i).getFirstName().equals(firstName.getText()) && teachers.get(i).getLastName().equals(lastName.getText())) {
                                    teachers.remove(teachers.get(i));
                                    found = true;
                                }
                            }
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "teacher does not exist", "fail!", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }

                            firstName.setText("");
                            lastName.setText("");

                            String[] columnNamesT = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};

                            Object[][] teachersArray = new Object[teachers.size()][4];
                            Object[] row;
                            for (int i = 0;i < teachers.size(); i++) {
                                row = new Object[]{(Integer)(teachers.get(i).getID()), teachers.get(i).getFirstName(), teachers.get(i).getLastName(), teachers.get(i).getSections()};
                                teachersArray[i] = row;
                            }
                            JTable teacherTable = new JTable(teachersArray, columnNamesT);
                            JScrollPane teacherSp = new JScrollPane(teacherTable);
                            teacherSp.setBounds(50, 50, 500, 800);
                            frame.getContentPane().add(teacherSp);

                        }
                    }
                });*/


            }
        });

        sectionViewSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherPanel.setVisible(false);
                sectionPanel.setVisible(true);
                coursePanel.setVisible(false);
                studentPanel.setVisible(false);
                aboutPanel.setVisible(false);
            }
        });

        courseViewSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherPanel.setVisible(false);
                sectionPanel.setVisible(false);
                coursePanel.setVisible(true);
                studentPanel.setVisible(false);
                aboutPanel.setVisible(false);
            }
        });

        aboutSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherPanel.setVisible(false);
                sectionPanel.setVisible(false);
                coursePanel.setVisible(false);
                studentPanel.setVisible(false);

                JLabel versionsAndMakes = new JLabel("school version 1.3 | created by pranav ullas");
                versionsAndMakes.setBounds(400, 450, 200, 50);
                aboutPanel.add(versionsAndMakes);

                aboutPanel.setVisible(true);
            }
        });


        frame.getContentPane().add(teacherPanel);
        frame.getContentPane().add(studentPanel);
        frame.getContentPane().add(coursePanel);
        frame.getContentPane().add(sectionPanel);
        frame.getContentPane().add(aboutPanel);
        frame.setVisible(true);

    }


    /*public boolean isCellEditable(int row, int column) {
        if(row ==2 && column ==3) {
            return false;
        }
        else {
            return true;
        }
    }*/

}