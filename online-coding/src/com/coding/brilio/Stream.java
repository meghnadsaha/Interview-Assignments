package com.coding.brilio;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main ( String[] args ) {
        List<Integer> numbers = Arrays.asList(1 , 2 , 3 , 4 , 5 , 9 , 9 , 5);

//        int s = numbers.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(s);

//        numbers.stream().filter(n->n%2==0).forEach(System.out::println);


        List<String> array = Arrays.asList("Apple" , "Banana" , "Avocado" , "Apricot" ,
                                           "Peach" ,
                                           "");//        array.stream().map(String::toUpperCase).forEach(System.out::println);

//        double max = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
//        System.out.println(max);

//       String s = array.stream().reduce("",(a,b)->a+b);
//        System.out.println(s);

//        OptionalInt out = IntStream.range(0, array.size())
//                                   .filter(i->array.get(i).contains("by"))
//                                   .findFirst();
//        System.out.println(out.getAsInt());

//        numbers.stream().map(n -> n * n).forEach(System.out::println);

//        numbers.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

//        List<Object> mixedList = Arrays.asList("Hello" , 123 , "Java" , 456 , "World");
//        mixedList.stream().filter(object -> object instanceof Integer).sorted().forEach(System.out::println);

//        Optional<String>  longestString =array.stream().max(Comparator.comparingInt(String::length));
//        System.out.println(longestString);


//        int n = numbers.stream().reduce(1 , ( a , b ) -> a * b);
//        System.out.println(n);

        List<String> list = Arrays.asList("banana" , "apple" , "cherry" , "grape" , "fig" , "date");
//        list.stream()
//            .collect(Collectors.groupingBy(s -> s , Collectors.counting()))
//            .forEach(( key , value ) -> System.out.println(key + " : " + value));

//        list.stream()
//            .sorted()
//            .limit(3)
//            .forEach(System.out::println);

//        Optional<Integer> longestString = numbers.stream()
//                                                 .sorted()
//                                                 .skip(1).findFirst();
//        System.out.println(longestString.get());

//        Question: Given a list of strings, write a program to find the count of strings that start
//        with the letter 'A' using Stream API.
//        System.out.println(array.stream().filter(s -> s.startsWith("A")).count());;

//        Question: Write a program to filter out all the strings from a list of strings that
//        have length less than 3 using Stream API.
//        System.out.println(array.stream().filter(s->s.length()<3).count());
//        array.stream().filter(s -> s.length() >= 3).collect(Collectors.toList()).forEach(System.out::println);
//        numbers.stream().map(s -> Math.sqrt(s)).collect(Collectors.toList())
//               .forEach(System.out::println);

//        array.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);

//        System.out.println(array.stream().filter(s -> s.startsWith("A"))
//                                .max(Comparator.comparingInt(String::length)).get());;

//        System.out.println(array.stream().filter(s -> s.isBlank())
//                                .max(Comparator.comparingInt(String::length)).get());
        ;

//        array.stream().filter(String::isEmpty).forEach(System.out::println);

//
//        numbers.stream()
//               .filter(n -> n % 2 == 0)
//               .limit(5)
//               .map(n -> n * n)
//               .forEach(System.out::println);


//        List<String> strings = Arrays.asList("Hello, World!" , "   How are you?   " , "I'm   fine, thanks.");
//
//        strings.stream().map(s -> s.replaceAll("\\s" , "")).collect(Collectors.toList())
//               .forEach(System.out::println);

        array.stream()
             .flatMap(str -> Arrays.stream(str.split("\\s+")))
             .collect(Collectors.groupingBy(String::toLowerCase , Collectors.counting()))
             .forEach(( key , value ) -> System.out.println(key + " : " + value));


    }


}
