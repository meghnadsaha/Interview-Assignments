package com.coding.tag;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


public class TAgMain {
    public static void main ( String[] args ) {
//        String expression = "10 + 2 * 6";
//        int result = expressionEvaluator(expression);
//        System.out.println("Result: " + result);


        int[] nums = {1 , 2 , 3 , 4 , 0 , 4 , 3 , 2 , 1};
        int index = findMirrorIndexUsingStream(nums);
        if (index != -1) {
            System.out.println("Mirror index found at: " + index);
        } else {
            System.out.println("No mirror index found.");
        }
    }

    public static int findMirrorIndexUsingStream ( int[] nums ) {
        AtomicInteger totalSum = new AtomicInteger(IntStream.of(nums).sum());
        AtomicInteger leftSum = new AtomicInteger(0);
        return IntStream.range(0 , nums.length)
                        .filter(i -> {
                            totalSum.addAndGet(-nums[i]);
                            boolean result = leftSum.getAndAdd(nums[i]) == totalSum.get();
                            return result;
                        })
                        .findFirst()
                        .orElse(-1);
    }

    public static int findMirrorIndex ( int[] nums ) {
        int leftSum = 0;
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0 ; i < nums.length ; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static int expressionEvaluator
            ( String expression ) {
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0 ; i < tokens.length ; i++) {
            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sb.append(tokens[i++]);
                values.push(Integer.parseInt(sb.toString()));
            } else if (tokens[i] == '(')
                operators.push(tokens[i]);
            else if (tokens[i] == ')') {
                while (operators.peek() != '(')
                    values.push(applyOperator(operators.pop() , values.pop() , values.pop()));
                operators.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.isEmpty() && hasPrecedence(tokens[i] , operators.peek()))
                    values.push(applyOperator(operators.pop() , values.pop() , values.pop()));
                operators.push(tokens[i]);
            }
        }

        while (!operators.isEmpty())
            values.push(applyOperator(operators.pop() , values.pop() , values.pop()));

        return values.pop();
    }

    public static boolean hasPrecedence ( char op1 , char op2 ) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        return true;
    }

    public static int applyOperator ( char operator , int b , int a ) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new
                        UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
