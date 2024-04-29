package com.thread.Hamburger;

/*
 * 测试类(Demo)里面有main方法,main方法中的代码步骤如下:
 * 创建生产者线程和消费者线程对象
 * 分别开启两个线程
 * */
public class Demo
{
    public static void main(String[] args)
    {
        /*
         * 顾客:
         * 1.判断桌子上是否有面包
         * 2.如果没有就等待
         * 3.如果有就直接吃
         * 4.吃完之后,桌子上的包子就没有了.叫醒等待的生产者继续生产,面包数量减一
         * */

        /*
         * 厨师:
         * 1.判断桌子上是否有面包
         * 2.如果有就等待
         * 3.如果没有就生产
         * 4.把面包放桌子上
         * 5.叫醒等待的顾客开吃
         * */

        Foodie foodie = new Foodie();
        Cooker cooker = new Cooker();

        Thread cookerThread = new Thread(cooker);
        Thread foodieThread = new Thread(foodie);

        foodieThread.start();
        cookerThread.start();
    }
}
