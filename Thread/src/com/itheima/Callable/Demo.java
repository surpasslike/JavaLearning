package com.itheima.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*创建了一个 FutureTask，然后将其作为一个 Runnable 传递给 Thread 对象。然后，你手动启动这个 Thread*/
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();

        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft);

        // 先启动线程
        t1.start();

        // 然后获取结果，这将阻塞主线程直到线程t1的计算完成
        String s = ft.get();

        System.out.println(s);
    }
}
