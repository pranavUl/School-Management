import java.util.ArrayList;

public class Section {

    private int id;
    private String name;
    private ArrayList<String> courses;
    private ArrayList<String> teachers;
    private ArrayList<Student> students;

    public Section(int id, String name, ArrayList<String> courses, ArrayList<String> teachers, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public ArrayList<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<String> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
