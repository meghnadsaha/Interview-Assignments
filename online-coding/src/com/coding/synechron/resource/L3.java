package com.coding.synechron.resource;

import java.awt.*;

interface Shape {
    void draw ();
}


class Circle implements Shape {

    @Override
    public void draw () {
        System.out.println("Drawing circle");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw () {
        System.out.println("Drawing rectangle");
    }
}


class ShaprFactory {

    public Shape createShape ( String shapeType ) {
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}

class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton () {
    }

    public static synchronized Singleton getInstance () {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage () {
        System.out.println("hello i am a singleton class");
    }

}


public class L3 {
    public static void main ( String[] args ) {
//        ShaprFactory factory = new ShaprFactory();
//
//        Shape circle = factory.createShape("circle");
//        circle.draw();
//
//        Shape rectangle = factory.createShape("rectangle");
//        rectangle.draw();

//        Singleton singleton = Singleton.getInstance();
//        singleton.showMessage();

    }
}
