package com.thread.HamburgerArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Demo
{
    public static void main(String[] args)
    {
        ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<>(1);//指定了队列的容量,控制生产者和消费者之间的生产与消费速率只能为1
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(1);

        Cooker cooker = new Cooker(bd, full, empty);
        Foodie foodie = new Foodie(bd, full, empty);

        Thread cookerThread = new Thread(cooker);
        Thread foodieThread = new Thread(foodie);

        cookerThread.start();
        foodieThread.start();
    }
}

/*
 * 请注意:
 * 用 ArrayBlockingQueue 时无需额外的锁和同步控制
 * 同一个流程中要用同一个锁对象(修改前犯了错误,错用了两个独立的,而现在修改后没有用到额外的锁)
 * */


/*
    在多线程编程中，Semaphore 是一种同步辅助类，用于控制对资源的访问。它通过一定数量的"许可"来管理访问权限。
    如果许可可用，Semaphore 允许线程进入并占用一个许可；如果没有许可可用，线程将阻塞，直到某个线程释放许可或者整个线程被中断为止。

    在你的例子中，full 和 empty 这两个 Semaphore 用于管理生产者-消费者模型中的两个主要状态：

    full Semaphore：
    这个信号量表示队列中已生产且待消费的项目的数量。
    初始许可数为 0，这表示队列开始时是空的，没有任何项目可以消费。
    当生产者放入一个项目到队列中时，它会释放（release()）一个full的许可，表示队列中增加了一个可供消费的项目。
    消费者在尝试取出队列中的项目之前，需要先通过acquire()方法获取一个full许可，确保队列中确实有项目可取。

    empty Semaphore：
    这个信号量用于指示队列中的可用空间数量，以便生产者可以放入新的项目。
    如果队列的容量是N，则empty信号量初始的许可数应设置为N（在你的例子中为1），表示队列开始时有N个空位可用。
    生产者在向队列添加项目前需要获取一个empty许可，通过调用acquire()方法，确保队列有空间放入新项目。
    消费者在从队列取出一个项目后，会释放（release()）一个empty许可，表示队列中新增了一个空位。
    示例用途
    通过这种方式，full 和 empty 信号量共同协调保证：

    生产者不会在队列已满时尝试添加项目（避免生产者阻塞或覆盖数据）。
    消费者不会在队列为空时尝试取出项目（避免消费者阻塞或出错）。
    这种模式有效防止了生产者和消费者的冲突，提高了程序的稳定性和效率，是处理生产者-消费者问题的经典方法之一。
* */