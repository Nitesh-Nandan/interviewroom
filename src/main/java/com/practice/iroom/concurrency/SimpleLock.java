package com.practice.iroom.concurrency;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SimpleLock implements Lock {
    private boolean isLocked = false;
    @SneakyThrows
    @Override
    public synchronized void lock() {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long l, TimeUnit timeUnit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
