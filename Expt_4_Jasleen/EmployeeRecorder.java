// Performed By: Jasleen Minhas
// UID: 20BCS6879

/* 
Menu Driven Class which used to Store the employee details in a file or to read details from employee in a file
Data Members:   
    choice (for taking menu inputs), 
    objEmployeeList(for storing the objects in a LinkedList)

Methods:
    displayMenu(): For displaying the MENU
    displayAll(): To display all records
    getEmployeeInfo(): To get the Employee Information from the user and storing it into our list
    writeEmployeeInfo(fileName): to write the objects in the fileName
    readEmployeeInfo(fileName): to read the objects from the fileName
*/

import java.util.*;
import java.io.*;

public class EmployeeRecorder {
    int choice = 0;
    Scanner input = new Scanner(System.in);
    List<Employee> objEmployeeList = new LinkedList<Employee>();

    // Main function calling other functions
    public static void main(String[] args) {
        System.out.println("\nExperiment Performed By: Jasleen Minhas\nUID: 20BCS6897");
        EmployeeRecorder obj = new EmployeeRecorder();

        obj.displayMenu();
        while (obj.choice != 5) {
            obj.displayMenu();
        }
    }

    // Function to Display the menu
    private void displayMenu() {
        System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("Employee Details Menu Driven: (Jasleen Minhas)");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\t1. Add an Employee.");
        System.out.println("\t2. Display all the Employees Record.");
        System.out.println("\t3. Write all entered employees to a file.");
        System.out.println("\t4. Read all the employees details from the file.");
        System.out.println("\t5. Exit the Program!");

        System.out.print("\nEnter your choice: ");
        choice = input.nextInt();
        System.out.println("");

        switch (choice) {
            case 1:
                getEmployeeInfo();
                break;

            case 2:
                displayAll();
                break;

            case 3:
                System.out.print("Write the filename you want to write the details: ");
                String fileName = input.next();
                writeEmployeeInfo(fileName);
                break;

            case 4:
                System.out.print("Write the filename you want to read the details from: ");
                fileName = input.next();
                readEmployeeInfo(fileName);
                break;

            case 5:
                System.out.println("Thank you for using this program!!!");
                System.exit(0);

            default:
                System.out.println("You Selected Wrong Choice!!! Try Again!");
        }
    }

    // Function for Reading files from the fileName and then displaying the details
    // on the console screen
    private void readEmployeeInfo(String fileName) {
        File fObject = new File(fileName);
        if (!fObject.exists()) {
            System.out.println("Unable to read the file");
            return;
        }

        FileInputStream fStreamObj;
        try {
            System.out.println("File Accessed! ");
            fStreamObj = new FileInputStream(fObject);
            ObjectInputStream objReader = new ObjectInputStream(fStreamObj);
            objEmployeeList.clear();
            objEmployeeList = (List<Employee>) objReader.readObject();
            System.out.println("\nExtracted the data from the file");
            for (int i = 0; i < objEmployeeList.size(); i++) {
                Employee employee = objEmployeeList.get(i);
                System.out.println(employee.getDetails());
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
    }

    // Function for writing the current List of employees to the fileName
    private void writeEmployeeInfo(String fileName) {
        File fObject = new File(fileName);
        FileOutputStream fStreamObj;
        try {
            fStreamObj = new FileOutputStream(fObject);
            System.out.println("File Accessed!");
            ObjectOutputStream objWriter = new ObjectOutputStream(fStreamObj);
            System.out.println("\nWriting the data to file " + fileName);
            objWriter.writeObject(objEmployeeList);
            System.out.println("Successfully Written the data!");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
    }

    // Function for taking the Employees Details from the user and storing it in the
    // objEmployeeList.
    private void getEmployeeInfo() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = input.nextInt();
            System.out.print("Enter Employee Name: ");
            String name = input.next();
            System.out.print("Enter Employee Age: ");
            int age = input.nextInt();
            System.out.print("Enter Employee Salary: ");
            double salary = input.nextDouble();
            objEmployeeList.add(new Employee(id, name, salary, age));
        } catch (Exception e) {
            System.out.println("Exception occured: " + e);
        }
    }

    // Displaying the Employees Details storted in the linkedList object
    private void displayAll() {
        for (int i = 0; i < objEmployeeList.size(); i++) {
            Employee employee = objEmployeeList.get(i);
            System.out.println(employee.getDetails());
        }
    }
}