package com.practice.iroom.practice;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Worker implements Runnable {
    private Queue<String> queue;
    private Object lock;
    private char tid;

    public Worker(Queue<String> queue, Object lock, char tid) {
        this.queue = queue;
        this.lock = lock;
        this.tid = tid;
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                while (!queue.isEmpty() && queue.peek().charAt(0) != tid) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (!queue.isEmpty()) {
                    System.out.println("Data is  " + queue.poll() + " and tid " + tid);
                }
                lock.notifyAll();
            }
        }
    }

}

public class StreamPrinter {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Object lock = new Object();

        queue.offer("a01");
        queue.offer("b01");
        queue.offer("c01");
        queue.offer("a02");

        List<Thread> workers = new ArrayList<>();

        for (char ch = 'a'; ch <= 'c'; ch++) {
            workers.add(new Thread(new Worker(queue, lock, ch)));
        }

        for (Thread worker : workers) {
            worker.start();
        }

        queue.offer("a03");
        queue.offer("b02");
        queue.offer("c02");
        queue.offer("a04");
    }
}
