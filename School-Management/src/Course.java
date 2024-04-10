import java.util.ArrayList;

public class Course {

    private int id;
    private String name;
    private String type;

    private ArrayList<Course> masterCourseList;

    public Course(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Course(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
