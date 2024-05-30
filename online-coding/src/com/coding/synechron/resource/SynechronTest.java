package com.coding.synechron.resource;

import java.util.*;

class Solution1 {
    public int[] solution(String[] s) {
        int n = s.length;
        int m = s[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (s[i].charAt(k) == s[j].charAt(k)) {
                        return new int[] {i, j, k};
                    }
                }
            }
        }

        return new int[0];
    }
}

public class SynechronTest {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        String[] example1 = {"abc", "bca", "dbe"};
        int[] result1 = solution.solution(example1);
        System.out.println(Arrays.toString(result1)); // Output: [0, 2, 1]

        String[] example2 = {"lzzzz", "ferz", "zdar", "fgtd"};
        int[] result2 = solution.solution(example2);
        System.out.println(Arrays.toString(result2)); // Output: [0, 1, 3] or [1, 3, 0]
    }
}
