package com.coding.rsystems;

//class Employee{
//    name;
//    salary;
//    dob;
//}

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Rsystems {
//    String s = "[{(]";
//    String s1 = "[{()}]";
//
//    public static void main ( String[] args ) {
//        isBalanced()
//    }
//
//    private static void isBalanced () {
//
//    }


    private static void extracted () {
        Class<?> stringClass = String.class;
        System.out.println("class name : " + stringClass.getName());

        Method[] methods = stringClass.getMethods();
        for (Method m :
                methods) {
            System.out.println(m.getName());
        }

//        Constructor<?> constructor= stringClass.getConstructor()
    }

    public static void main ( String[] args ) {

    }

}
