package com.thread.HamburgerBetter;

public class Cooker implements Runnable
{
    private final Desk desk;

    public Cooker(Desk desk)
    {
        this.desk = desk;
    }

    //生产者:
    //1.判断桌子上是否有包子,如果有就等待,如果没有就生产
    //2.把包子放在桌子上
    //3.叫醒顾客吃

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (desk.getLock())
            {
                if (desk.getCount() == 0)//今天的10个名额全部卖完了
                {
                    break;
                } else//今天的10个名额还没有卖完
                {
                    if (!desk.isFlag())//如果桌子上没有包子
                    {
                        System.out.println("厨师正在生产包子");
                        desk.setFlag(true);//做好包子
                        desk.getLock().notifyAll();//包子做好了,现在叫醒顾客
                    } else//如果桌子上有包子,厨师就wait
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