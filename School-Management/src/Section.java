import java.util.ArrayList;

public class Section {

    private int id;;
    private int cID;
    private int tID;
    private String course;
    private String tFirstName;
    private String tLastName;
    private ArrayList<Object> students;
    
    public Section(int id, int cID, int tID) {
        this.id = id;
        this.cID = cID;
        this.tID = tID;
        this.students = new ArrayList<Object>();
    }

    public Section(int id, int cID, int tID, String course) {
        this.id = id;
        this.cID = cID;
        this.tID = tID;
        this.course = course;
        this.students = new ArrayList<Object>();
    }

    public Section(int id, int cID, int tID, String course, String tFirstName, String tLastName) {
        this.id = id;
        this.cID = cID;
        this.tID = tID;
        this.course = course;
        this.tFirstName = tFirstName;
        this.tLastName = tLastName;
        this.students = new ArrayList<Object>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String gettFirstName() {
        return tFirstName;
    }

    public void settFirstName(String tFirstName) {
        this.tFirstName = tFirstName;
    }

    public String gettLastName() {
        return tLastName;
    }

    public void settLastName(String tLastName) {
        this.tLastName = tLastName;
    }

    public ArrayList<Object> getStudents() {
        return students;
    }

    public void addStudent(Object s) {
        students.add(s);
    }

    public void setStudents(ArrayList<Object> students) {
        this.students = students;
    }

        
}
