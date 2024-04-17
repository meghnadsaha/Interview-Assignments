package com.coding.indusface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Round2 {
    public static void main ( String[] args ) {

        int[] mainArray = {7 , 8 , 2 , 6 , 22 , 23};
        int[] subArray1 = {8 , 22 , 23};
        int[] subArray2 = {7 , 6 , 8};

        System.out.println(isValidSubArray(mainArray , subArray2));


    }


    private static boolean isValidSubArray ( int[] mainArray , int[] subArray1 ) {
        int mainIndex = 0;
        int subIndex = 0;

        while (mainIndex < mainArray.length && subIndex < subArray1.length) {
            if (mainArray[mainIndex] == subArray1[subIndex]) {
                subIndex++;
            }
            mainIndex++;
        }
        return subIndex == subArray1.length;
    }
}
