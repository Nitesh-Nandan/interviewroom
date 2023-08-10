package com.practice.iroom.generics;

import java.util.*;
import java.util.stream.IntStream;

interface Employee {
     String getName();
}

class Manager implements Employee {

    @Override
    public String getName() {
        return "Manager";
    }
}

class Accountant implements Employee {
    @Override
    public String getName() {
        return "Accountant";
    }
}


public class WildCardsDemo {

    private static void printer(Collection<? extends Employee> employees) {
        employees.forEach(e -> System.out.println(e.getName()));
    }

    private static void testOps(Collection<? super Integer> list) {
        IntStream.rangeClosed(1, 10).forEach(list::add);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        List<Number> nums = new ArrayList<>();
        List<Long> longs = new ArrayList<>();

    }

    private static void test2() {
        List<Manager> managers = Arrays.asList(new Manager(), new Manager());
        List<Accountant> accountants = Arrays.asList(new Accountant(), new Accountant());
        List<Employee> managers2 = Arrays.asList(new Manager(), new Manager());

        printer(managers);
        printer(accountants);
        printer(managers2);
    }

    private static void test3() {
        List<Number> nums = new ArrayList<>();
        nums.add(100);
        testOps(nums);
        nums.add(90.93);
        System.out.println(nums);
    }
}
