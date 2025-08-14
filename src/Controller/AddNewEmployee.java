package Controller;

import Model.Database;
import Model.Department;
import Model.Employee;
import Model.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddNewEmployee implements Operation {
    Employee e = new Employee();

    @Override
    public void oper(Database database, Scanner scanner) {
        System.out.println("Enter First Name:");
        e.setFirstname(scanner.next());
        System.out.println("Enter Second Name:");
        e.setLastname(scanner.next());
        System.out.println("Enter Email:");
        e.setEmail(scanner.next());
        System.out.println("Enter Phone Number:");
        e.setPhoneNumber(scanner.next());
        System.out.println("Enter Birth Date:");
        e.setBirthDate(scanner.next());
        System.out.println("Enter Salary(double):");
        e.setSalary(scanner.nextDouble());
        System.out.println("Enter Department ID (-1 to show all department):");
        int depID = scanner.nextInt();

        System.out.println("Enter Your Password");
        String password = scanner.next();
        System.out.println("Confirm Password");
        String confirmPassword = scanner.next();


        while(!confirmPassword.equals(password)){
            System.out.println("Enter Your Password");
            password = scanner.next();
            System.out.println("Confirm Password");
            confirmPassword = scanner.next();
        }

        e.setPassword(password);

        while(depID < 0){
            new ShowAllDepartment().oper(database,scanner);
            System.out.println("Enter Department ID (-1 TO SHOW all Department)");
            depID = scanner.nextInt();

        }
        e.setDepartment(new Department(depID,database));

        ArrayList<Employee> employees = new ShowAllEmpoyee().getAllEmployees(database);
        int ID = 0;
        if(employees.size()!=0){
            ID = employees.get(employees.size()-1).getID()+1;
        }

        e.setID(ID);
        e.create(database);

    }
}
