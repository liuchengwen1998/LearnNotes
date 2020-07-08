package com.lcw.javaBasic.thread;

/*
Thread和Runnable是什么关系：
    Thread是实现了runnable接口的类，使用run支持多线程
    因类的单一继承原则，推荐多使用Runnable接口
 */
public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable("runnable1");
        MyRunnable myRunnable2 = new MyRunnable("runnable2");
        MyRunnable myRunnable3 = new MyRunnable("runnable3");
        MyRunnable myRunnable4 = new MyRunnable("runnable4");
        Thread t1 = new Thread(myRunnable1);
        Thread t2 = new Thread(myRunnable2);
        Thread t3 = new Thread(myRunnable3);
        Thread t4 = new Thread(myRunnable4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
