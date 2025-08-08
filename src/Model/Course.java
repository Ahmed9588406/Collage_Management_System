package Model;

import java.util.ArrayList;
public class Course {
    private int ID;
    private String title;
    private Class c;
    private String description;
    private int limit;
    private ArrayList<Student> student;
    private Employee prof;

    Course(){}

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public Class getC() {
        return c;
    }

    public String getDescription() {
        return description;
    }

    public int getLimit() {
        return limit;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public Employee getProf() {
        return prof;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setC(Class c) {
        this.c = c;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public void setProf(Employee prof) {
        this.prof = prof;
    }
}
