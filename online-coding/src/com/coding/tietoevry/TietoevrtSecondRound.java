package com.coding.tietoevry;

import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

public class TietoevrtSecondRound {

    public static void main ( String[] args ) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,10);

        List<Integer> evenNumbersGreaterThanFour = numbers.stream()
                .filter(number->number%2==0 & number>4)
                .collect(Collectors.toList());

        System.out.println(evenNumbersGreaterThanFour);

    }


//    constructor(private http:HttpClient ){}
//
//    getEmployeeData():Observable<any>{
//        return this.http.get<any>('https://www.google.com/');
//    }


}
