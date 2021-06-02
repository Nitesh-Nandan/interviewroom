package com.practice.iroom.self;

class SPrinter {
    private final int limit;
    private  int counter;
    private final int threadCount;

    public SPrinter(int limit, int threadCount) {
        this.limit = limit;
        this.threadCount = threadCount;
        this.counter = 1;
    }

    public void printer(final int val) {
        synchronized (this){
            while (counter < limit) {
                while (counter % threadCount != val) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + ":- " + counter);
                counter++;
                notifyAll();
            }
        }
    }
}

public class SequencePrinter {
    public static void main(String[] args) {
        SPrinter printer = new SPrinter(100, 5);
        Thread th1 = new Thread(()->printer.printer(1));
        Thread th2 = new Thread(()->printer.printer(2));
        Thread th3 = new Thread(()->printer.printer(3));
        Thread th4 = new Thread(()->printer.printer(4));
        Thread th5 = new Thread(()->printer.printer(0));

        th1.setName("Thread 1"); th1.start();
        th2.setName("Thread 2"); th2.start();
        th3.setName("Thread 3"); th3.start();
        th4.setName("Thread 4"); th4.start();
        th5.setName("Thread 5"); th5.start();
    }
}
