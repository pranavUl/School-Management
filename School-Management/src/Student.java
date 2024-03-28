import java.util.ArrayList;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Course> schedule;

    public Student(int id, String firstName, String lastName, ArrayList<Course> schedule) {
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

    public ArrayList<Course> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Course> schedule) {
        this.schedule = schedule;
    }
}
