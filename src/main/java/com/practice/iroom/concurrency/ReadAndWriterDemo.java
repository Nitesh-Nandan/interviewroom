package com.practice.iroom.concurrency;

import java.util.concurrent.Semaphore;

class ReadWriterShared {
    private int readerCount = 0;
    private final Semaphore wrtiter = new Semaphore(1);

    public void writer() {
        try {
            wrtiter.acquire();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Writing");
            wrtiter.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void reader() {
        synchronized (this) {
            readerCount++;
            if(readerCount==1) {
                try {
                    wrtiter.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + ":- Reading");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            readerCount--;
            if(readerCount == 0) {
                wrtiter.release();
            }
        }
    }
}

public class ReadAndWriterDemo {
    public static void main(String[] args) {
        ReadWriterShared rw = new ReadWriterShared();
        Thread th1 = new Thread(rw::writer); th1.setName("Writer 1");
        Thread th5 = new Thread(rw::writer); th1.setName("Writer 2");
        Thread th6 = new Thread(rw::writer); th1.setName("Writer 3");
        Thread th7 = new Thread(rw::writer); th1.setName("Writer 4");

        Thread th2 = new Thread(rw::reader); th2.setName("Reader 1");
        Thread th3 = new Thread(rw::reader); th3.setName("Reader 2");
        Thread th4 = new Thread(rw::reader); th4.setName("Reader 3");



        th1.start();th5.start();th6.start();th7.start();
        th2.start();th3.start();th4.start();
    }
}
