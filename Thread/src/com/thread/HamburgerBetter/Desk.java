package com.thread.HamburgerBetter;

public class Desk
{
    //true是有包子,false是没有
    private boolean flag;

    //今天的包子总数
    private int count;

    //锁的对象
    private final Object lock = new Object();

    public Desk()
    {
        this(false, 10);//初始状态,桌子上没有包子,今天准备卖10个包子
    }

    public Desk(boolean flag, int count)
    {
        this.flag = flag;
        this.count = count;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public Object getLock()
    {
        return lock;
    }

    @Override
    public String toString()
    {
        return "Desk is" + " flag=" + flag + ", count=" + count + ", lock=" + lock;
    }
}