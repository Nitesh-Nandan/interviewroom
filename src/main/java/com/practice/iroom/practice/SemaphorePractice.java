package com.practice.iroom.practice;

import java.util.concurrent.Semaphore;

class ReaderWriterSharedClass {
    private final Semaphore writer = new Semaphore(1);
    private int readerCount = 0;

    public void write() {
        while (true) {
            try {
                writer.acquire();
                System.out.println(Thread.currentThread().getName() + ":- Writing to file");
                writer.release();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void reader() {
        while (true) {
            synchronized (this) {
                readerCount++;
                if (readerCount == 1) {
                    try {
                        writer.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + ":- File is Reading");
            synchronized (this) {
                readerCount--;
                if (readerCount == 0) {
                    writer.release();
                }
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class SemaphorePractice {
    public static void main(String[] args) {
        ReaderWriterSharedClass rw = new ReaderWriterSharedClass();
        Thread writer1 = new Thread(rw::write); writer1.setName("Writer1");
        Thread writer2 = new Thread(rw::write); writer2.setName("Writer2");
        Thread reader1 = new Thread(rw::reader); reader1.setName("Reader1");
        Thread reader2 = new Thread(rw::reader); reader2.setName("Reader2");
        Thread reader3 = new Thread(rw::reader); reader3.setName("Reader3");
        Thread reader4 = new Thread(rw::reader); reader4.setName("Reader4");

        writer1.start();writer2.start();
        reader1.start();reader2.start();reader3.start();reader4.start();
    }
}
