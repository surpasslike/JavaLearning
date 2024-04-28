package com.thread.Runnable;

public class MyRunnableDemo {
    public static void main(String[] args) {
        //创建MyRunnable类的对象
        MyRunnable my = new MyRunnable();

        //创建Thread类的对象，把MyRunnable对象作为构造方法的参数
        //Thread(Runnable target)
//        Thread t1 = new Thread(my);
//        Thread t2 = new Thread(my);
        //Thread(Runnable target, String name)
        Thread t1 = new Thread(my, "坦克");
        Thread t2 = new Thread(my, "飞机");

        //启动线程
        t1.start();
        t2.start();
    }
}