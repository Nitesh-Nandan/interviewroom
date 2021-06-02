package com.practice.iroom.concurrency;

import java.util.LinkedList;

class PCSharedClass {
    private final int capacity = 2;
    private int counter = 0;
    LinkedList<Integer> list = new LinkedList<>();

    public void producer() {
        while (true) {
            synchronized (this) {
                while (list.size() == capacity) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producer is running");
                list.add(counter++);
                notify();
            }
        }
    }

    public void consumer() {
        while (true) {
            synchronized (this) {
                if(list.size()==0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumer consuemed: " + list.removeFirst());
                notify();
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        PCSharedClass pc = new PCSharedClass();
        Thread producer = new Thread(pc::producer);
        Thread consumer = new Thread(pc::consumer);
        producer.start(); consumer.start();
    }
}
