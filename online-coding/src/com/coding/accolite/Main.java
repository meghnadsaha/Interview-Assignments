package com.coding.accolite;

import java.util.ArrayList;

public class Main {
    public static void main ( String[] args ) {
        ArrayList<Integer> obj = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            obj.add(i);
        }

        changeElement(obj);

        // print arraylist using for loop
        for (Integer element : obj) {
            System.out.print(element+" ");
        }
    }

    static void changeElement ( ArrayList<Integer> obj ) {
        for (int i = 10 ; i < 20 ; i++) {
            obj.add(i);
        }

        obj = null; // This line does not affect the original reference to the ArrayList
    }
}

