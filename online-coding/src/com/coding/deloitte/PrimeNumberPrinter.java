package com.coding.deloitte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * To print prime numbers from a list using two threads in Java,
 * you can divide the list into two parts and assign each part to
 * a separate thread for processing. Here's a basic example to demonstrate this concept:
 */


public class PrimeNumberPrinter {
    private static final List<Integer> numbers = Arrays.asList(
            2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20
    );

    public static void main(String[] args) {

        List<Integer> part1 = numbers.subList(0, numbers.size() / 2);
        List<Integer> part2 = numbers.subList(numbers.size() / 2, numbers.size());

        PrimeNumberThread thread1 = new PrimeNumberThread(part1);
        PrimeNumberThread thread2 = new PrimeNumberThread(part2);

        thread1.start();
        thread2.start();
    }

    static class PrimeNumberThread extends Thread {
        private final List<Integer> numbers;

        public PrimeNumberThread(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            for (Integer number : numbers) {
                if (isPrime(number)) {
                    System.out.println("Prime number: " + number + " - Thread: " + Thread.currentThread().getName());
                }
            }
        }

        private boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
