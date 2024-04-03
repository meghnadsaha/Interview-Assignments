package com.coding.java.inheritence;


class A4 {
    public void print() {
        System.out.println("A");
    }
}

class B4 extends A4 {
    public void print() {
        System.out.println("B");
    }
}

public class Main4 {
    public static void main(String[] args) {
        A4 objA = new B4();
        B4 objB = (B4) objA;
        objB.print();
    }
}

