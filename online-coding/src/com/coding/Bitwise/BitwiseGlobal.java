package com.coding.Bitwise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BitwiseGlobal {



    public static void main ( String[] args ) {
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

//        listOfIntegers.stream().filter(n->n%2!=0).collect(Collectors.toList()).forEach(System.out::println);

        String inputString = "Java Concept Of The Day";
        Map<Character,Long> charCounts=
        inputString.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    }



}
