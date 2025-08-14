package Controller;

import Model.Database;
import Model.Department;
import Model.Operation;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateDepartment implements Operation {
    @Override
    public void oper(Database database, Scanner scanner) {
        System.out.println("Enter Department Name");
        String depName = scanner.nextLine();
        int ID = 0;
        ArrayList<Department> departments = new ShowAllDepartment().getAllDepartments(database);
        if (departments.size()!=0){
            ID = departments.get(departments.size()-1).getID()+1;
        }

        Department department = new Department();
        department.setID(ID);
        department.setName(depName);
        department.create(database);
        System.out.println("Department Created Successfully");
    }
}
