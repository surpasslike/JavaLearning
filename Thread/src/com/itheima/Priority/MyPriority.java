package com.itheima.Priority;

import java.util.concurrent.Callable;

public class MyPriority implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
        return "线程执行完毕";
    }
}