package com.practice.iroom.practice;

class Printer {
    private int limit = 20;
    private int counter = 0;
    private Object lock = new Object();

    public void printEven() {
        while (counter < limit) {
            synchronized (lock) {
                while (counter%2 == 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Printing Even: " + counter++);
                lock.notify();
            }
        }
    }

    public void printOdd() {
        while (counter < limit) {
            synchronized (lock) {
                while (counter%2==0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("PrintingOdd: " + counter++);
                lock.notify();
            }
        }
    }
}
public class OddEvenDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread oddThread = new Thread(printer::printEven);
        Thread evenThread = new Thread(printer::printOdd);

        oddThread.start();
        evenThread.start();
    }
}