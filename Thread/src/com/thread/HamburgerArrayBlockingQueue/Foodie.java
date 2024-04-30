package com.thread.HamburgerArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

class Foodie implements Runnable
{
    private final ArrayBlockingQueue<String> queue;
    private final Semaphore full;
    private final Semaphore empty;

    public Foodie(ArrayBlockingQueue<String> queue, Semaphore full, Semaphore empty)
    {
        this.queue = queue;
        this.full = full;
        this.empty = empty;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                full.acquire();    // 等待有包子
                String take = queue.take();
                System.out.println("顾客把" + take + "吃了");
                empty.release();   // 通知可以生产
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}