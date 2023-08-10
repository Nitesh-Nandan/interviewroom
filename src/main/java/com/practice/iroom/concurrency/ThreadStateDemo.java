package com.practice.iroom.concurrency;

public class ThreadStateDemo {
    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            try {
                Thread.sleep(2);
                for(int i=100000; i>0; i--);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread1");
        th1.start();
        while (true) {
            Thread.State state = th1.getState();
            System.out.println(state); {
                if(state == Thread.State.TERMINATED) {
                    break;
                }
            }
        }
    }
}
