package com.coding.accolite;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

 class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobTitle;
    private String department;
    private BigDecimal salary;
    private Integer managerId;


    public Employee(Integer id, String firstName, String lastName, String email, String phoneNumber, Date hireDate, String jobTitle, String department, BigDecimal salary, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobTitle = jobTitle;
        this.department = department;
        this.salary = salary;
        this.managerId = managerId;
    }

    // Getters and setters for each attribute

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", managerId=" + managerId +
                '}';
    }
}
public class ReadTextFile {
    public static void main ( String[] args ) {
        String fileName = "/Users/meghnadsaha/IdeaProjects/Interview-Assignments/online-coding/src/com/coding/accolite/resource/employee.txt"; // Your text file path

        try {
            List<Employee> employees = Files.lines(Paths.get(fileName))
                                            .map(line -> line.split(","))
                                            .map(parts -> {
                                                try {
                                                    Integer id = Integer.parseInt(parts[0]);
                                                    String firstName = parts[1];
                                                    String lastName = parts[2];
                                                    String email = parts[3];
                                                    String phoneNumber = parts[4];
                                                    Date hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(parts[5]);
                                                    String jobTitle = parts[6];
                                                    String department = parts[7];
                                                    BigDecimal salary = new BigDecimal(parts[8]);
                                                    Integer managerId = Integer.parseInt(parts[9]);

                                                    return new Employee(id , firstName , lastName , email ,
                                                                        phoneNumber , hireDate , jobTitle , department ,
                                                                        salary , managerId);
                                                } catch (ParseException | NumberFormatException e) {
                                                    e.printStackTrace();
                                                    return null;
                                                }
                                            })
                                            .filter(employee -> employee != null)
                                            .collect(Collectors.toList());

            // Serialize the list of employees
            try (FileOutputStream fos = new FileOutputStream("employees1.ser") ;
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(employees);
            }

            // Print the list of employees
            employees.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
