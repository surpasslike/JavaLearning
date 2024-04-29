package com.thread.SellTicketSynchronized;

public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket ticket = new SellTicket();

        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
