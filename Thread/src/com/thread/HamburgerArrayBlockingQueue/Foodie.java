package com.thread.HamburgerArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie implements Runnable
{
    private final ArrayBlockingQueue<String> foodieQueue;

    private final Object lock = new Object();

    public Foodie(ArrayBlockingQueue<String> queue)
    {
        this.foodieQueue = queue;
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (lock)
            {
                if (!foodieQueue.isEmpty())
                {
                    String take = null;
                    try
                    {
                        take = foodieQueue.take();
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                    System.out.println("顾客把" + take + "吃了");
                    break;
                } else
                {
                    try
                    {
                        lock.wait();
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}