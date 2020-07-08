package Demo4ThreadSafe.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
出现了线程安全的问题
卖出了重复的票和不存在的票

解决线程安全的问题，第三种方案：使用lock锁
    lock接口中的方法：
        lock（）获取锁
        unlock（）释放锁
    使用步骤：
        1、在成员位置创建一个Reentrantlock对象
        2、在可能会出现安全问题的代码前调用lock接口中的lock方法获取锁
        3、在可能出现线程安全的代码后调用lock接口中的unlock方法释放锁
 */
public class Runableimpl implements Runnable {
    //定一个多线程共享的票源
    private int ticket = 100;

    //在成员位置创建一个Reentrantlock对象

    Lock lock = new ReentrantLock();

    //设置线程任务
    @Override
    public void run() {
        //重复买票，使用死循环
        while (true) {
            lock.lock();
            if (ticket > 0) {
                    //提高安全问题出现的概率，让程序睡眠
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName() + "--->正在卖第" + ticket + "张票");
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        //3、在可能出现线程安全的代码后调用lock接口中的unlock方法释放锁
                        lock.unlock();//无论程序是否出现异常，获取的lock锁都会释放掉
                    }

                //票存在，卖票


            }


        }
    }

    /*
    定义一个同步方法
    同步方法也会吧方法内部的代码给锁住
    只让一个线程执行
    同步方法的锁对象是谁？
    就是实现类对象 new Runableimpl（）
    也就是谁调用方法就是谁（this）
     */
    public  void payTicket(){
        if (ticket > 0) {
//                    //提高安全问题出现的概率，让程序睡眠
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

            //票存在，卖票
            System.out.println(Thread.currentThread().getName() + "--->正在卖第" + ticket + "张票");
            ticket--;
        }
    }
}
