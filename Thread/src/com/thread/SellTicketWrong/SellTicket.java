package com.thread.SellTicketWrong;

public class SellTicket implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) {
                //卖完了
                break;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
                System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
            }
        }
    }
}
