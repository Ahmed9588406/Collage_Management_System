package Controller;

import Model.Database;
import Model.Department;
import Model.Employee;
import Model.Operation;

import java.util.Scanner;

public class UpdateEmployee implements Operation {

    @Override
    public void oper(Database database, Scanner scanner) {
        System.out.println("Enter User ID (-1 TO SHOW ALL employees):");
        int userID = scanner.nextInt();

        while(userID < 0){
            new ShowAllEmpoyee().oper(database, scanner);
            System.out.println("Enter User ID (-1 TO SHOW ALL employees):");
            userID = scanner.nextInt();
        }

        Employee employee = new Employee(userID, database);

        // Check if employee was found
        if (employee.getFirstname() == null) {
            System.out.println("❌ Employee with ID " + userID + " not found!");
            return;
        }

        // Store the original department object (not just ID) for restoration
        Department originalDepartment = employee.getDepartment();

        System.out.println("Enter First Name (-1 to keep " + employee.getFirstname() + ")");
        String firstName = scanner.next();
        if (!firstName.equals("-1")) {
            employee.setFirstname(firstName);
        }

        System.out.println("Enter Last Name (-1 to keep " + employee.getLastname() + ")");
        String lastname = scanner.next();
        if (!lastname.equals("-1")) {
            employee.setLastname(lastname);
        }

        System.out.println("Enter Email (-1 to keep " + employee.getEmail() + "):");
        String email = scanner.next();
        if (!email.equals("-1")) {
            employee.setEmail(email);
        }

        System.out.println("Enter Phone Number (-1 to keep " + employee.getPhoneNumber() + "):");
        String phoneNumber = scanner.next();
        if (!phoneNumber.equals("-1")) {
            employee.setPhoneNumber(phoneNumber);
        }

        System.out.println("Enter Birth Date (-1 to keep " + employee.getBirthDate() + ")");
        String birthdate = scanner.next();
        if (!birthdate.equals("-1")) {
            employee.setBirthDate(birthdate);
        }

        System.out.println("Enter salary (-1 to keep " + employee.getSalary() + ")");
        double salary = scanner.nextDouble();
        if (salary != -1) {
            employee.setSalary(salary);
        }

        System.out.println("Enter password (-1 to keep old password)");
        String password = scanner.next();
        if (!password.equals("-1")) {
            System.out.println("Confirm Password:");
            String confirmPassword = scanner.next();
            while (!password.equals(confirmPassword)) {
                System.out.println("Passwords don't match! Enter Password again:");
                password = scanner.next();
                System.out.println("Confirm Password:");
                confirmPassword = scanner.next();
            }
            employee.setPassword(password);
        }

        String currentDeptDisplay = (employee.getDepartment() != null) ? employee.getDepartment().getTitle() : "No Department";
        System.out.println("Enter Department ID (-1 to keep " + currentDeptDisplay + ", -2 to show all departments):");
        int depID = scanner.nextInt();

        // Handle department update with proper logic
        while (depID == -2) {
            new ShowAllDepartment().oper(database, scanner);
            System.out.println("Enter Department ID (-1 to keep current, -2 to show all departments again):");
            depID = scanner.nextInt();
        }

        // Only update department if user didn't choose to keep current one
        if (depID != -1) {
            Department newDepartment = new Department(depID, database);

            // Check if the department exists and was loaded successfully
            // A valid department should have both non-null title and valid ID
            if (newDepartment.getTitle() != null && !newDepartment.getTitle().contains("(Not Found)") && !newDepartment.getTitle().contains("(Error)")) {
                employee.setDepartment(newDepartment);
                System.out.println("✅ Department updated successfully to: " + newDepartment.getTitle());
            } else {
                System.out.println("❌ Department with ID " + depID + " not found! Keeping current department.");
                // Restore the original department object
                employee.setDepartment(originalDepartment);
            }
        }
        // If depID is -1, we keep the current department (no change needed)

        // Final check before updating - ensure we have a valid department
        if (employee.getDepartment() == null) {
            System.out.println("❌ Cannot update employee: Employee has no valid department assigned!");
            System.out.println("💡 Please assign a valid department to this employee before updating.");
            return;
        }

        // Check if the current department is a placeholder (from loading issues)
        String deptTitle = employee.getDepartment().getTitle();
        if (deptTitle != null && (deptTitle.contains("(Not Found)") || deptTitle.contains("(Error)"))) {
            System.out.println("⚠️ Warning: Employee has an invalid department reference.");
            System.out.println("💡 You may want to assign a valid department before updating.");

            // Ask user if they want to proceed anyway
            System.out.println("Do you want to proceed with the update anyway? (y/n):");
            String proceed = scanner.next();
            if (!proceed.toLowerCase().equals("y")) {
                System.out.println("❌ Update cancelled.");
                return;
            }
        }

        employee.update(database);
    }
}