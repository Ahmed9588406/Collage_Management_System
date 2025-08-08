package Model;

public class Student {
    private String ID;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private Class c;

    Student(){}

    public String getID() {
        return ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Class getC() {
        return c;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setC(Class c) {
        this.c = c;
    }
}
