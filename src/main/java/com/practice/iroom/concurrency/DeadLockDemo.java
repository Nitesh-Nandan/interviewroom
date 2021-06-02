package com.practice.iroom.concurrency;

class DeadLockResource {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void doOperationTypeA () {
        synchronized (lock1) {
            System.out.println("TypeA is acquiere Lock 1");
            synchronized (lock2) {
                System.out.println("TypeA is acquiere Lock 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void doOperationTypeB () {
        synchronized (lock2) {
            System.out.println("TypeB is acquiere Lock 1");
            synchronized (lock1) {
                System.out.println("TypeB is acquiere Lock 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLockResource rs = new DeadLockResource();
        Thread th1 = new Thread(()->{
            while (true) {
                rs.doOperationTypeA();
            }
        });
        Thread th2 = new Thread(()->{
            while (true) {
                rs.doOperationTypeB();
            }
        });
        th1.start();th2.start();
    }
}
