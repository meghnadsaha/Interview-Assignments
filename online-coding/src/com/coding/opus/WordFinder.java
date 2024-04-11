package com.coding.opus;

public class WordFinder {

    public static boolean isWordVerticallyPresent(char[][] grid, String word) {
        int n = grid.length;
        // Check forward direction
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]);
            }
            if (sb.toString().contains(word)) {
                return true;
            }
        }
        // Check reverse direction
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                sb.append(grid[j][i]);
            }
            if (sb.toString().contains(word)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'a', 's', 't', 'd', 'v'},
                {'f', 'r', 'e', 'k', 'l'},
                {'s', 'r', 'n', 'g', 'y'},
                {'f', 'e', 'd', 'm', 'c'},
                {'s', 'd', 'g', 't', 'y'}
        };
        char[][] grid2 = {
                {'a', 'd', 'f', 'd', 'v'},
                {'f', 'n', 'e', 'k', 'l'},
                {'s', 'i', 'h', 'g', 'y'},
                {'f', 'f', 'd', 'm', 'c'},
                {'s', 'd', 'g', 't', 'y'}
        };
        String word1 = "tend";
        String word2 = "find";
        System.out.println("Word 'tend' present in grid1: " + isWordVerticallyPresent(grid1, word1));
        System.out.println("Word 'find' present in grid2: " + isWordVerticallyPresent(grid2, word2));
    }
}
