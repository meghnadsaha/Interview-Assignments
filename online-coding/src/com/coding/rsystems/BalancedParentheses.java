package com.coding.rsystems;

import java.util.stream.Stream;

public class BalancedParentheses {

    public static void main(String[] args) {
        String expression1 = "((()))";
        String expression2 = "(()))(";

        System.out.println("Expression 1 is balanced: " + isBalanced(expression1));
        System.out.println("Expression 2 is balanced: " + isBalanced(expression2));
    }

    public static boolean isBalanced(String expression) {
        return Stream.of(expression.split(""))
                     .reduce(0, (count, str) -> {
                         if (count < 0) {
                             return count; // Unbalanced
                         } else {
                             return str.equals("(") ? count + 1 : str.equals(")") ? count - 1 : count;
                         }
                     }, Integer::sum) == 0;
    }
}
