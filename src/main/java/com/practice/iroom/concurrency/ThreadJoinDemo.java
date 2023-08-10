package com.practice.iroom.concurrency;

public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            System.out.println("It Started for Running");
            for(int i=100000;i>0;i--);
        }, "Our Thread");


        th1.start();
        th1.join();
        System.out.println("I have waited for completions");
    }
}
