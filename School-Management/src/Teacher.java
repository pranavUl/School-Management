import java.util.ArrayList;

public class Teacher {

    private int Id;
    private String firstName;
    private String lastName;
    private ArrayList<Section> sections;

    public Teacher(int ID, String firstName, String lastName, ArrayList<Section> sections) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sections = sections;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
}
