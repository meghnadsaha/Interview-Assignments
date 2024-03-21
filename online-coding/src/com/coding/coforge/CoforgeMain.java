package com.coding.coforge;

//StringSort
public class CoforgeMain {


    private static void merge ( char[] arr , int left , int middle , int right ) {
        int n1 = middle - left + 1;
        int n2 = right - middle;


        char leftArray[] = new char[n1];
        char rightArray[] = new char[n2];

        for (int i = 0 ; i < n1 ; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0 ; j < n2 ; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[j];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }


    }

    private static void mergeSort ( char[] arr , int left , int right ) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr , left , middle);
            mergeSort(arr , middle + 1 , right);

            merge(arr , left , middle , right);

        }
    }

    public static void main ( String[] args ) {

        String str = "erjsoghawe";

        char arr[] = str.toCharArray();
        System.out.println("Given array is");

        extracted(arr);
        System.out.println("Sorted array is");

        mergeSort(arr , 0 , arr.length - 1);

        extracted(arr);

    }

    private static void extracted ( char[] arr ) {
        for (int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}
