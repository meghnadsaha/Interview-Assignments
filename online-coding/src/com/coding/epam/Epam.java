package com.coding.epam;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class Employee {
    private String name;

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getDepartment () {
        return department;
    }

    public void setDepartment ( String department ) {
        this.department = department;
    }

    public double getSalary () {
        return salary;
    }

    public void setSalary ( double salary ) {
        this.salary = salary;
    }

    private String department;
    private double salary;

    // Constructor, getters, and setters
    public Employee ( String name , String department , double salary ) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class Epam {

    public static void reverseArray ( int array[] ) {
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex < endIndex) {
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
        for (int num : array) {
            System.out.print(num + " ");

        }
    }


    private static void multiplicationUsingBiFunction () {
        BiFunction<Integer, Integer, Integer> multiply = ( a , b ) -> a * b;
        System.out.println("Product : " + multiply.apply(89 , 1));
    }

    private static void sortBySalaryAndGroupByDepartment () {
        List<Employee> employees = Arrays.asList(new Employee("Alice" , "Engineering" , 50000) ,
                                                 new Employee("Bob" , "Engineering" , 60000) ,
                                                 new Employee("Charlie" , "HR" , 45000) ,
                                                 new Employee("David" , "HR" , 55000) ,
                                                 new Employee("Eve" , "Marketing" , 52000));
        // Sort by salary and group by department
        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                                                                   .sorted(Comparator.comparingDouble(
                                                                           Employee::getSalary))
                                                                   .collect(Collectors.groupingBy(
                                                                           Employee::getDepartment));

        // Print the result
        groupedByDepartment.forEach(( department , empList ) -> {
            System.out.println("Department: " + department);
            empList.forEach(employee -> System.out.println("\t" + employee.getName() + " - " + employee.getSalary()));
        });
    }

    private static void sortByLengthAndAlphabetically () {
        String str = "This world is beautiful ia in't it ";
        List<String> stringList = Arrays.asList(str.split(" "));

        // Sort alphabetically
        List<String> sortedAlphabetically = stringList.stream()
                                                      .sorted(Comparator.naturalOrder())
                                                      .collect(Collectors.toList());
        System.out.println("Sorted alphabetically: " + sortedAlphabetically);

        // Sort by length
        List<String> sortedByLength = stringList.stream()
                                                .sorted(Comparator.comparingInt(String::length))
                                                .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedByLength);
    }

    static String numberToWords ( long n ) {
        long limit = 1000000000000L, curr_hun, t = 0;

        // If zero return zero
        if (n == 0) return ("Zero");

        // Array to store the powers of 10
        String multiplier[] = {"" , "Trillion" , "Billion" , "Million" , "Thousand"};

        // Array to store numbers till 20
        String first_twenty[] = {"" , "One" , "Two" , "Three" , "Four" , "Five" , "Six" , "Seven" , "Eight" , "Nine" , "Ten" , "Eleven" , "Twelve" , "Thirteen" , "Fourteen" , "Fifteen" , "Sixteen" , "Seventeen" , "Eighteen" , "Nineteen"};

        // Array to store multiples of ten
        String tens[] = {"" , "Twenty" , "Thirty" , "Forty" , "Fifty" , "Sixty" , "Seventy" , "Eighty" , "Ninety"};

        // If number is less than 20, return without any
        // further computation
        if (n < 20L) return (first_twenty[(int) n]);
        String answer = "";
        for (long i = n ; i > 0 ; i %= limit , limit /= 1000) {

            // Store the value in multiplier[t], i.e n =
            // 1000000, then r = 1, for multiplier(million),
            // 0 for multipliers(trillion and billion)
            // multiplier here refers to the current
            // accessible limit
            curr_hun = i / limit;

            // It might be possible that the current
            // multiplier is bigger than your number
            while (curr_hun == 0) {

                // Set i as the remainder obtained when n
                // was divided by the limit
                i %= limit;

                // Divide the limit by 1000, shifts the
                // multiplier
                limit /= 1000;

                // Get the current value in hundreds, as
                // English system works in hundreds
                curr_hun = i / limit;

                // Shift the multiplier
                ++t;
            }

            // If current hundred is greater than 99, Add
            // the hundreds' place
            if (curr_hun > 99) answer += (first_twenty[(int) curr_hun / 100] + " Hundred ");

            // Bring the current hundred to tens
            curr_hun = curr_hun % 100;

            // If the value in tens belongs to [1,19], add
            // using the first_twenty
            if (curr_hun > 0 && curr_hun < 20) answer += (first_twenty[(int) curr_hun] + " ");

                // If curr_hun is now a multiple of 10, but not
                // 0 Add the tens' value using the tens array
            else if (curr_hun % 10 == 0 && curr_hun != 0) answer += (tens[(int) curr_hun / 10 - 1] + " ");

                // If the value belongs to [21,99], excluding
                // the multiples of 10 Get the ten's place and
                // one's place, and print using the first_twenty
                // array
            else if (curr_hun > 20 && curr_hun < 100)
                answer += (tens[(int) curr_hun / 10 - 1] + " " + first_twenty[(int) curr_hun % 10] + " ");

            // If Multiplier has not become less than 1000,
            // shift it
            if (t < 4) answer += (multiplier[(int) ++t] + " ");
        }
        return (answer);
    }

    public static void main ( String[] args ) {

//        multiplicationUsingBiFunction();
//        sortByLengthAndAlphabetically();
//        sortBySalaryAndGroupByDepartment();
//        reverseArray(new int[]{9 , 7 , 8 , 5 , 4 , 2 , 1});
        System.out.println(numberToWords(9999));
    }

}


