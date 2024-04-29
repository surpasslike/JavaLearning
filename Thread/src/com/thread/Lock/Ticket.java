package com.thread.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private int ticket = 100;
    private Object obj = new Object();
    private ReentrantLock mLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                try {
                    mLock.lock();
                    if (ticket <= 0) {
                        break;
                    } else {
                        Thread.sleep(100);
                        ticket--;
                        System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mLock.unlock();
                }
            }
        }
    }
}