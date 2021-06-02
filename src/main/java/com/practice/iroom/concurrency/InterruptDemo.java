package com.practice.iroom.concurrency;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(()-> {
            System.out.println("Thread is Running");
            while (true) {
                System.out.println("Hello world");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        th1.start();
        Thread.sleep(1000);
        th1.suspend();
        Thread.sleep(2000);
        th1.resume();

    }
}
