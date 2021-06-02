package com.practice.iroom.comparator;

import java.util.*;

class Car implements Comparable{
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }

    @Override
    public int compareTo(Object o) {
        Car obj = (Car) o;
        return name.compareTo(obj.name);
    }

    public int getPrice() {
        return price;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("ABC" , 100);
        carList.add(new Car("Dezire", 100));
        carList.add(new Car("BMW", 1000));
        carList.add(new Car("Skoda", 500));
        carList.add(new Car("Jaguar", 1500));

        Collection<Car> cars = Collections.unmodifiableCollection(carList);
        cars.add(car1);


        Collections.sort(carList);
        for(Car car: carList) {
            System.out.println(car);
        }

        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car car, Car t1) {
                return (car.getPrice() - t1.getPrice());
            }
        });
        for(Car car: carList) {
            System.out.println(car);
        }
    }
}
