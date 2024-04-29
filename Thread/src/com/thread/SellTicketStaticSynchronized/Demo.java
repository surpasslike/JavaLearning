package com.thread.SellTicketStaticSynchronized;


public class Demo {
    public static void main(String[] args) {
        SellTicket t = new SellTicket();
        Thread t1 = new Thread(t, "窗口一");
        Thread t2 = new Thread(t, "窗口二");

        t1.start();
        t2.start();
    }
}