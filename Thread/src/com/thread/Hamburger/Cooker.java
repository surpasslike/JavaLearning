package com.thread.Hamburger;

/*
 * 生产者类(Cooker):实现Runnable接口,重写run()方法,设置线程任务
 * 1.判断是否有包子,决定当前线程是否执行
 * 2.如果有包子,就进入等待状态;如果没有包子,继续执行生产包子
 * 3.生产包子之后,更新桌子上包子状态,唤醒消费者消费包子
 * */
public class Cooker implements Runnable
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
                    if (!Desk.flag)
                    {//如果桌子上没有包子
                        //生产包子
                        System.out.println("厨师正在生产包子");
                        Desk.flag = true;
                        Desk.lock.notifyAll();
                    } else
                    {//如果桌子上有包子,就等待
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