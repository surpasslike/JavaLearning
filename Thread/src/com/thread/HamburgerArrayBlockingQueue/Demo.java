package com.thread.HamburgerArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo
{
    public static void main(String[] args)
    {
        ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<>(1);

        Cooker cooker = new Cooker(bd);
        Foodie foodie = new Foodie(bd);

        Thread cookerThread = new Thread(cooker);
        Thread foodieThread = new Thread(foodie);

        cookerThread.start();
        foodieThread.start();
    }
}