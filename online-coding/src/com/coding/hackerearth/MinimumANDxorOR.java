package com.coding.hackerearth;


import java.util.Arrays;
import java.util.Scanner;

public class MinimumANDxorOR {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong(); // Number of test cases
        while (t-- > 0) {
            long n = scanner.nextLong(); // Size of the array
            long[] a = new long[(int) n];
            for (int i = 0 ; i < n ; i++)
                a[i] = scanner.nextLong();
            Arrays.sort(a); // Sort the array
            long ans = Integer.MAX_VALUE;
            for (int i = 0 ; i < n - 1 ; i++) {
                ans = Math.min(ans , a[i] ^ a[i + 1]);
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}
