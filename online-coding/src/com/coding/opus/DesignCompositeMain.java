package com.coding.opus;

import java.util.ArrayList;
import java.util.List;


/**
 * To implement this, you can use a composite design pattern where Society is the composite,
 * Building is the composite, and Flat is the leaf. This way, you can easily accommodate new
 * requirements and ensure proper abstractions and encapsulation.
 */


// Component interface
interface SocietyComponent {
    void display ();
}

// Composite class for Society
class Society implements SocietyComponent {
    private String name;
    private List<SocietyComponent> buildings;

    public Society ( String name ) {
        this.name = name;
        this.buildings = new ArrayList<>();
    }

    public void addBuilding ( SocietyComponent building ) {
        buildings.add(building);
    }

    @Override
    public void display () {
        for (SocietyComponent building : buildings) {
            building.display();
        }
    }
}

// Composite class for Building
class Building implements SocietyComponent {
    private String name;
    private List<SocietyComponent> flats;

    public Building ( String name ) {
        this.name = name;
        this.flats = new ArrayList<>();
    }

    public void addFlat ( SocietyComponent flat ) {
        flats.add(flat);
    }

    @Override
    public void display () {
        for (SocietyComponent flat : flats) {
            flat.display();
        }
    }
}

// Leaf class for Flat
class Flat implements SocietyComponent {
    private String flatNumber;

    public Flat ( String flatNumber ) {
        this.flatNumber = flatNumber;
    }

    @Override
    public void display () {
        System.out.println("society-name:building-name:" + flatNumber);
    }
}

public class DesignCompositeMain {
    public static void main ( String[] args ) {
        Society society = new Society("society-1");

        Building building1 = new Building("building-1");
        building1.addFlat(new Flat("01"));
        building1.addFlat(new Flat("02"));

        Building building2 = new Building("building-2");
        building2.addFlat(new Flat("01"));
        building2.addFlat(new Flat("02"));

        society.addBuilding(building1);
        society.addBuilding(building2);

        society.display();
    }
}
