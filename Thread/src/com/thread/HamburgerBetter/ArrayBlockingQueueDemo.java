package com.thread.HamburgerBetter;

import java.util.concurrent.ArrayBlockingQueue;

/*
    阻塞队列(BlockingQueue)的核心方法:

    put(anObject): 将参数放入队列,如果放不进去会阻塞

    take(): 取出第一个数据,取不到会阻塞
*/
public class ArrayBlockingQueueDemo
{
    public static void main(String[] args) throws Exception//throws Exception是在告诉编译器本方法不处理异常,避免报错
    {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

        queue.put("Hello");

        System.out.println(queue.take());
        System.out.println(queue.take());//这个取不到,发生了阻塞

        System.out.println("over");
    }
}
