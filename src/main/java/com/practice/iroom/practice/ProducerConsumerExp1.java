package com.practice.iroom.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class ProducerConsumer {
    private LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;
    Random rd = new Random();

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if(list.size() == capacity) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.addLast(rd.nextInt());
                System.out.println("Producer added element");
                notify();
            }
            Thread.sleep(500);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if(list.size()==0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumer consumed:- " + list.getFirst());
                list.removeFirst();
                notify();
            }
            Thread.sleep(1500);
        }
    }
}

public class ProducerConsumerExp1 {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Runnable target;
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
