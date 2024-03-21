package com.coding.synechron;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution2 ( int[] X , int S ) {
        int counter = 0;

        for (int i = 0 ; i < X.length ; i++) {
            int[] dpSum = new int[X.length];

            dpSum[i] = X[i];

            if (X[i] == S) {
                counter++;
            }

            for (int j = i + 1 ; j < X.length ; j++) {
                int sum = dpSum[j - 1] + X[j];

                dpSum[j] = sum;

                if ((double) sum / (j - i + 1) == S) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int solution ( int[] A , int S ) {

        int res = 0, sum = 0, n = A.length;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0 , 1);
        for (int val : A) {
            sum += val - S;
            if (mp.containsKey(sum)) {
                res += mp.get(sum);
            }
            mp.put(sum , mp.getOrDefault(sum , 0) + 1);
        }
        return res;
    }


    public static void main ( String[] args ) {
        int[] A = new int[]{2 , 1 , 3};int S = 2,output=3;
//        int[] A = new int[]{0 , 4 , 3 , -1}; int S = 2;
//        int[] A = new int[]{2 , 1 , 4};
//        int S = 3, output = 0;
        System.out.println(solution(A , S));
    }
}
