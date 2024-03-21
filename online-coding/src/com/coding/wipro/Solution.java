package com.coding.wipro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public static int[] solution ( int[] A ) {
        Map<Integer, Integer> resultMap = new HashMap();
        for (int i = 0 ; i < A.length ; i++) {
            int tmp = A[i];
            while (resultMap.containsKey(tmp)) {
                tmp--;
            }
            resultMap.put(tmp , i);
        }

        int[] result = new int[A.length];
        Iterator iterator = resultMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            result[entry.getValue()] = entry.getKey();
        }
        Arrays.asList("");
        return result;
    }




    public static void main ( String[] args ) {
        int[] A = new int[]{1 , 2 , 3}, output = new int[]{1 , 2 , 3};
//        Arrays.stream(solution(A)).forEach(System.out::print);

        int[] A1 = new int[]{9 , 4 , 3 , 7 , 7}, output1 = new int[]{9 , 4 , 3 , 7 , 7};
        Arrays.stream(solution(A1)).forEach(System.out::print);

        int[] A2 = new int[]{2 , 5 , 4 , 5 , 5}, output2 = new int[]{1 , 2 , 3 , 4 , 5};
//        Arrays.stream(solution(A2)).forEach(System.out::print);
    }
}

