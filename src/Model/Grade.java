package Model;

public class Grade {
    private String ID;
    private Course course;
    private Class c;
    private Student student;
    private double  grade;

    Grade(){}

    public String getID() {
        return ID;
    }

    public Course getCourse() {
        return course;
    }

    public Class getC() {
        return c;
    }

    public Student getStudent() {
        return student;
    }

    public double getGrade() {
        return grade;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setC(Class c) {
        this.c = c;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
