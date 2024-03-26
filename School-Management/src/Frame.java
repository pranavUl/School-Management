import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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




        teacherViewSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
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
        frame.getContentPane().add(deleteContact);

        saveNew.addActionListener(new ActionListener() {
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
        });*/

        frame.setVisible(true);

    }
}