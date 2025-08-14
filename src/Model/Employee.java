package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private int ID;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String birthDate;
    private double salary;
    public  Department department;
    private String password;
    public Employee(){}
    public Employee(int ID, Database database){
        try {
            setID(ID);
            String select = "SELECT `ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, `BirthDate`, `Salary`, `Department`, `Password` FROM `employees` WHERE `ID` = " + getID() + ";";
            ResultSet rs = database.getStatement().executeQuery(select);
            if (rs.next()) {
                setFirstname(rs.getString("FirstName"));
                setLastname(rs.getString("LastName"));
                setEmail(rs.getString("Email"));
                setPhoneNumber(rs.getString("PhoneNumber"));
                setBirthDate(rs.getString("BirthDate"));
                setSalary(rs.getDouble("Salary"));
                setPassword(rs.getString("Password"));

                int depID = rs.getInt("Department");
                // Check if department ID is not null and not 0 (in case of null integer)
                if (!rs.wasNull() && depID > 0) {
                    try {
                        Department dept = new Department(depID, database);
                        // Only set department if it was successfully loaded
                        if (dept.getName() != null) {
                            setDepartment(dept);
                        } else {
                            System.out.println("⚠️ Warning: Department with ID " + depID + " not found for employee " + ID);
                            // Create a placeholder department to avoid null issues
                            Department placeholder = new Department();
                            placeholder.setID(depID);
                            placeholder.setName("Department " + depID + " (Not Found)");
                            setDepartment(placeholder);
                        }
                    } catch (Exception e) {
                        System.out.println("⚠️ Warning: Error loading department " + depID + " for employee " + ID);
                        e.printStackTrace();
                        // Create a placeholder department
                        Department placeholder = new Department();
                        placeholder.setID(depID);
                        placeholder.setName("Department " + depID + " (Error)");
                        setDepartment(placeholder);
                    }
                } else {
                    System.out.println("⚠️ Warning: Employee " + ID + " has no department assigned");
                    // You might want to assign a default department or handle this case
                }
            } else {
                System.out.println("❌ No employee found with ID: " + ID);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public int getID() {
        return ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void update(Database database) {
        try {
            if (getDepartment() == null) {
                System.out.println("❌ Department is null. Cannot update employee without department.");
                return;
            }

            // Check if department is a placeholder (invalid department)
            String deptTitle = getDepartment().getName();
            if (deptTitle != null && (deptTitle.contains("(Not Found)") || deptTitle.contains("(Error)"))) {
                System.out.println("⚠️ Warning: Updating employee with placeholder department: " + deptTitle);
                // You might want to add additional validation or ask user confirmation here
            }

            String updateEmployee = "UPDATE `employees` SET "
                    + "`FirstName`='" + escapeString(getFirstname()) + "',"
                    + "`LastName`='" + escapeString(getLastname()) + "',"
                    + "`Email`='" + escapeString(getEmail()) + "',"
                    + "`PhoneNumber`='" + escapeString(getPhoneNumber()) + "',"
                    + "`BirthDate`='" + escapeString(getBirthDate()) + "',"
                    + "`Salary`=" + getSalary() + ","
                    + "`Department`=" + getDepartment().getID() + ","
                    + "`Password`='" + escapeString(getPassword()) + "' "
                    + "WHERE `ID`= " + getID() + ";";

            database.getStatement().executeUpdate(updateEmployee);
            System.out.println("✅ Employee updated successfully");
        } catch (SQLException e) {
            System.out.println("❌ Error updating employee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method to escape strings for SQL (basic escaping)
    private String escapeString(String input) {
        if (input == null) return "";
        return input.replace("'", "''"); // Basic SQL injection protection
    }
    public void print(){
        System.out.println("ID \t\t : " +getID());
        System.out.println("Name \t\t: " +getFirstname() + getLastname());
        System.out.println("Email: " +getEmail());
        System.out.println("PhoneNumber: " +getPhoneNumber());
        System.out.println("Departmant: "+ getDepartment().getName());
        System.out.println("BirthDate: " +getBirthDate());
        System.out.println("Salary: "+getSalary());
        System.out.println("----------------------------------------");
    }

    public void create(Database database){
        try{



            String insert = "INSERT INTO `employees`(`ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, `BirthDate`, `Salary`, `Department`, `Password`) VALUES ('"+ ID +"','"+ firstname +"','"+ lastname +"','"+ email +"','"+ phoneNumber +"','"+ birthDate +"','"+ salary +"','"+ department.getID() +"','"+ password +"')";
            database.getStatement().executeUpdate(insert);
            System.out.println("Employee added Successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}


