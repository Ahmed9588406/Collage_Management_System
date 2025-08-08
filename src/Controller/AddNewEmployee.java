package Controller;

import Model.Database;
import Model.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddNewEmployee implements Operation {

    @Override
    public void oper(Database database, Scanner scanner) {
        System.out.println("Enter First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Second Name:");
        String lastname = scanner.next();
        System.out.println("Enter Email:");
        String email = scanner.next();
        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.next();
        System.out.println("Enter Birth Date:");
        String birthdate = scanner.next();
        System.out.println("Enter Salary(double):");
        double salary = scanner.nextDouble();
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
        while(depID < 0){
            new ShowAllDepartment().oper(database,scanner);
            System.out.println("Enter Department ID (-1 TO SHOW all Department)");
            depID = scanner.nextInt();

        }
        try{
            ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*) FROM `Employees`;");
            rs.next();
            int ID = rs.getInt("COUNT(*)");

            String insert = "INSERT INTO `employees`(`ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, `BirthDate`, `Salary`, `Department`, `Password`) VALUES ('"+ ID +"','"+ firstName +"','"+ lastname +"','"+ email +"','"+ phoneNumber +"','"+ birthdate +"','"+ salary +"','"+ depID +"','"+ password +"')";
            database.getStatement().executeUpdate(insert);
            System.out.println("Employee added Successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
