package com.coding.annalect;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    public Address getAddress () {
        return address;
    }

    public void setAddress ( Address address ) {
        this.address = address;
    }

    public int getEmpId () {
        return empId;
    }

    public void setEmpId ( int empId ) {
        this.empId = empId;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    private Address address;
    private int empId;
    private String name;


    public Employee ( int empId , String name , Address address ) {
        this.address = address;
        this.empId = empId;
        this.name = name;
    }


}

class Address {
    private String pincode;

    public String getPincode () {
        return pincode;
    }

    public void setPincode ( String pincode ) {
        this.pincode = pincode;
    }

    public String getCity () {
        return city;
    }

    public void setCity ( String city ) {
        this.city = city;
    }

    public Address ( String city , String pincode ) {
        this.pincode = pincode;
        this.city = city;
    }

    private String city;

}

public class AnnalectL1 {


    public static void main ( String[] args ) {
//        Write a program by using java8 to sort the following Employee Hashmap by using

        Map<Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(1 , new Employee(1 , "Narasa" , new Address("Nellore" , "524234")));
        employeeMap.put(2 , new Employee(2 , "Reddy" , new Address("Hyderabad" , "500050")));
        employeeMap.put(3 , new Employee(3 , "Trayana" , new Address("Nellore" , "500001")));
        employeeMap.put(4 , new Employee(4 , "Chandu" , new Address("Bangalore" , "521098")));

        Map<Integer, Employee> sortedemployeeMap = employeeMap.entrySet()
                                                              .stream()
                                                              .sorted(Map.Entry.comparingByValue(Comparator.comparing(
                                                                      e -> e.getAddress().getPincode())))
                                                              .collect(Collectors.toMap(Map.Entry::getKey ,
                                                                                        Map.Entry::getValue ,
                                                                                        ( e1 , e2 ) -> e1 ,
                                                                                        LinkedHashMap::new));

        sortedemployeeMap.forEach(( id , employee ) -> System.out.println("Id : " + id
                                                                                  + " name " + employee.getName()
                                                                                  + " pincode " + employee.getAddress()
                                                                                                          .getPincode()));

    }
}
