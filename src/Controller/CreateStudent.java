package Controller;

import Model.Class;
import Model.Database;
import Model.Operation;
import Model.Student;

import java.util.Scanner;

public class CreateStudent implements Operation {
    @Override
    public void oper(Database database, Scanner scanner) {
        Student s = new Student();
        System.out.println("Enter First Name:");
        s.setFirstname(scanner.next());

        System.out.println("Enter Last Name:");
        s.setLastname(scanner.next());

        System.out.println("Enter Email:");
        s.setEmail(scanner.next());

        System.out.println("Enter Birth Date:");
        s.setBirthDate(scanner.next());

        System.out.println("Enter class ID (-1 To Show all classes):");
        int classID = scanner.nextInt();
        while(classID<0){
            new ReadClasses().oper(database,scanner);
            System.out.println("Enter class ID (-1 To Show All classes)");
            classID = scanner.nextInt();
        }
        s.setClass(new Class(classID,database));

        s.create(database);
    }
}
