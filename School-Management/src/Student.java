import java.util.ArrayList;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Object> schedule;

    public Student(int id, String firstName, String lastName, ArrayList<Object> schedule) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schedule = schedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Object> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Object> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return this.lastName + ", " + this.firstName + " (" + this.id + ")";
    }
}
