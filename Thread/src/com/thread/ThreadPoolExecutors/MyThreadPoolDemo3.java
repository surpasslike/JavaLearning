package com.thread.ThreadPoolExecutors;

import com.thread.Runnable.MyRunnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo3
{
    //参数1:核心线程数量
    //参数2:最大线程数
    //参数3:空闲线程最大存活时间
    //参数4:时间单位
    //参数5:任务队列
    //参数6:创建线程工厂
    //参数7:任务的拒绝策略

    public static void main(String[] args)
    {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.submit(new MyRunnable());
        threadPoolExecutor.submit(new MyRunnable());
        threadPoolExecutor.shutdown();
    }
}