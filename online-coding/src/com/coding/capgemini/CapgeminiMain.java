package com.coding.capgemini;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CapgeminiMain {


    public static void main ( String[] args ) {

        int numbers[] = {9 , 8 , 6 , 0 , 1 , 9 , 5 , 4 , 3 , 2};
        int secondHighest = Arrays.stream(numbers)
                                  .boxed()
                                  .sorted(( a , b ) -> b - a)
                                  .distinct().
                                  skip(1)
                                  .findFirst()
                                  .orElseThrow(
                                          () -> new IllegalArgumentException(
                                                  "Array has only one element or its empty"));
//        System.out.println(secondHighest);


//      [12:50 PM] Monisha, K
//        print the matching characters
        String s1 = "Naresh";
        String s2 = "Mahesh";
//        aesh

        Set<Character> set1 = s1.chars().mapToObj(c->(char)c ).collect(Collectors.toSet());
        Set<Character> set2 = s2.chars().mapToObj(c->(char)c ).collect(Collectors.toSet());

        Set<Character> set = set1.stream().filter(set2::contains).collect(Collectors.toSet());
        System.out.println(set);


    }

}
