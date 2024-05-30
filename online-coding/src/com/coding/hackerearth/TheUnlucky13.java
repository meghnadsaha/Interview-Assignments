package com.coding.hackerearth;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheUnlucky13 {
    static final int MOD = 1000000009;

    public static void main ( String[] args ) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(reader.readLine());

            for (int i = 0 ; i < T ; i++) {
                int N = Integer.parseInt(reader.readLine());
                long result = countStrings(N);
                System.out.println(result);
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static long countStrings ( int N ) {
        if (N == 0) {
            return 1;
        }

        long prevNo13 = 1; // number of strings of length N-1 without '13' at the end
        long result = 10; // number of strings of length N without '13' at the end

        for (int i = 2 ; i <= N ; i++) {
            long newResult = (10 * result - prevNo13 + MOD) % MOD;
            prevNo13 = result;
            result = newResult;
        }

        return result;
    }
}
