package com.coding.opus;


public class OpusMain {


    public static boolean isWordVerticallyPresent ( char[][] grid , String word ) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate over each column
        for (int col = 0 ; col < cols ; col++) {
            // Check forward direction
            if (checkVertical(grid , word , col , 0 , 1)) {
                return true;
            }
            // Check backward direction
            if (checkVertical(grid , word , col , rows - 1 , -1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkVertical ( char[][] grid , String word , int col , int startRow , int step ) {
        int wordIndex = 0;
        int rows = grid.length;

        // Iterate over rows in the specified direction
        for (int row = startRow ; row >= 0 && row < rows ; row += step) {
            // If current character matches, move to the next character in word
            if (grid[row][col] == word.charAt(wordIndex)) {
                wordIndex++;
                // If all characters of word are matched, return true
                if (wordIndex == word.length()) {
                    return true;
                }
            } else {
                // If characters do not match, reset word index
                wordIndex = 0;
            }
        }

        return false;
    }


    public static void main ( String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        char[][] grid1 = {
                {'t' , 's' , 't' , 'd' , 'v'} ,
                {'e' , 'r' , 'e' , 'k' , 'l'} ,
                {'n' , 'r' , 'n' , 'g' , 'y'} ,
                {'f' , 'e' , 'd' , 'm' , 'c'} ,
                {'s' , 'd' , 'g' , 't' , 'y'}
        };
        boolean isWordVerticallyPresent = isWordVerticallyPresent(grid1 , "tend");
        System.out.println("Word 'tend' present in grid1: " + isWordVerticallyPresent);

        char[][] grid2 = {
                {'a' , 'd' , 'f' , 'd' , 'v'} ,
                {'f' , 'n' , 'e' , 'k' , 'l'} ,
                {'s' , 'i' , 'h' , 'g' , 'y'} ,
                {'f' , 'f' , 'd' , 'm' , 'c'} ,
                {'s' , 'd' , 'g' , 't' , 'y'}
        };
        boolean isWordVerticallyPresent2 = isWordVerticallyPresent(grid2 , "find");
        System.out.println("Word 'tend' present in grid1: " + isWordVerticallyPresent2);

    }
}