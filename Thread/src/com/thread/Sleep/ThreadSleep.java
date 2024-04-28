package com.thread.Sleep;

public class ThreadSleep implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(Thread.currentThread().getName() + "---" + i + "\n");
        }
    }
}

/*
* 详解try catch finally的使用
    public class Example {
        public static void main(String[] args) {
            try {
                int[] numbers = {1, 2, 3};
                System.out.println(numbers[5]);  // 这里会抛出 ArrayIndexOutOfBoundsException，因为索引5超出数组界限。
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("发生错误：数组索引超界");
            } finally {
                System.out.println("这段代码无论是否发生异常都会执行");
            }
        }
    }
 */