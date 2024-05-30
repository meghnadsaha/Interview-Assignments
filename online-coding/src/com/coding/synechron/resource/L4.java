package com.coding.synechron.resource;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;


interface MyFunction {
    int operation ( int a , int b );
}

public class L4 {
    public static void main ( String[] args ) {


        BiFunction<Integer, Integer, Integer> add = ( a , b ) -> {
            if (a == null) {
                throw new IllegalArgumentException("Argument a cant be null");
            }
            return a + b;
        };
        MyFunction sub = ( a , b ) -> a - b;

        try {
            Integer a = null;
            Integer b = 7;
            int result = add.apply(a , b);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    public static int operate ( int a , int b , MyFunction function ) {
        return function.operation(a , b);
    }
}
