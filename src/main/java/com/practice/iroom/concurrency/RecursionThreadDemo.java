package com.practice.iroom.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class FunTest {
    final private ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    public void fun() {
        lock.lock();
        System.out.println("Counter is: " + counter++);
        try {
            Thread.sleep(20000);
            System.out.println("Lock is released");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
    public void print() {
        try {
            System.out.println(lock.isHeldByCurrentThread());
            if(lock.tryLock(25, TimeUnit.SECONDS)) {
                System.out.println("Lock is acquired");
            }
            else {
                System.out.println("Couldn't get the lock");
            }
            System.out.println(lock.isHeldByCurrentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}

public class RecursionThreadDemo {

    public static void main(String[] args) {
        FunTest ts = new FunTest();
        new Thread(ts::print).start();
        new Thread(ts::fun).start();

//        new Thread(ts::print).start();
    }
}
