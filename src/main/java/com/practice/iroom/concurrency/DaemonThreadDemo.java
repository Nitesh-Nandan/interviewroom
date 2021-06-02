package com.practice.iroom.concurrency;

public class DaemonThreadDemo {

    public static void main(String[] args) {
        Thread th1 = new Thread(()-> {
            while (true) {
                System.out.println("Lower Priority");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th2 = new Thread(()-> {
            while (true) {
                System.out.println("Higher Priority");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th1.setPriority(2);
        th2.setPriority(10);

        th1.start();
        th2.start();
//        System.out.println("Main thread finish");
    }
}
