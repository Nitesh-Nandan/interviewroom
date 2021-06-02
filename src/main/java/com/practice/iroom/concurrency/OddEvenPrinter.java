package com.practice.iroom.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NumberPrinter {
    private int limit = 20;
    private int counter = 1;
    private final Lock lock = new ReentrantLock();

    public void printOdd() {
        while (counter < limit) {
            lock.lock();
            if (counter %2 == 1) {
                System.out.println("Printing Odd: " + counter++);
            }
            lock.unlock();
        }
    }
    public void printEven() {
        while (counter < limit) {
            lock.lock();
            if(counter % 2 == 0) {
                System.out.println("Printing Even: " + counter++);
            }
            lock.unlock();
        }
    }
}

public class OddEvenPrinter {
    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();
        Thread th1 = new Thread(np::printOdd);
        Thread th2 = new Thread(np::printEven);
        th1.start();th2.start();

    }
}
