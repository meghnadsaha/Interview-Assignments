package com.coding.synechron.resource;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SynechronMain {
//    CustomHashMap<String,String> customHashMap = new CustomHashMap<>();
//    customHashMap.put();

//    You have given a string that contains the braces (brackets), both opening and closing braces. You have to find the length of the longest
//    balanced subarray.
//
//            Input : {}{}{()[]()
//        Output: 6
//        Input : {}{}{()[](){}{}]]{}[]
//            Output: 10
//            Input : {}{}(){}(){()[]()
//                Output: 10

    public static void main ( String[] args ) {

        String str = "{}{}{()[]()";
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1);

        for (int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(i);
            } else if (c == '}' || c == ']') {
                if (!stack.isEmpty() && isMatch(str.charAt(stack.peek()) , c)) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int length = i - stack.peek();
                        maxLength = Math.max(maxLength , length);
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        System.out.println(maxLength);

    }

    private static boolean isMatch ( char open , char close ) {
        return (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}
