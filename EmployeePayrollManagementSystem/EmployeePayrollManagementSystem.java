package EmployeePayrollManagementSystem;
import java.util.*;
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
        String s = "Employee{" + "name='" + name + '\'' + ", id=" + id + ",salary = \"calculateSalary()+\"}";
        return s;
    }
    
}

public class EmployeePayrollManagementSystem {
    
}
