package com.thread.HamburgerArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

class Cooker implements Runnable
{
    private final ArrayBlockingQueue<String> queue;
    private final Semaphore full;
    private final Semaphore empty;

    public Cooker(ArrayBlockingQueue<String> queue, Semaphore full, Semaphore empty)
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
                empty.acquire();  // 等待空位
                queue.put("包子");
                System.out.println("厨师做了一个包子");
                full.release();   // 通知可以消费
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}