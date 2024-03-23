package com.coding.admiral;

// Interface
interface Animal {
    void eat();
    void sleep();
}

// Superclass
class Mammal {
    void breathe() {
        System.out.println("Breathing...");
    }
}

// Subclass that extends Mammal and implements Animal
class Dog extends Mammal implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping...");
    }
}

public class Main2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.breathe();  // Inherited from Mammal
        dog.eat();      // Implemented from Animal
        dog.sleep();    // Implemented from Animal
    }
}
