package com.practice.iroom.concurrency;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedReadWriteResource {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock writeLock = lock.writeLock();
    Lock readLock = lock.readLock();

    public void writer() {
        writeLock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is writing " + System.nanoTime());
        writeLock.unlock();
    }

    public void reader() {
        readLock.lock();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is reading " + System.nanoTime());
        readLock.unlock();
    }
}

public class ReaderWriterLockDemo {
    public static void main(String[] args) {
        SharedReadWriteResource rs = new SharedReadWriteResource();
        Thread w1 = new Thread(rs::writer);
        Thread w2 = new Thread(rs::writer);
        Thread w3 = new Thread(rs::writer);
        w1.setName("Writer 1"); w2.setName("Writer 2"); w3.setName("Writer 3");

        Thread r1 = new Thread(rs::reader);
        Thread r2 = new Thread(rs::reader);
        Thread r3 = new Thread(rs::reader);
        Thread r4 = new Thread(rs::reader);
        r1.setName("Reader 1");r2.setName("Reader 2");r3.setName("Reader 3");r4.setName("Reader 4");

        r1.start();r2.start();r3.start();r4.start();
        w1.start();w2.start();w3.start();
//        r1.start();r2.start();r3.start();r4.start();

    }
}
