package com.coding.collabera;

import java.util.*;
import java.util.stream.Collectors;

public class CollaberaMain {
    public static void main ( String[] args ) {

        removeDuplicates();
        sortMapByKey();
        sortStringArrayAlphabetically();
        maxSalaryByDepartment();

    }

    private static void maxSalaryByDepartment () {
//        Write a query to find out the employee in each department who is getting highest salary. Assuming you have Employee & Department tables
//
//        select d.department_name,MAX(e.salary) As highestSalary
//        FROM employees e
//        JOIN  department d ON e.department_id=d.department_id
//        GROUP BY d.department_name;
    }

    private static void removeDuplicates () {
        var lists = Arrays.asList(Arrays.asList(1 , 2 , 3) , Arrays.asList(2 , 3 , 4 , 5) , Arrays.asList(5 , 7 , 8));

        var uniquelist = lists.stream().flatMap(List::stream).distinct().collect(Collectors.toList());

        System.out.println(uniquelist);
    }

    private static void sortMapByKey () {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(22 , "A");
        hashmap.put(55 , "B");
        hashmap.put(33 , "Z");
        hashmap.put(44 , "M");
        hashmap.put(99 , "I");
        hashmap.put(88 , "X");

        Map<Integer, String> sortedHashmap = hashmap.entrySet()
                                                    .stream()
                                                    .sorted(Map.Entry.comparingByKey())
                                                    .collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue ,
                                                                              ( e1 , e2 ) -> e1 , LinkedHashMap::new));
        sortedHashmap.forEach(( key , value ) -> System.out.println(key + " : " + value));
    }

    private static void sortStringArrayAlphabetically () {
        String array[] = new String[]{"Italy" , "Luxembourg" , "Belgium" , "Denmark" , "Finland" , "France" , "Slovakia" , "Slovenia" , "Germany" , "Greece" , "Ireland" , "Netherlands" , "Portugal"};

//        Arrays.stream(array)
//              .sorted()
//              .forEach(System.out::println);


        for (int i = 0 ; i < array.length - 1 ; i++) {
            for (int j = 0 ; j < array.length - i - 1 ; j++) {
                if (array[j].compareToIgnoreCase(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
        for (String country : array) {
            System.out.println(country);
        }
    }
}

