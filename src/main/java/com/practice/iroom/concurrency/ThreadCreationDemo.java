package com.practice.iroom.concurrency;
//1. Implements Runnable interface, and pass to a new Thread Object.
//2. Extends Thread class, and create and object of that class

class RunnableThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Runnable Thread is Running");
        }
    }
}


public class ThreadCreationDemo {
    public static void main(String[] args) {
        Thread th1 = new Thread(()->{
            int counter = 0;
            while (counter<20) {
                System.out.println("Thread 1 is running");
                counter++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread th2 = new Thread(()->{
            int counter = 0;
            while (counter<20) {
                System.out.println("Thread 2 is running");
                counter++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th1.start();
//        try {
//            th1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        th2.start();
    }
}
