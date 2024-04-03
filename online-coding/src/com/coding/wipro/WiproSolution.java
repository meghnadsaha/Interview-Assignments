package com.coding.wipro;

public class WiproSolution {
    public static int solution ( String S ) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(0) == S.charAt(S.length() - 1)) {
                count++;
            }
            S = S.substring(1, S.length()) + S.substring(0, 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("abbaa"));  // Output: 3
        System.out.println(solution("aaaa"));   // Output: 4
        System.out.println(solution("abab"));   // Output: 0
    }
}
