package com.coding.java.inheritence;

class A5 {
    public void print () {
        System.out.println("A");
    }
}

class B5 extends A5 {
    public void print () {
        System.out.println("B");
    }
}

class C5 extends B5 {
    public void print () {
        System.out.println("C");
    }
}

public class Main5 {
    public static void main ( String[] args ) {
        extracted();
        extracted2();
        extracted3();
    }

    private static void extracted () {
        A5 obj = new C5();
        obj.print();
    }

    private static void extracted3 () {
        A4 objA = new B4();
        B4 objB = (B4) objA;
    }

    /**
     * In this line of code, an object `obj` of type `A5` is being instantiated,
     * and it is referencing an instance of class `C5`. This is possible because
     * of polymorphism in Java, where a reference variable of a superclass type
     * can refer to an object of a subclass type. However, to make this work, class `C5`
     * must be a subclass of class `A5` or must implement the interface `A5` if `A5` is an interface.
     */
    private static void extracted2 () {
        A5 objA = new B5();
        C5 objC = (C5) objA;
        objC.print();
    }
}
