package com.thread.DeadLock;

/*概述:
线程死锁是指由于两个或者多个线程互相持有对方所需要的资源，导致这些线程处于等待状态，无法前往执行

什么情况下会产生死锁:
资源有限
同步嵌套
*/
public class Demo {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (object1) {
                    synchronized (object2) {
                        System.out.println("first");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (object2) {
                    synchronized (object1) {
                        System.out.println("second");
                    }
                }
            }
        }).start();
    }
}
