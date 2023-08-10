package com.practice.iroom.concurrency;

public class DeadLockDemoNew {
    public static void main(String[] args) {
        Object lock = new Object();
        Object lock2 = new Object();

        Thread th1 = new Thread(() -> {
            System.out.println("Started " + Thread.currentThread().getName());
            synchronized (lock) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Lock Acquired by Thread " + Thread.currentThread().getName());
                }
            }
        }, "Thread1");

        Thread th2 = new Thread(() -> {
            System.out.println("Started " + Thread.currentThread().getName());
            synchronized (lock2) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock) {
                    System.out.println("Lock Acquired by Thread " + Thread.currentThread().getName());
                }
            }
        }, "Thread2");

        th1.start();
        th2.start();
    }
}
