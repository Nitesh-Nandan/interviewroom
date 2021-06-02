package com.practice.iroom.concurrency;

import java.util.concurrent.*;


class SResource {
    public synchronized void print() {
        System.out.println("Hello World");
        printAgain();
        System.out.println("Done");
    }
    public synchronized void printAgain() {
        System.out.println("Printed..");
    }
}

public class SyncCallHierarchyDemo {
    public static void main(String[] args) {
        SResource sr = new SResource();
        new Thread(sr::print).start();

//        Future
    }
}
