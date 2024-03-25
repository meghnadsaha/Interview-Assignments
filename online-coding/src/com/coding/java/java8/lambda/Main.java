package com.coding.java.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main ( String[] args ) {
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        List<Integer> factorials = listOfLists.stream()
                                              .flatMap(List::stream)
                                              .map(num -> IntStream.rangeClosed(1, num).reduce(1, (x, y) -> x * y))
                                              .collect(Collectors.toList());

        System.out.println("Find the factorial of a number using streams in a list of lists.: " + factorials);



    }
}
