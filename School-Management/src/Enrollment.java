public class Enrollment {
    
    private Section section;
    private Student student;
    
    public Enrollment(Section section, Student student) {
        this.section = section;
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
