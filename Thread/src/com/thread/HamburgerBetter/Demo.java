package com.thread.HamburgerBetter;

/*
 * 需求:
 * 将Desk类中的变量,采用面向对象的方式封存起来
 * 生产者和消费者类中的构造方法接收Desk类对象,之后在run方法中进行使用
 * 创建生产者和消费者线程对象,构造方法中传入Desk类对象
 * 开启两个线程
 * */
public class Demo
{
    public static void main(String[] args)
    {
        Desk desk = new Desk();

        Cooker cooker = new Cooker(desk);
        Foodie foodie = new Foodie(desk);

        Thread cookerThread = new Thread(cooker);
        Thread foodieThread = new Thread(foodie);

        cookerThread.start();
        foodieThread.start();
    }
}
