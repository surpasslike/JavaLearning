package com.thread.ThreadPoolExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//创建一个指定多线程数量的线程池
public class MyThreadPoolDemo2
{
    public static void main(String[] args)
    {
        //这个参数不是初始值,而是类似于数组的最大值
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        System.out.println("infront:threadPoolExecutor.getPoolSize()==" + threadPoolExecutor.getPoolSize());

        executorService.submit(() ->
        {
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });

        executorService.submit(() ->
        {
            System.out.println(Thread.currentThread().getName() + "执行了");
        });

        System.out.println("behind:threadPoolExecutor.getPoolSize()==" + threadPoolExecutor.getPoolSize());

        executorService.shutdown();
    }
}