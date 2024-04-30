package com.thread.ThreadPoolExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        //1.创建一个默认的线程池对象,池子中默认是空的,默认最多可以容纳int类型的最大值
        ExecutorService executorService = Executors.newCachedThreadPool();

        //Executors可以帮助我们创建线程池对象
        //ExecutorService可以帮助我们控制线程池

        executorService.submit(() ->
        {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        });

        Thread.sleep(1000);

        executorService.submit(() ->
        {
            System.out.println(Thread.currentThread().getName() + "在执行");
        });

        executorService.shutdown();
    }
}

/*
 * 线程池可以看做一个池子, 在池子里可以存储多个线程
 *
 * 线程池存在的意义:
 * 系统创建一个线程的成本是比较高的,因为它涉及到与操作系统的交互,当程序中需要创建大量生存期很短暂的线程时,频繁创建
 * 和销毁线程资源消耗有可能大于业务处理对系统资源的消耗,这样就有点舍本逐末了
 *
 * 针对这一情况,为了提高性能,就可以采用线程池.线程池在启动时,会创建大量的空闲线程,当我们向线程池提交任务时,线程池就会
 * 启动一个线程来执行该任务.等待任务执行完毕以后,线程不会死亡,而是再次返回到线程池中称为空闲状态,等待下一次任务的执行.
 * */

/*
 * 线程池的设计思路:
 * 1.准备一个任务容器
 * 2.一次性启动多个消费者线程
 * 3.刚开始任务容器是空的,所有线程都在wait
 * 4.直到一个外部线程向这个任务容器扔了一个"任务",就会有一个消费者线程被唤醒
 * 5.这个消费者线程取出"任务",并且执行这个任务,执行完毕后,继续等待下一次任务的到来
 * */

/*
 * 线程池-Executors默认线程池
 * 概述:JDK对线程池也进行了相关的视线.在真实企业开发中我们也很少去自定义线程池,而是使用JDK中自带的线程池.
 *
 * 我们可以使用Executors中所提供的静态方法来创建线程池
 * */