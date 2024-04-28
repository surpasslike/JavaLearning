package com.itheima.Sleep;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ThreadSleep threadSleep = new ThreadSleep();

        Thread t1 = new Thread(threadSleep);
        Thread t2 = new Thread(threadSleep);

        t1.start();
        t2.start();
    }
}