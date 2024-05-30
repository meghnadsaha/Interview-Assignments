package com.coding.annalect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnnalectL2 {
    public static void main ( String[] args ) {
        List<Integer> numbers = Arrays.asList(1 , 6 , 6 , 7 , 8 , 9 , 4 , 0 , 0 , 3 , 77);

        List<Integer> uniqueNumbers = numbers
                .stream()
                .distinct().collect(Collectors.toList());
        System.out.println(uniqueNumbers);


    }
}
