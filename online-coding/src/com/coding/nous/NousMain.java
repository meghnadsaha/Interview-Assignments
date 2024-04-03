package com.coding.nous;

public class NousMain {

/**
 *
 Map<String,Long> genderCounts=employee.stream()
 .collect(Colllectors.groupingBy(Employee::getGender,Collectors.counting()));

 OptionalDouble avgSal = employee.stream()
 .mapToDpuble(Employee::getSalary)
 .average();


 public  class Address{
 private  final  String street;
 private  final  String city;
 private  final  String state;
 private  final  String zip;

 }

 */

/**
 *     public final class Employee implements Cloneable{
 *         private final String name;
 *         private final int age;
 *
 *         private final  Address address;
 *
 *         public Employee(String name,int age,Address address){
 *             this.name=name;
 *             this.age=age;
 *             this.address=address;
 *         }
 *
 *         public String getName(){
 *             return  name;
 *         }
 *
 *         public Address clone(){
 *             try {
 *                 return (Address) super.clone();
 *             }catch (CloneNotSupportedException e){
 *                 throw  new RuntimeException(e);
 *             }
 *         }
 *
 *     }
 */

    /**
     *  private static volatile NousMain singleTonInstance;
     *
     *     public static NousMain getSingleTonInstance () {
     *         if (singleTonInstance == null) {
     *             synchronized (NousMain.class) {
     *                 if (singleTonInstance == null) {
     *                     singleTonInstance = new NousMain();
     *                 }
     *             }
     *         }
     *         return singleTonInstance;
     *     }
     *
     *     public static void doSome () {
     *         System.out.println("Singletone instance is doing somithing");
     *     }
     *
     *     public static void main ( String[] args ) {
     *         NousMain singleTon1 = NousMain.getSingleTonInstance();
     *         NousMain singleTon2 = NousMain.getSingleTonInstance();
     *
     *         System.out.println(singleTon1 == singleTon2);
     *         singleTon1.doSome();
     *     }
     */


}
