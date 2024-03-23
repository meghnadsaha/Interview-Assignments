package com.coding.rsystems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CsvSerializer {

    public static String serializeObject(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder csv = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            csv.append(value).append(",");
        }

        return csv.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        List<Object> objects = new ArrayList<>();
        objects.add(new Person("John", 30));
        objects.add(new Car("Toyota", "Camry", 2010));

        for (Object obj : objects) {
            String csv = serializeObject(obj);
            System.out.println(csv);
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Car {
        private String make;
        private String model;
        private int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }
}
