import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

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
                try {
                    File file = new File("teachers.txt");
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()) {
                        String s = reader.nextLine();
                        teachers.add(new Teacher((Integer.parseInt(s.split(" ")[0])), s.split(" ")[1], s.split(" ")[2]));
                    }
                    reader.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }


                String[] columnNames = {"Teacher ID", "First Name", "Last Name"};
                JScrollPane teacherTable = (new ScrollingTable(teachers, columnNames, new boolean[]{false, true, true}, "Teacher")).getSp();
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
                            teachers.add(new Teacher(teachers.size() + 1, firstName.getText(), lastName.getText()));
            
                            firstName.setText("");
                            lastName.setText("");

                            String[] columnNames = {"Teacher ID", "First Name", "Last Name"};
                            JScrollPane teacherTable = (new ScrollingTable(teachers, columnNames, new boolean[]{false, true, true}, "Teacher")).getSp();
                            teacherTable.setBounds(50, 50, 500, 800);
                            teacherPanel.add(teacherTable);

                        }

                        try {
                            File file = new File("teachers.txt");
                            FileWriter fw = new FileWriter(file, false); 
                            for (Object c : teachers) {
                                fw.write(((Teacher) c).getId() + " " + ((Teacher) c).getFirstName() + " " + ((Teacher) c).getLastName() + " " + "\n");
                            }
                            fw.close();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
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

                            String[] columnNames = {"Teacher ID", "First Name", "Last Name"};
                            JScrollPane teacherTable = (new ScrollingTable(teachers, columnNames, new boolean[]{false, true, true}, "Teacher")).getSp();
                            teacherTable.setBounds(50, 50, 500, 800);
                            teacherPanel.add(teacherTable);
                        }

                        try {
                            File file = new File("teachers.txt");
                            FileWriter fw = new FileWriter(file, false); 
                            for (Object c : teachers) {
                                fw.write(((Teacher) c).getId() + " " + ((Teacher) c).getFirstName() + " " + ((Teacher) c).getLastName() + " " + "\n");
                            }
                            fw.close();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
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

                //get all Student into an arraylist from db later
                ArrayList<Object> students = new ArrayList<Object>();
                students.add(new Student(125, "billy", "willy", null));
                students.add(new Student(1251435, "nilly", "nilly", null));
                students.add(new Student(1263565, "bob", "joe", null));
                students.add(new Student(165525, "pete", "hi", null));

                String[] columnNames = {"Student ID", "First Name", "Last Name"};
                JScrollPane studentTable = (new ScrollingTable(students, columnNames, new boolean[]{false, true, true}, "Student")).getSp();
                studentTable.setBounds(50, 50, 400, 600);
                studentPanel.add(studentTable);

                JLabel scheduleViewerLabel = new JLabel("Find Schedule by Student ID: ");
                JTextField scheduleSID = new JTextField();
                scheduleViewerLabel.setBounds(500, 50, 200, 25);
                scheduleSID.setBounds(750, 50, 200, 25);
                studentPanel.add(scheduleViewerLabel);
                studentPanel.add(scheduleSID);

                String[] columnNames2 = {"Section ID", "Course", "Teacher ID", "T. First Name", "T. Last Name"};
                JScrollPane scheduleTable = (new ScrollingTable(students, columnNames2, new boolean[]{false, false, false, false, false}, "Schedule")).getSp();
                scheduleTable.setBounds(500, 100, 450, 400);
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

                //pull course info from file for now, DB later
                ArrayList<Object> courses = new ArrayList<Object>();
                try {
                    File file = new File("courses.txt");
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()) {
                        String s = reader.nextLine();
                        courses.add(new Course((Integer.parseInt(s.split(" ")[0])), s.split(" ")[1], s.split(" ")[2]));
                    }
                    reader.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                ArrayList<Object> teachers = new ArrayList<Object>();
                try {
                    File file = new File("teachers.txt");
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()) {
                        String s = reader.nextLine();
                        teachers.add(new Teacher((Integer.parseInt(s.split(" ")[0])), s.split(" ")[1], s.split(" ")[2]));
                    }
                    reader.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

                ArrayList<Object> sections = new ArrayList<Object>();
                try {
                    File file = new File("sections.txt");
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()) {
                        String s = reader.nextLine();
                        sections.add((new Section((Integer.parseInt(s.split(" ")[0])), Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[3]))));
                    }
                    reader.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                for (Object s : sections) {
                    for (Object c : courses) {
                        if (((Section) s).getcID() == ((Course) c).getId()) {
                            ((Section) s).setCourse(((Course) c).getName());
                            break;
                        }
                    }
                }

                for (Object s : sections) {
                    for (Object t : teachers) {
                        if (((Section) s).gettID() == ((Teacher) t).getId()) {
                            ((Section) s).settFirstName(((Teacher) t).getFirstName());
                            ((Section) s).settLastName(((Teacher) t).getLastName());
                            break;
                        }
                    }
                }

                String[] columnNames = {"Section ID", "Course ID", "Course", "Teacher ID", "T. First Name", "T. Last Name"};
                JScrollPane sectionTable = (new ScrollingTable(sections, columnNames, new boolean[]{false, false, false, false, false, false}, "Section")).getSp();
                sectionTable.setBounds(50, 50, 500, 800);
                sectionPanel.add(sectionTable);

                String[] courseNames = new String[courses.size() + 1];
                courseNames[0] = " ";
                for (int i = 1; i < courseNames.length; i++) {
                    courseNames[i] = ((Course) courses.get(i-1)).getName();
                }
                
                JLabel courseDDLabel = new JLabel("Course: " );
                courseDDLabel.setBounds(600, 50, 150, 25);
                sectionPanel.add(courseDDLabel);
                JComboBox<String> courseDD = new JComboBox<String>(courseNames);
                courseDD.setBounds(600, 100, 100, 25);
                sectionPanel.add(courseDD);

                String[] teacherNames = new String[teachers.size() + 1];
                teacherNames[0] = " ";
                for (int i = 1; i < teacherNames.length; i++) {
                    teacherNames[i] = ((Teacher) teachers.get(i-1)).getFirstName() + " " + ((Teacher) teachers.get(i-1)).getLastName();
                }
                
                JLabel teacherDDLabel = new JLabel("Teacher: ");
                teacherDDLabel.setBounds(800, 50, 150, 25);
                sectionPanel.add(teacherDDLabel);
                JComboBox<String> teacherDD = new JComboBox<String>(teacherNames);
                teacherDD.setBounds(800, 100, 100, 25);
                sectionPanel.add(teacherDD);

                JButton add = new JButton("ADD SECTION");
                JButton delete = new JButton("DELETE SECTION");
                add.setBounds(600, 150, 150, 50);
                delete.setBounds(800, 150, 150, 50);

                sectionPanel.add(add);
                sectionPanel.add(delete);

                JLabel rosterSIDLabel = new JLabel("Find Roster by Section ID: "); 
                JTextField rosterSID = new JTextField("");
                rosterSIDLabel.setBounds(600, 225, 200, 25);
                rosterSID.setBounds(850, 225, 100, 25);

                ArrayList<Object> roster = new ArrayList<Object>();
                String[] columnNames2 = {"Student First Name", "Student Last Name", "Student ID"};
                JScrollPane rosterTable = (new ScrollingTable(roster, columnNames2, new boolean[]{false, false, false}, "Roster")).getSp();
                rosterTable.setBounds(600, 275, 350, 300);
                
                
                sectionPanel.add(rosterTable);
                sectionPanel.add(rosterSIDLabel);
                sectionPanel.add(rosterSID);

                JTextField studentID = new JTextField("");
                JLabel studentIDLabel = new JLabel("Student ID: ");
                JTextField sFN = new JTextField("");
                JLabel sFNLabel = new JLabel("Student First Name: ");
                JTextField sLN = new JTextField("");
                JLabel sLNLabel = new JLabel("Student Last Name: ");
                
                studentID.setBounds(750, 600, 200, 25);
                sFN.setBounds(750, 650, 200, 25);
                sLN.setBounds(750, 700, 200, 25);
                studentIDLabel.setBounds(600, 600, 125, 25);
                sFNLabel.setBounds(600, 650, 125, 25);
                sLNLabel.setBounds(600, 700, 125, 25);

                JButton addStudent = new JButton("ADD STUDENT");
                JButton deleteStudent = new JButton("DELETE STUDENT");
                addStudent.setBounds(600, 750, 150, 50);
                deleteStudent.setBounds(800, 750, 150, 50);

                sectionPanel.add(studentIDLabel);
                sectionPanel.add(studentID);
                sectionPanel.add(sFN);
                sectionPanel.add(sFNLabel);
                sectionPanel.add(sLN);
                sectionPanel.add(sLNLabel);
                sectionPanel.add(addStudent);
                sectionPanel.add(deleteStudent);

                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (courseDD.getSelectedItem() == " " || teacherDD.getSelectedItem() == " ") {
                            JOptionPane.showMessageDialog(frame, "select a course and teacher to add new section", "fail!", JOptionPane.INFORMATION_MESSAGE);
                                return;
                        }
                        else {
                            
                            int idHolder = -1;
                            for (Object c : courses) {
                                if (((Course) c).getName() == courseDD.getSelectedItem()) {
                                    idHolder = ((Course) c).getId();
                                }
                            }
                            int idHolder2 = -1;
                            for (Object t : teachers) {
                                if ((((Teacher) t).getFirstName() + " " + ((Teacher) t).getLastName()).equals(teacherDD.getSelectedItem())) {
                                    idHolder2 = ((Teacher) t).getId();
                                }
                            }
                            
                            sections.add(new Section(sections.size() + 1, idHolder, idHolder2));
                            
                            for (Object s : sections) {
                                for (Object c : courses) {
                                    if (((Section) s).getcID() == ((Course) c).getId()) {
                                        ((Section) s).setCourse(((Course) c).getName());
                                        break;
                                    }
                                }
                            }

                            for (Object s : sections) {
                                for (Object t : teachers) {
                                    if (((Section) s).gettID() == ((Teacher) t).getId()) {
                                        ((Section) s).settFirstName(((Teacher) t).getFirstName());
                                        ((Section) s).settLastName(((Teacher) t).getLastName());
                                        break;
                                    }
                                }
                            }

                            String[] columnNames = {"Section ID", "Course ID", "Course", "Teacher ID", "T. First Name", "T. Last Name"};
                            JScrollPane sectionTable = (new ScrollingTable(sections, columnNames, new boolean[]{false, false, false, false, false, false}, "Section")).getSp();
                            sectionTable.setBounds(50, 50, 500, 800);
                            sectionPanel.add(sectionTable);

                        }

                        try {
                            File file = new File("sections.txt");
                            FileWriter fw = new FileWriter(file, false); 
                            for (Object s : sections) {
                                fw.write(((Section) s).getId() + " " + ((Section) s).getcID() + " " + ((Section) s).getCourse() + " " + ((Section) s).gettID() + " " + ((Section) s).gettFirstName() + " " + ((Section) s).gettLastName() + "\n");
                            }
                            fw.close();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }

                    }
                });

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
                try {
                    File file = new File("courses.txt");
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()) {
                        String s = reader.nextLine();
                        courses.add(new Course((Integer.parseInt(s.split(" ")[0])), s.split(" ")[1], s.split(" ")[2]));
                    }
                    reader.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }


                String[] columnNames = {"Course ID", "Name", "Type"};
                JScrollPane courseTable = (new ScrollingTable(courses, columnNames, new boolean[]{false, true, true}, "Course")).getSp();
                courseTable.setBounds(50, 50, 500, 800);
                coursePanel.add(courseTable);

                JTextField courseField = new JTextField("");
                JLabel courseLabel = new JLabel("Course Name: ");
                JLabel typeLabel = new JLabel("Course Type:");
                JRadioButton acaB = new JRadioButton("Academic");
                JRadioButton kapB = new JRadioButton("KAP");
                JRadioButton apB = new JRadioButton("AP");
                courseField.setBounds(750, 275, 200, 25);
                courseLabel.setBounds(600, 275, 125, 25);
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
                            String dashedName = courseField.getText().replace(" ", "-");  
                            courses.add(new Course(courses.size() + 1, dashedName, selected));
            
                            courseField.setText("");
                            acaB.setSelected(false);
                            kapB.setSelected(false);
                            apB.setSelected(false);

                            String[] columnNames = {"Course ID", "Name", "Type"};
                            JScrollPane courseTable = (new ScrollingTable(courses, columnNames, new boolean[]{false, true, true}, "Course")).getSp();
                            courseTable.setBounds(50, 50, 500, 800);
                            coursePanel.add(courseTable);

                        }

                        try {
                            File file = new File("courses.txt");
                            FileWriter fw = new FileWriter(file, false); 
                            for (Object c : courses) {
                                fw.write(((Course) c).getId() + " " + ((Course) c).getName() + " " + ((Course) c).getType() + " " + "\n");
                            }
                            fw.close();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
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

                        try {
                            File file = new File("courses.txt");
                            FileWriter fw = new FileWriter(file, false); 
                            for (Object c : courses) {
                                fw.write(((Course) c).getId() + " " + ((Course) c).getName() + " " + ((Course) c).getType() + " " + "\n");
                            }
                            fw.close();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
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