package com.thread.HamburgerArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooker implements Runnable
{
    private final ArrayBlockingQueue<String> cookerQueue;

    private final Object lock = new Object();

    public Cooker(ArrayBlockingQueue<String> queue)
    {
        this.cookerQueue = queue;
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (lock)
            {
                if (cookerQueue.isEmpty())
                {
                    try
                    {
                        cookerQueue.put("包子");
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                    System.out.println("厨师做了一个包子");
                    lock.notifyAll();
                    break;
                }
            }
        }
    }
}