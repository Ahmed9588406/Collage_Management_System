package Controller;

import Model.Database;
import Model.Department;
import Model.Operation;

import java.util.Scanner;

public class DeleteDepartment implements Operation {
    @Override
    public void oper(Database database, Scanner scanner) {
        System.out.println("Enter Department ID (-1 to show all Departments):");
        int ID = scanner.nextInt();
        while (ID<0){
            new ShowAllDepartment().oper(database,scanner);
            System.out.println("Enter Department ID (-1 to show all Departments):");
            ID = scanner.nextInt();
        }
        Department d = new Department(ID);
        d.delete(database);
    }
}
