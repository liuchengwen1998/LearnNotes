package com.lcw.javaBasic.thread;

/*
Thread和Runnable是什么关系：
    Thread是实现了runnable接口的类，使用run支持多线程
    因类的单一继承原则，推荐多使用Runnable接口

如何给run（）方法传参数：
    构造函数传参
    成员变量传参
    回调函数传参

如何处理线程的返回值：
    主线程等待法
    使用Thread类中的join（）方法阻塞当前线程以等待子线程处理完毕
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Mythread mythread1 = new Mythread("Thread-1");
        Mythread mythread2 = new Mythread("Thread-2");
        Mythread mythread3 = new Mythread("Thread-3");
        Mythread mythread4 = new Mythread("Thread-4");
        mythread1.start();
        mythread2.start();
        mythread3.start();
        mythread4.start();
    }
}
