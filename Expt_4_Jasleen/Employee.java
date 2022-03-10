// Performed By: Jasleen Minhas
// UID: 20BCS6879

import java.io.Serializable;

public class Employee implements Serializable {
    // This Employee class which stores the Employee Details
    // Data Members: id, emp_name, emp_salary, emp_age
    // Member Methods: Constructor, Getters & Setters, result
    
    private int emp_id;
    private String emp_name;
    private double emp_salary;
    private int emp_age;

    // Constructor
    public Employee(int emp_id, String emp_name, double emp_salary, int emp_age) {
        super();
        setId(emp_id);
        setemp_age(emp_age);
        setemp_name(emp_name);
        setemp_salary(emp_salary);
    }

    // Getter and Setters methods
    public int getId() {
        return emp_id;
    }

    public void setId(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getemp_name() {
        return emp_name;
    }

    public void setemp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public double getemp_salary() {
        return emp_salary;
    }

    public void setemp_salary(double emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getemp_age() {
        return emp_age;
    }

    public void setemp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    // To Show the all Details of Employee
    public String getDetails() {
        // System.out.println("\nExperiment Performed By: Jasleen Minhas,
        // 20BCS6897\n\n");
        return "Employee [id = " + emp_id + ", emp_name = " + emp_name + ", emp_salary = " + emp_salary + ", emp_age = "
                + emp_age + "]";
    }
}