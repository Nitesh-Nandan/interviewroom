package com.practice.iroom.collection;

import java.util.HashMap;
import java.util.Map;

class Employee {
    private String name;
    private String city;

    public Employee(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public int hashCode() {
        return 1001;
    }

    @Override
    public String toString() {
        return name + " : " + city;
    }
}

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<>();
        map.put("Hello", new Employee("Nitesh", "Dumka"));
        map.put("Hello2", new Employee("Nitesh", "Dumka"));
        System.out.println(new String("Hello").hashCode());
        System.out.println(new String("Hello2").hashCode());
        String str = null;
        System.out.println(str.hashCode());

        Map<String, Employee> cmap = new HashMap<>();
    }
}
