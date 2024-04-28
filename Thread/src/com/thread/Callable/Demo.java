package com.thread.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*创建了一个 FutureTask，然后将其作为一个 Runnable 传递给 Thread 对象。然后，你手动启动这个 Thread*/
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();  // 创建一个Callable对象，这个对象包含你想要线程执行的任务

        FutureTask<String> ft = new FutureTask<>(mc);  // 将Callable对象封装成FutureTask，FutureTask是一个包装器，它同时实现了Runnable和Future接口

        Thread t1 = new Thread(ft);  // 创建一个Thread对象，将FutureTask作为任务传递给它，FutureTask的Runnable特性使得它可以作为Thread的任务

        // 先启动线程
        t1.start();  // 启动线程t1，线程t1开始执行FutureTask中的Callable对象的call方法

        // 然后获取结果，这将阻塞主线程直到线程t1的计算完成
        String s = ft.get();  // 阻塞当前线程（主线程），等待FutureTask的计算结果，完成后返回结果

        System.out.println(s);  // 打印出Callable任务返回的结果
    }
}
