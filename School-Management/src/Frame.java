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
                        teachers.add(new Teacher((Integer.parseInt(s.split(" ")[0])), s.split(" ")[1], s.split(" ")[2], null));
                    }
                    reader.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }


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

                            String[] columnNames = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};
                            JScrollPane teacherTable = (new ScrollingTable(teachers, columnNames, new boolean[]{false, true, true, false}, "Teacher")).getSp();
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
                        teachers.add(new Teacher((Integer.parseInt(s.split(" ")[0])), s.split(" ")[1], s.split(" ")[2], null));
                    }
                    reader.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

                ArrayList<Object> sections = new ArrayList<Object>();
                sections.add(new Section(13, 145, 1));
                sections.add(new Section(14, 134565, 2));
                
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
                
                JLabel courseDDLabel = new JLabel("Sections by Course: ");
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
                
                JLabel teacherDDLabel = new JLabel("Sections by Teacher: ");
                teacherDDLabel.setBounds(800, 50, 150, 25);
                sectionPanel.add(teacherDDLabel);
                JComboBox<String> teacherDD = new JComboBox<String>(teacherNames);
                teacherDD.setBounds(800, 100, 100, 25);
                sectionPanel.add(teacherDD);

                
                //add or remove a section
                JTextField sID = new JTextField("");
                JLabel sIDLabel = new JLabel("Section ID: ");
                JTextField cID = new JTextField("");
                JLabel cIDLabel = new JLabel("Course ID: ");
                JTextField tID = new JTextField("");
                JLabel tIDLabel = new JLabel("Teacher ID: ");
                sID.setBounds(750, 575, 200, 50);
                cID.setBounds(750, 650, 200, 50);
                tID.setBounds(750, 725, 200, 50);
                sIDLabel.setBounds(600, 575, 125, 50);
                cIDLabel.setBounds(600, 650, 125, 50);
                tIDLabel.setBounds(600, 725, 125, 50);

                JButton add = new JButton("ADD");
                JButton delete = new JButton("DELETE");
                add.setBounds(600, 800, 150, 50);
                delete.setBounds(800, 800, 150, 50);

                sectionPanel.add(sIDLabel);
                sectionPanel.add(sID);
                sectionPanel.add(cIDLabel);
                sectionPanel.add(cID);
                sectionPanel.add(tID);
                sectionPanel.add(tIDLabel);
                sectionPanel.add(add);
                sectionPanel.add(delete);



                courseDD.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                        
                        int courseID = -1;
                        for (Object c : courses) {
                            if (courseDD.getSelectedItem() == ((Course) c).getName()) {
                                courseID = (((Course) c).getId());
                                break;
                            }
                        }

                        ArrayList<Object> sections2 = new ArrayList<Object>();
                        for (int i = 0; i < sections.size(); i++) {
                            if (((Section) sections.get(i)).getcID() == courseID || courseID == -1) {
                                sections2.add(sections.get(i));
                            }
                        }

                        String[] columnNames = {"Section ID", "Course ID", "Course", "Teacher ID", "T. First Name", "T. Last Name"};
                        JScrollPane sectionTable = (new ScrollingTable(sections2, columnNames, new boolean[]{false, false, false, false, false, false}, "Section")).getSp();
                        sectionTable.setBounds(50, 50, 500, 800);
                        sectionPanel.add(sectionTable);
                    }
                });

                teacherDD.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                        
                        int teacherID = -1;
                        for (Object t : teachers) {
                            System.out.println(teacherDD.getSelectedItem());
                            System.out.println((((Teacher) t).getFirstName() + " " + ((Teacher) t).getLastName()) + "\n");
                            if (teacherDD.getSelectedItem().equals(((Teacher) t).getFirstName() + " " + ((Teacher) t).getLastName())) {
                                teacherID = (((Teacher) t).getId());
                                break;
                            }
                        }
                        System.out.println(teacherID);

                        ArrayList<Object> sections2 = new ArrayList<Object>();
                        for (int i = 0; i < sections.size(); i++) {
                            if (((Section) sections.get(i)).gettID() == teacherID || teacherID == -1) {
                                sections2.add(sections.get(i));
                            }
                        }

                        String[] columnNames = {"Section ID", "Course ID", "Course", "Teacher ID", "T. First Name", "T. Last Name"};
                        JScrollPane sectionTable = (new ScrollingTable(sections2, columnNames, new boolean[]{false, false, false, false, false, false}, "Section")).getSp();
                        sectionTable.setBounds(50, 50, 500, 800);
                        sectionPanel.add(sectionTable);
                    }
                });

                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        for (Object s : sections) {
                            if (((Section) s).getId() == Integer.parseInt(sID.getText())) {
                                JOptionPane.showMessageDialog(frame, "cannot add duplicate section id", "fail!", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                        }


                        boolean found = false;
                        for (Object c : courses) {
                            if (Integer.parseInt(cID.getText()) == ((Course) c).getId()) {
                                found = true;
                                break;
                            }
                        }
        
                        if (found == false) {
                            JOptionPane.showMessageDialog(frame, "course " + Integer.parseInt(cID.getText()) +" does not exist", "fail!", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        found = false;
                        for (Object t : teachers) {
                            if (Integer.parseInt(tID.getText()) == ((Teacher) t).getId()) {
                                found = true;
                                break;
                            }
                        }

                        if (found == false) {
                            JOptionPane.showMessageDialog(frame, "teacher " + Integer.parseInt(tID.getText()) +" does not exist", "fail!", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        if (tID.getText().isEmpty() || sID.getText().isEmpty() || cID.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "please fill out all fields", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            sections.add(new Section(Integer.parseInt(sID.getText()), Integer.parseInt(cID.getText()), Integer.parseInt(tID.getText())));
                            
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


                            sID.setText("");
                            cID.setText("");
                            tID.setText("");

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