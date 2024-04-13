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

                //get all teachers into an arraylist from db later here

                ArrayList<Object> teachers = new ArrayList<Object>();
                teachers.add(new Teacher(125, "h", "s", null));
                teachers.add(new Teacher(1251435, "ja", "ahe", null));
                teachers.add(new Teacher(1263565, "wt", "rd", null));
                teachers.add(new Teacher(165525, "pir", "go", null));


                String[] columnNames = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};
                JScrollPane teacherTable = (new ScrollingTable(teachers, columnNames, new boolean[]{false, true, true, false}, "Teacher")).getSp();
                teacherTable.setBounds(50, 50, 500, 800);
                teacherPanel.add(teacherTable);



                //REDO LATER TO DISPLAY SECTIONS BY: SECTIONID, COURSE TITLE
                /*ArrayList<Object> sections = new ArrayList<>();
                sections.add(new Section(125, "Math", null, null, null));
                sections.add(new Section(1251435, "Social Studies", null, null, null));

                JLabel sectionTableLabel = new JLabel("SECTION KEY/LEGEND:");
                sectionTableLabel.setBounds(600, 50, 350, 25);
                teacherPanel.add(sectionTableLabel);
                
                String[] columnNamesSecKey = {"Section ID", "Section"};
                JScrollPane sectionKeyTable = (new ScrollingTable(sections, columnNamesSecKey, new boolean[]{false, false}, "SectionsTaught")).getSp();
                sectionKeyTable.setBounds(600, 100, 350, 300);
                teacherPanel.add(sectionKeyTable);*/

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
            
                            firstName.setText("");
                            lastName.setText("");

                            String[] columnNames = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};
                            JScrollPane teacherTable = (new ScrollingTable(teachers, columnNames, new boolean[]{false, true, true, false}, "Teacher")).getSp();
                            teacherTable.setBounds(50, 50, 500, 800);
                            teacherPanel.add(teacherTable);

                        }
                    }
                });

                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "enter a full name", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {

                            boolean found = false;
                            for (int i = teachers.size() - 1; i >=0; i--) {
                                if(((Teacher) teachers.get(i)).getFirstName().equals(firstName.getText()) && ((Teacher) teachers.get(i)).getLastName().equals(lastName.getText())) {
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

                            String[] columnNames = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};
                            JScrollPane teacherTable = (new ScrollingTable(teachers, columnNames, new boolean[]{false, true, true, false}, "Teacher")).getSp();
                            teacherTable.setBounds(50, 50, 500, 800);
                            teacherPanel.add(teacherTable);
                        }
                    }
                });


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

                //test schedule1
                ArrayList<Object> schedule1 = new ArrayList<Object>();
                schedule1.add(new Course(134512, "Calculus BC", "AP"));
                schedule1.add(new Course(134565, "US History", "AP"));
                schedule1.add(new Course(654665, "Computer Science A", "AP"));
                schedule1.add(new Course(153655, "Band", "Academic"));
                schedule1.add(new Course(652622, "Physics 1", "AP"));
                schedule1.add(new Course(652645, "English Language and Composition", "AP"));
                schedule1.add(new Course(652454, "Statistics", "AP"));

                //test schedule2
                ArrayList<Object> schedule2 = new ArrayList<Object>();
                schedule2.add(new Course(134512, "Calculus BC", "AP"));
                schedule2.add(new Course(134565, "Chemistry", "KAP"));
                schedule2.add(new Course(654665, "Seminar", "AP"));
                schedule2.add(new Course(153655, "Statistics", "Academic"));
                schedule2.add(new Course(652622, "Physics 1", "AP"));
                schedule2.add(new Course(652645, "English II", "KAP"));
                schedule2.add(new Course(652454, "Tennis", "Academic"));

                //test schedule3
                ArrayList<Object> schedule3 = new ArrayList<Object>();
                schedule2.add(new Course(134512, "Calculus BC", "AP"));
                schedule2.add(new Course(134565, "Chemistry", "KAP"));
                schedule2.add(new Course(654665, "Seminar", "AP"));
                schedule2.add(new Course(153655, "Statistics", "Academic"));
                schedule2.add(new Course(652622, "Physics 1", "AP"));
                schedule2.add(new Course(652645, "English II", "KAP"));
                schedule2.add(new Course(652454, "Tennis", "Academic"));

                //get all Student into an arraylist from db later
                ArrayList<Object> students = new ArrayList<Object>();
                students.add(new Student(125, "billy", "willy", schedule1));
                students.add(new Student(1251435, "nilly", "nilly", schedule1));
                students.add(new Student(1263565, "bob", "joe", schedule2));
                students.add(new Student(165525, "pete", "hi", schedule2));

                String[] columnNames = {"Student ID", "First Name", "Last Name"};
                JScrollPane studentTable = (new ScrollingTable(students, columnNames, new boolean[]{false, true, true}, "Student")).getSp();
                studentTable.setBounds(50, 50, 400, 600);
                studentPanel.add(studentTable);



                String[] columnNames2 = {"Section ID", "Course", "Teacher ID", "T. First Name", "T. Last Name"};
                JScrollPane scheduleTable = (new ScrollingTable(students, columnNames2, new boolean[]{false, false, false, false, false}, "Schedule")).getSp();
                scheduleTable.setBounds(500, 50, 450, 400);
                studentPanel.add(scheduleTable);

                
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

                ArrayList<Object> courses = new ArrayList<Object>();
                courses.add(new Course(145, "Calculus BC", "AP"));
                courses.add(new Course(134565, "Chemistry", "KAP"));
                courses.add(new Course(654665, "Seminar", "AP"));
                courses.add(new Course(652645, "English II", "KAP"));


                String[] columnNames = {"Course ID", "Name", "Type"};
                JScrollPane courseTable = (new ScrollingTable(courses, columnNames, new boolean[]{false, true, true}, "Course")).getSp();
                courseTable.setBounds(50, 50, 500, 800);
                coursePanel.add(courseTable);

                JTextField courseField = new JTextField("");
                JLabel courseLabel = new JLabel("Course Title: ");
                JLabel typeLabel = new JLabel("Course Type:");
                JRadioButton acaB = new JRadioButton("Academic");
                JRadioButton kapB = new JRadioButton("KAP");
                JRadioButton apB = new JRadioButton("AP");
                courseField.setBounds(750, 250, 200, 50);
                courseLabel.setBounds(600, 250, 125, 50);
                typeLabel.setBounds(600, 325, 325, 25);
                acaB.setBounds(600, 350, 100, 50);
                kapB.setBounds(725, 350, 100, 50);
                apB.setBounds(850, 350, 100, 50);

                JButton add = new JButton("ADD");
                JButton delete = new JButton("DELETE");
                add.setBounds(600, 425, 150, 50);
                delete.setBounds(800, 425, 150, 50);

                coursePanel.add(courseField);
                coursePanel.add(courseLabel);
                coursePanel.add(typeLabel);
                coursePanel.add(acaB);
                coursePanel.add(kapB);
                coursePanel.add(apB);
                coursePanel.add(add);
                coursePanel.add(delete);
                
                acaB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (acaB.isSelected()) {
                            kapB.setSelected(false);
                            apB.setSelected(false);
                        }
                    }
                });

                kapB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (kapB.isSelected()) {
                            acaB.setSelected(false);
                            apB.setSelected(false);
                        }
                    }
                });

                apB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (apB.isSelected()) {
                            acaB.setSelected(false);
                            kapB.setSelected(false);
                        }
                    }
                });
                
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        String selected = "";

                        if (acaB.isSelected()) {
                            selected = "Academic";
                        }
                        else if (kapB.isSelected()) {
                            selected = "KAP";
                        }
                        else if (apB.isSelected()) {
                            selected = "AP";
                        }
                        if (courseField.getText().isEmpty() || selected == "") {
                            JOptionPane.showMessageDialog(frame, "please complete all fields", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {                            
                            courses.add(new Course(13450, courseField.getText(), selected));
            
                            courseField.setText("");
                            acaB.setSelected(false);
                            kapB.setSelected(false);
                            apB.setSelected(false);

                            String[] columnNames = {"Course ID", "Name", "Type"};
                            JScrollPane courseTable = (new ScrollingTable(courses, columnNames, new boolean[]{false, true, true}, "Course")).getSp();
                            courseTable.setBounds(50, 50, 500, 800);
                            coursePanel.add(courseTable);

                        }
                    }
                });

                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String selected = "";

                        if (acaB.isSelected()) {
                            selected = "Academic";
                        }
                        else if (kapB.isSelected()) {
                            selected = "KAP";
                        }
                        else if (apB.isSelected()) {
                            selected = "AP";
                        }
                        if (courseField.getText().isEmpty() || selected == "") {
                            JOptionPane.showMessageDialog(frame, "please complete all fields", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {

                            boolean found = false;
                            for (int i = courses.size() - 1; i >=0; i--) {
                                if(((Course) courses.get(i)).getName().equals(courseField.getText()) && ((Course) courses.get(i)).getType().equals(selected)) {
                                    courses.remove(courses.get(i));
                                    found = true;
                                }
                            }
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "course does not exist...", "fail!", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }

                            courseField.setText("");
                            acaB.setSelected(false);
                            kapB.setSelected(false);
                            apB.setSelected(false);

                            String[] columnNames = {"Course ID", "Name", "Type"};
                            JScrollPane courseTable = (new ScrollingTable(courses, columnNames, new boolean[]{false, true, true}, "Course")).getSp();
                            courseTable.setBounds(50, 50, 500, 800);
                            coursePanel.add(courseTable);
                        }
                    }
                });

            }
        });

        aboutSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherPanel.setVisible(false);
                sectionPanel.setVisible(false);
                coursePanel.setVisible(false);
                studentPanel.setVisible(false);
                aboutPanel.setVisible(true);

                JLabel versionsAndMakes = new JLabel("school version 145i95 | created by pranav ullas");
                versionsAndMakes.setBounds(400, 450, 200, 50);
                aboutPanel.add(versionsAndMakes);
            }
        });


        frame.getContentPane().add(teacherPanel);
        frame.getContentPane().add(studentPanel);
        frame.getContentPane().add(coursePanel);
        frame.getContentPane().add(sectionPanel);
        frame.getContentPane().add(aboutPanel);
        frame.setVisible(true);

    }

}