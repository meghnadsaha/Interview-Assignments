package com.coding.bitwisesol;

class A {
    int i;
}

public class BitwiseSol {


    public static void main ( String[] args ) {
        A a1 = new A();
        A a2 = new A();

        a1.i = 10;
        a2.i = 20;

        a1 = a2;

        a1.i = 100;
        a2.i = 200;

        System.out.println(a1.i +","+ a2.i);
    }
}
