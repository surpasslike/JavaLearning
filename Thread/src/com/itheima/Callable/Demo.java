package com.itheima.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable对象
        MyCallable mc = new MyCallable();

        // 创建FutureTask
        FutureTask<String> ft = new FutureTask<>(mc);

        // 创建一个线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 使用线程池执行FutureTask
        executor.execute(ft);

        // 获取执行结果，这将阻塞主线程直到任务完成
        String s = ft.get();

        System.out.println(s);

        // 关闭线程池
        executor.shutdown();
    }
}