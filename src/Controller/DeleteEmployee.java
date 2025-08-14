package Controller;

import Model.Database;
import Model.Operation;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee implements Operation {

    @Override
    public void oper(Database database, Scanner scanner) {
        try {
            System.out.println("Enter Employee ID (-1 to show all Employees): ");
            int ID = scanner.nextInt();

            while (ID < 0) {
                new ShowAllEmpoyee().oper(database, scanner);
                System.out.println("Enter Employee ID (-1 to show all Employees): ");
                ID = scanner.nextInt();
            }
            String delete = "DELETE FROM `employees` WHERE ID = " + ID + ";";
            database.getStatement().execute(delete);
            System.out.println("Employee Deleted Successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
