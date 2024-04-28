package com.itheima.Thread;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();

        //        my1.run();
        //        my2.run();
        my1.setName("坦克");
        my2.setName("飞机");
        //void start() 导致此线程开始执行; Java虚拟机调用此线程的run方法
        my1.start();
        my2.start();
    }
}