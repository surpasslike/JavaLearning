package com.thread.SetDeamon;

/*
 * 在 Java 中，守护线程（Daemon Thread）的主要作用是为其他线程（通常是用户线程）提供服务，它通常在后台运行，如垃圾回收线程。
 * 关键特性是，当 JVM 中不存在任何用户线程时，即只剩下守护线程运行，JVM 就会自动退出。
 * 这意味着，如果所有的用户线程都结束了，守护线程不论执行到何处都将停止执行，JVM 会终止。
 * */

public class Demo {
    public static void main(String[] args) {
        SetDeamon1 setDeamon1 = new SetDeamon1();
        SetDeamon2 setDeamon2 = new SetDeamon2();

        setDeamon1.setName("一号");
        setDeamon2.setName("二号");

        //把第二个线程设置为守护线程,守护线程一般是垃圾回收线程
        //当普通线程执行完之后,那么守护线程也没有继续运行下去的必要了
        setDeamon2.setDaemon(true);

        setDeamon1.start();
        setDeamon2.start();
    }
}
