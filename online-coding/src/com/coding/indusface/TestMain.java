package com.coding.indusface;

import java.util.Arrays;

public class TestMain {

    public static void main ( String[] args ) {
//        int [] array = new int [] {90, 23, 5, 109, 12, 22, 67, 34};
//        quickSort(array,0,array.length-1);
//        System.out.println(Arrays.toString(array));


//        String s = new String("Indusface");
//        String s1 = "Indusface"
//
    }

    private static void quickSort ( int[] array , int low , int high ) {
        if(low<high){
            int pindex= partition(array,low,high);
            quickSort(array,low,pindex-1);
            quickSort(array,pindex+1,high);

        }
    }

    private static int partition ( int[] array , int low , int high ) {
        int pivot = array[high];
        int i = low -1;
        for (int j = low ; j <high  ; j++) {
            if(array[j]<pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp= array[i+1];
        array[i+1]= array[high];
        array[high] =temp;
        return  i+1;
    }

}
