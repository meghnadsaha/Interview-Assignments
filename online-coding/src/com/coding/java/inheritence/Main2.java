package com.coding.java.inheritence;

class A2 {
    public void print() {
        System.out.println("A");
    }
}

class B2 extends A2 {
    public void print() {
        System.out.println("B");
    }
}

public class Main2 {
    public static void main(String[] args) {
        B2 obj = new B2();
        A2 objA = obj;
        objA.print();
    }
}
