package com.practice.iroom.self;

import java.sql.PreparedStatement;

class Printer {
    private int counter;
    private int limit;

    public Printer(int limit) {
        this.limit = limit;
    }

    public void printOdd() {
        while (counter < limit) {
            synchronized (this) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Printed by Odd thread: " + counter);
                counter++;
                notify();
            }
        }
    }
    public void printEven() {
        while (counter < limit) {
            synchronized (this) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Printed by Even thread: " + counter);
                counter++;
                notify();
            }
        }
    }
}

public class OddEvenPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer(25);
        Thread th1 = new Thread(printer::printOdd);
        Thread th2 = new Thread(printer::printEven);

        th1.start();
        th2.start();
    }
}
