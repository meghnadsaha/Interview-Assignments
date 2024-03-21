package com.coding.epam;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// To count the occurrence of each word in a sentence using the Java Stream API, you can follow these steps:
class Main {

    /**
     * If you want to get only the words that occur exactly once in the sentence, you can modify
     * the stream operation to filter out words that have a count greater than 1. Here's how you can do it:
     */
    public static void main ( String[] args ) {
        String sentence = "HI EPAM bYe EPAM goodbye EPAM welcome ePAM Hi There epAM BYE bye EPaM";

        Map<String, Integer> map =
                Arrays
                        .stream(sentence.split(" "))
                        .map(String::toLowerCase)
                        .collect(Collectors.groupingBy(Function.identity() , Collectors.summingInt(e -> 1)))
                        .entrySet().stream()
                        .filter(entry -> entry.getValue() == 1)  // Filter out words with count > 1
                        .collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue));
        ;

        System.out.println(map);


//        uniqueWordCount.forEach(( word , count ) -> System.out.println(word + ": " + count));


    }
}