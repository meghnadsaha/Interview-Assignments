package com.coding.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {

    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    private String name;
    private int age;
    private double salary;
    public Employee ( String name , int age , double salary ) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public void setSalary ( double salary ) {
        this.salary = salary;
    }






    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}
public class Main {
    public static void main ( String[] args ) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice" , 25 , 50000));
        employees.add(new Employee("Alice" , 25 , 50000));

        employees.add(new Employee("Bob" , 35 , 60000));
        employees.add(new Employee("Charlie" , 40 , 70000));
        employees.add(new Employee("David" , 30 , 55000));
        employees.add(new Employee("Charlie" , 40 , 70000));


        Map<String, Long> nameCountMap = employees.stream()
                                                  .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        List<Employee> duplicateEmployees = employees.stream()
                                                     .filter(e -> nameCountMap.get(e.getName()) > 1)
                                                     .collect(Collectors.toList());

        System.out.println("Duplicate Employees:");
        duplicateEmployees.forEach(System.out::println);


    }

}
