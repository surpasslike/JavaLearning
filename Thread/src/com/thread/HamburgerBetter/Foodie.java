package com.thread.HamburgerBetter;

public class Foodie implements Runnable
{

    private final Desk desk;

    public Foodie(Desk desk)
    {
        this.desk = desk;
    }

    @Override
    public void run()
    {
        //套路:
        //1. while(true)死循环
        //2. synchronized 锁,锁对象要唯一
        //3. 判断,共享数据是否结束. 结束
        //4. 判断,共享数据是否结束. 没有结束
        while (true)
        {
            synchronized (desk.getLock())
            {
                if (desk.getCount() == 0)
                {
                    break;
                } else
                {
                    if (desk.isFlag())//如果桌子上有包子,就准备吃
                    {
                        System.out.println("顾客开始吃");
                        desk.setFlag(false);//包子被吃后变成了false
                        desk.getLock().notifyAll();//告诉厨师包子吃完了
                        desk.setCount(desk.getCount() - 1);//今天店里的销售名额-1
                    } else
                    {
                        //没有就等待
                        //使用什么对象当做锁,那么就必须用这个对象去调用等待和唤醒的方法.
                        try
                        {
                            desk.getLock().wait();
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
