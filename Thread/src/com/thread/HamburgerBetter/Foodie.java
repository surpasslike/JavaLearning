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
