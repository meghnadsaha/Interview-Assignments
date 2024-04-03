package com.coding.brilio;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMain {

    public static void main ( String[] args ) {
        String str ="hello world";
        Map<Character,Long> characterCounts = str.chars().
                                                 mapToObj(c-> (char)c)
                                                 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


       characterCounts.entrySet()
               .stream().filter(entry->entry.getValue()>1)
               .forEach(characterLongEntry -> System.out.println(
                       characterLongEntry.getKey()+" "+characterLongEntry.getValue()
               ));
    }
}
