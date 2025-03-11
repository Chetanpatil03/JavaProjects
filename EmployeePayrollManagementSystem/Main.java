package EmployeePayrollManagementSystem;
import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name,int id){
        this.id = id;
        this.name = name;
    }

    // abstraction getter methods

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    
    //abstract method
    abstract double calculateSalary();

    @Override
    public String toString(){
        
        return "Employee{" + "name='" + name + '\'' + ", id=" + id + ", salary = "+calculateSalary()+"}";
    }
    
}

class FullTimeEmployee extends Employee {
    private double MonthlySalary;

    public FullTimeEmployee(String name,int id,double MonthlySalary){
        super(name, id);
        this.MonthlySalary =  MonthlySalary;
    }

    @Override
    public double calculateSalary(){
        return MonthlySalary;
    }
    
}

class PartTimeEmployee extends Employee {
    private int hoursWork;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursWork,double hourlyRate){
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWork = hoursWork;
    }

    @Override
    public double calculateSalary(){
        return hourlyRate*hoursWork;
    }
    
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();    
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;

        for(Employee employee: employeeList){
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }

        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
    
}
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Vikas", 1, 45000);

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Raman", 2, 12, 1000);

        payrollSystem.addEmployee(partTimeEmployee);
        payrollSystem.addEmployee(fullTimeEmployee);


        System.out.println("\nInitial employee details : ");
        payrollSystem.displayEmployee();

        System.out.println("\nRemoving Employee : 2");
        payrollSystem.removeEmployee(2);

        System.out.println("\nRemaining Employee Display");
        payrollSystem.displayEmployee();
    }
    
}
