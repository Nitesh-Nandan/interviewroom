package com.practice.iroom.collection;

import java.util.HashSet;
import java.util.Objects;

class Employee2 {
    final private String name;
    final private Integer age;

    public Employee2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Employee2 emp = (Employee2) obj;
        return Objects.equals(name, emp.name) && Objects.equals(age,emp.age);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int value = 1;

        value = value * prime + ((name==null)?0:name.hashCode());
        value = value * prime + age.hashCode();
        return value;
    }
}
public class DesignHashSetDemo {
    public static void main(String[] args) {
        HashSet<Employee2> hashSet = new HashSet<>();
        Employee2 emp1 = new Employee2("Nitesh", 25);
        Employee2 emp2 = new Employee2("Nitesh", 25);
        hashSet.add(emp1);
        hashSet.add(emp2);

        System.out.println(emp1.equals(emp2));

        System.out.println(emp1.hashCode());
        System.out.println(emp2.hashCode());

        for (Employee2 employee2 : hashSet) {
            System.out.println(employee2);
        }
     }
}
