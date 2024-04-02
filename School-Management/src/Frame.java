import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame {
    public static void main(String[] args) {

        JFrame frame = new JFrame("SCHOOL MANAGEMENT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000 ,1000);
        frame.setLayout(null);


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

                //frame.removeAll();

                //get all teachers into an arraylist from db later
                ArrayList<Teacher> teachers = new ArrayList<Teacher>();
                teachers.add(new Teacher(125, "h", "s", null));
                teachers.add(new Teacher(1251435, "ja", "ahe", null));
                teachers.add(new Teacher(1263565, "wt", "rd", null));
                teachers.add(new Teacher(165525, "pir", "go", null));


                //teacher table display
                String[] columnNames = {"Teacher ID", "First Name", "Last Name", "Sections Taught"};

                Object[][] teachersArray = new Object[teachers.size()][4];
                Object[] row;
                for (int i = 0;i < teachers.size(); i++) {
                    row = new Object[]{(Integer)(teachers.get(i).getID()), teachers.get(i).getFirstName(), teachers.get(i).getLastName(), teachers.get(i).getSections()};
                    teachersArray[i] = row;
                }
                JTable teacherTable = new JTable(teachersArray, columnNames);
                JScrollPane teacherSp = new JScrollPane(teacherTable);
                teacherSp.setBounds(50, 50, 500, 800);
                frame.getContentPane().add(teacherSp);

                //do stuff to get all sections into an arraylist
                ArrayList<Section> sections = new ArrayList<Section>();
                sections.add(new Section(125, "Math", null, null, null));
                sections.add(new Section(1251435, "Social Studies", null, null, null));


                //sections display
                String[] columnNames2 = {"Section ID", "Section"};

                Object[][] sectionsArray = new Object[sections.size()][columnNames2.length];
                for (int i = 0;i < sections.size(); i++) {
                    row = new Object[]{(Integer)(sections.get(i).getId()), sections.get(i).getName()};
                    sectionsArray[i] = row;
                }
                JTable sectionTable = new JTable(sectionsArray, columnNames2);
                JScrollPane sectionSp = new JScrollPane(sectionTable);
                sectionSp.setBounds(600, 50, 350, 300);
                frame.getContentPane().add(sectionSp);

                //add or remove a teacher
                JTextField firstName = new JTextField("");
                JLabel firstNameLabel = new JLabel("First Name: ");
                JTextField lastName = new JTextField("");
                JLabel lastNameLabel = new JLabel("Last Name: ");
                firstName.setBounds(750, 400, 200, 50);
                lastName.setBounds(750, 475, 200, 50);
                firstNameLabel.setBounds(600, 400, 125, 50);
                lastNameLabel.setBounds(600, 475, 125, 50);

                JButton add = new JButton("ADD");
                JButton delete = new JButton("DELETE");
                add.setBounds(600, 550, 150, 50);
                delete.setBounds(800, 550, 150, 50);

                frame.getContentPane().add(firstNameLabel);
                frame.getContentPane().add(firstName);
                frame.getContentPane().add(lastNameLabel);
                frame.getContentPane().add(lastName);
                frame.getContentPane().add(add);
                frame.getContentPane().add(delete);


                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
        
                        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "enter a full name", "fail!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            contactList.add(new Contact(firstName.getText(), lastName.getText(), phone.getText(), address.getText()));
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
                            list.setModel(model);
                            firstName.setText("");
                            lastName.setText("");
                            phone.setText("");
                            address.setText("");
                        }
                    }
                });


            }
        });



        


        /*JTextField firstName = new JTextField("");
        JLabel firstNameLabel = new JLabel("First Name: ");
        JTextField lastName = new JTextField("");
        JLabel lastNameLabel = new JLabel("Last Name: ");
        JTextField phone = new JTextField("");
        JLabel phoneLabel = new JLabel("Phone Number: ");
        JTextField address = new JTextField("");
        JLabel addressLabel = new JLabel("Address: ");
        Button saveNew = new Button("SAVE");
        Button newB = new Button("NEW");
        Button saveChanges = new Button("SAVE CHANGES");
        Button deleteContact = new Button("DELETE CONTACT");
        ArrayList<Contact> contactList = new ArrayList<Contact>();


        DefaultListModel<Contact> model = new DefaultListModel<Contact>();
        JList<Contact> list = new JList<Contact>(model);
        JScrollPane scrollingContacts = new JScrollPane(list);

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
        list.setModel(model);

        scrollingContacts.setBounds(0, 0, 350, 700);
        firstNameLabel.setBounds(400, 100, 100, 25);
        firstName.setBounds(525, 100, 175, 25);
        lastNameLabel.setBounds(400, 175, 100, 25);
        lastName.setBounds(525, 175, 175, 25);
        phoneLabel.setBounds(400, 250, 100, 25);
        phone.setBounds(525, 250, 175, 25);
        addressLabel.setBounds(400, 325, 100, 25);
        address.setBounds(525, 325, 175, 25);

        saveNew.setBounds(400, 400, 300, 50);
        newB.setBounds(400, 475, 300, 50);
        saveChanges.setBounds(400, 400, 300, 50);
        saveChanges.setVisible(false);
        deleteContact.setBounds(400, 475, 300, 50);
        deleteContact.setVisible(false);


        frame.getContentPane().add(scrollingContacts);
        frame.getContentPane().add(firstNameLabel);
        frame.getContentPane().add(firstName);
        frame.getContentPane().add(lastNameLabel);
        frame.getContentPane().add(lastName);
        frame.getContentPane().add(phoneLabel);
        frame.getContentPane().add(phone);
        frame.getContentPane().add(addressLabel);
        frame.getContentPane().add(address);
        frame.getContentPane().add(saveNew);
        frame.getContentPane().add(newB);
        frame.getContentPane().add(saveChanges);
        frame.getContentPane().add(deleteContact);*/

        frame.setVisible(true);

    }
}