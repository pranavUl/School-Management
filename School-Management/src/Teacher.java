import java.util.ArrayList;

public class Teacher {

    private int Id;
    private String firstName;
    private String lastName;

    public Teacher(int ID, String firstName, String lastName) {
        this.Id = ID;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
