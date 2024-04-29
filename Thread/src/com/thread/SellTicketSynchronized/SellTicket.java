package com.thread.SellTicketSynchronized;

public class SellTicket implements Runnable {
    private int ticket = 100;
    private Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {//对可能有安全问题的代码加锁,多个线程必须使用同一把锁
                //t1进来后,就会把这段代码给锁起来
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //窗口1正在出售第100张票
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票");
                    ticket--;
                }
            }
            //t1在这里出来,这段代码的锁被释放
        }
    }
}