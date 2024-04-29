package com.thread.Hamburger;

/*
 * 消费者类(Foodie):实现Runnable接口,重写run()方法,设置线程任务
 * 1.判断是否有包子,决定当前线程是否执行
 * 2.如果没有包子,就进入等待状态,如果有包子,就消费包子
 * 3.消费包子后,更新桌子上的包子状态,唤醒生产者生产包子
 * */
public class Foodie implements Runnable
{
    @Override
    public void run()
    {
        while (true)
        {
            synchronized (Desk.lock)
            {
                if (Desk.count == 0)
                {
                    break;
                } else
                {
                    if (Desk.flag)
                    {//如果桌子上有包子
                        System.out.println("顾客正在吃包子");
                        Desk.flag = false;
                        Desk.lock.notifyAll();
                        Desk.count--;
                    } else
                    {//如果桌子上没有包子,就等待
                        //使用什么对象当做锁,那么就必须用这个对象去调用等待和唤醒的方法
                        try
                        {
                            Desk.lock.wait();
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}