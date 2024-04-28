package com.thread.Priority;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 优先级 1 ~ 10 , 默认值是5
        MyPriority myPriority = new MyPriority();
        FutureTask<String> ft = new FutureTask<String>(myPriority);
        Thread thread = new Thread(ft);
        thread.setName("Like Priority Name");
        thread.setPriority(10);
        thread.start();

        MyPriority myPriority2 = new MyPriority();
        FutureTask<String> ft2 = new FutureTask<String>(myPriority2);
        Thread thread2 = new Thread(ft2);
        thread2.setName("Second Priority Name");
        thread2.setPriority(1);
        thread2.start();

        System.out.println(ft.get());
        System.out.println(ft2.get());
    }
}