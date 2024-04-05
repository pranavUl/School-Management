import java.util.ArrayList;

public class Section {

    private int id;
    private String name;
    private ArrayList<Course> courses;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;

    public Section(int id, String name, ArrayList<Course> courses, ArrayList<Teacher> teachers, ArrayList<Student> students) {
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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
