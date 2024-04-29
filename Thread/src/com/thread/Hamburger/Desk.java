package com.thread.Hamburger;

/*
 * 桌子类(desk):定义表示包子数量的变量,定义锁对象变量,定义标记桌子上有无包子的变量
 * */
public class Desk
{

    //当数据是共享的，对象不需要修改，只需要使用，不用存储在对象中，就可以定义为静态的

    //定义一个标记.true有包子,false没有
    public static boolean flag = false;

    //包子的总数量
    public static int count = 10;

    //锁对象
    public static final Object lock = new Object();

}

