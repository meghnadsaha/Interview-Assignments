package com.coding.thakralOne;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Person {
    public Person ( String name , String city , int age , String id ) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getCity () {
        return city;
    }

    public void setCity ( String city ) {
        this.city = city;
    }

    public int getAge () {
        return age;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public String getId () {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }

    String name;
    String city;
    int age;
    String id;


}

public class ThakralOne {


    public static void main ( String[] args ) {

        String name = "helloworld";

        Map<Character, Long> vowelcount = new HashMap<>();

        Map<Character, Long> charCountMap = name.toLowerCase().chars()
                .mapToObj(c-> (char) c)
                .filter(c->"aeiou".indexOf(c)!=-1)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        char secongMaxChar = charCountMap.entrySet().stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .skip(1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
        long occuerrence = charCountMap.get(secongMaxChar);

        System.out.println("second Max Char : "+secongMaxChar);
        System.out.println("occuerrence of that char : "+occuerrence);



//        Person person1 = new Person("robert" , "newyork" , 10 , "9798");
//        Person person2 = new Person("shyam" , "delhi" , 13 , "22");
//        Person person3 = new Person("robin" , "mumbai" , 15 , "424235");
//        Person person4 = new Person("kartik" , "chennai" , 15 , "5445");
//        Person person5 = new Person("ram" , "kolkata" , 10 , "6456");
//        Person person6 = new Person("rahul" , "hyd" , 98 , "465");
//
//        List<Person> personList = Arrays.asList(person1 , person2 , person3 , person4 , person5 , person6);
//
//
//        Map<Integer, List<String>> personListWithsameAge = personList.stream()
//                                                                     .collect(Collectors.groupingBy(Person::getAge ,
//                                                                                                    Collectors.mapping(
//                                                                                                            Person::getName ,
//                                                                                                            Collectors.toList())));
//
//        personListWithsameAge.entrySet().stream()
//                             .filter(entry -> entry.getValue().size() > 1)
//                             .forEach(System.out::println);
//
//
//        int thirdhighestage = personList.stream()
//                                        .filter(person -> !person.getCity().equals("delhi"))
//                                        .map(Person::getAge)
//                                        .distinct()
//                                        .sorted(Comparator.reverseOrder())
//                                        .skip(1)
//                                        .findFirst()
//                                        .orElse(null);
//
//        List<Person> result = personList.stream()
//                                        .filter(person -> person.getAge() == thirdhighestage)
//                                        .collect(Collectors.toList());
//
//        result.forEach(System.out::println);

    }
//        List<Integer> numbers = Arrays.asList(135 , 15 , 1 , 42 , 32);
//
//        List<Integer> filteredNumbers = numbers.stream()
//                                               .filter(number -> String.valueOf(number).startsWith("1"))
//                                               .collect(Collectors.toList());
//
//        System.out.println(filteredNumbers);
//
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1 , "A");
//        map.put(2 , "B");
//        map.put(3 , "C");
//        map.put(4 , "A");
//        map.put(5 , "B");
//        map.put(6 , "C");
//
////       output:
////        A-1,4
////        b-2,5
//
//
//        Map<String, String> outputMap = map.entrySet()
//                                           .stream()
//                                           .collect(Collectors.groupingBy(Map.Entry::getValue , Collectors.mapping(
//                                                   entry -> entry.getKey().toString() , Collectors.joining(","))));
//
//
//        outputMap.forEach(( key , value ) -> System.out.println(key + "-" + value));
//
//
//        List<Integer> numbers1 = Arrays.asList(25 , 5 , 3 , 2 , 30 , 10 , 15);
//
//        int max = numbers1.stream().mapToInt(Integer::intValue).max().orElseThrow(() -> new IllegalStateException(""));
//
//
//        List<List<Integer>> combinations = findCombinations(numbers1 , max);
//
//        System.out.println("Combinations that make the max value:");
//        combinations.forEach(System.out::println);
//    }
//
//    private static List<List<Integer>> findCombinations ( List<Integer> list , int targetSum ) {
//        List<List<Integer>> result = new ArrayList<>();
//        findCombinationsRecursive(result , new ArrayList<>() , list , targetSum , 0);
//        return result;
//    }
//
//    private static void findCombinationsRecursive ( List<List<Integer>> result , List<Integer> current , List<Integer> remaining , int targetSum , int startIndex ) {
//        if (targetSum == 0) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//
//        for (int i = startIndex ; i < remaining.size() ; i++) {
//            int num = remaining.get(i);
//            if (targetSum - num >= 0) {
//                current.add(num);
//                findCombinationsRecursive(result , current , remaining , targetSum - num , i);
//                current.remove(current.size() - 1);
//            }
//        }
//    }
}
