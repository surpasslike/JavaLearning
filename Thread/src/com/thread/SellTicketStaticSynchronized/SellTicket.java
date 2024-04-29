package com.thread.SellTicketStaticSynchronized;

public class SellTicket implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if ("窗口一".equals(Thread.currentThread().getName())) {
                //同步方法
                boolean result = synchronizedMthod();
                if (result) {
                    break;
                }
            }

            if ("窗口二".equals(Thread.currentThread().getName())) {
                //同步代码块
                synchronized (SellTicket.class) {
                    if (ticket == 0) {
                        break;
                    } else {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ticket--;
                        System.out.println(Thread.currentThread().getName() + "正在卖票,还剩下" + ticket + "张票");
                    }
                }
            }
        }
    }


    private static synchronized boolean synchronizedMthod() {
        if (ticket == 0) {
            return true;
        } else {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
            System.out.println(Thread.currentThread().getName() + "这个窗口正在卖票,还剩下" + ticket + "张票");
            return false;
        }
    }
}