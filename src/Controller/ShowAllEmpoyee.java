package Controller;

import Model.Database;
import Model.Department;
import Model.Employee;
import Model.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowAllEmpoyee implements Operation {

    @Override
    public void oper(Database database, Scanner scanner) {
        ArrayList<Employee>employees = new ArrayList<>();
        ArrayList<Integer> depIDS = new ArrayList<>();
        try {
            String selectAllEmplyees = "SELECT * FROM employees";
            ResultSet rs = database.getStatement().executeQuery(selectAllEmplyees);
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setID(rs.getInt("ID"));
                employee.setFirstname(rs.getString("FirstName"));
                employee.setLastname(rs.getString("LastName"));
                employee.setEmail(rs.getString("Email"));
                employee.setPassword(rs.getString("Password"));
                employee.setSalary(rs.getDouble("Salary"));
                employee.setBirthDate(rs.getString("BirthDate"));
                employee.setPhoneNumber(rs.getString("PhoneNumber"));
                employees.add(employee);
                depIDS.add(rs.getInt("Department"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        for (int i=0;i<employees.size();i++){
            employees.get(i).setDepartment(new Department(depIDS.get(i),database));
        }
        for (Employee e:employees){
            e.print();
        }
    }
}
