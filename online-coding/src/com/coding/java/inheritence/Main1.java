package com.coding.java.inheritence;

class A {
    public void print() {
        System.out.println("A");
    }
}

class B extends A {
    public void print() {
        System.out.println("B");
    }
}

public class Main1 {
    public static void main(String[] args) {
        A obj = new B();
        obj.print();
    }
}
