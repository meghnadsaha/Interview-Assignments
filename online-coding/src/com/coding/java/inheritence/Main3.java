package com.coding.java.inheritence;



class A3 {
    public void print() {
        System.out.println("A");
    }
}

class B3 extends A3 {
    public void print() {
        System.out.println("B");
    }
}

public class Main3 {
    public static void main(String[] args) {
        A3 objA = new A3();
        B3 objB = new B3();
        objA = objB;
        objA.print();
    }
}


