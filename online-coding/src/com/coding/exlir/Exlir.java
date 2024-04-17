package com.coding.exlir;


/**
 * WAP to count string length using custom Functional Interface and uses of length property
 * or function is not allowed.
 * <p>
 * if count is less than zero(0) then print Empty string else print count, but if else
 * block and ternary operator is not allowed here.
 */
@FunctionalInterface
interface  StringCounterFunction{
    String countLength(String str);
}

public class Exlir {
    public static void main ( String[] args ) {


        StringCounterFunction stringLength = str -> {
            int count = 0;
            for (char c : str.toCharArray()) {
                count++;
            }
            String result = "Empty";
            for (int i = 1 ; i <= count ; i++) {
                result = String.valueOf(i);
            }
            return result;
        };


        System.out.println(" string length is :" + stringLength.countLength(""));
    }


}
