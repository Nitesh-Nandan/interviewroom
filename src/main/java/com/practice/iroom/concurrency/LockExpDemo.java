package com.practice.iroom.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class SimpleLock2 implements Lock {
    private boolean isLocked = false;

    @Override
    public void lock() {
        synchronized (this) {
            while (isLocked) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked = true;
        }
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
    public void unlock() {
        synchronized (this) {
            isLocked = false;
            notify();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

public class LockExpDemo {
}
