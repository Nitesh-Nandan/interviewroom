package com.practice.iroom.concurrency;
class SharedResource {
    private volatile int x = 0;
    public  void  increment() {
            x++;
    }
    public  void decrement() {
        x--;
    }

    public int getX() {
        return x;
    }
}
public class ThreadProblemDemo {

    public static void main(String[] args) {
        SharedResource rs = new SharedResource();
        Thread th1 = new Thread(()->{
            for(int i=0;i< 100000;i++) {
                    rs.increment();
            }
        });

        Thread th2 = new Thread(()->{
            for(int i=0;i< 100000;i++) {
                    rs.decrement();
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(rs.getX());

    }
}
