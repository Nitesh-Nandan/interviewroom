package com.practice.iroom.practice;


class SequencePrinter {
    int limit;
    int curr;
    Object lock = new Object();

    public SequencePrinter(int limit) {
        this.limit = limit;
        this.curr = 1;
    }

    public void printEven() {
        while (curr <= limit) {
            synchronized (lock) {
                while (curr%2 !=0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread: " + Thread.currentThread() + " Data " + curr);
                curr = curr+1;
                lock.notify();
            }
        }
    }

    public void printOdd() {
        while (curr <= limit) {
            synchronized (lock) {
                while (curr%2 !=1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread: " + Thread.currentThread() + " Data " + curr);
                curr = curr+1;
                lock.notify();
            }
        }
    }
}
public class NumberPrinter {
    public static void main(String[] args) {
        SequencePrinter printer = new SequencePrinter(25);
        new Thread(printer::printOdd).start();
        new Thread(printer::printEven).start();
    }
}
