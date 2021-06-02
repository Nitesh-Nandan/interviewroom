package com.practice.iroom.practice;

public class InterruptUnderstanding {

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(()->{
            try {
                System.out.println("Created thread is going to sleep");
                Thread.sleep(20000);
            } catch (InterruptedException ex) {
                System.out.println("Thread is interrupted");
            }
            System.out.println("Hello Nitesh");
        });

        th1.start();
        System.out.println("Main thread is going to sleep");
        Thread.sleep(2000);
//        th1.interrupt();
    }
}
