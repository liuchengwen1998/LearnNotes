package Demo3Thread.createdThread;

/*
创建多线程程序的第一种方式：创建Thread的子类
java。lang。Thread类：是描述线程的类，我们想要实现多线程，就必须继承Thread类
实现步骤：
    1、创建一个Thread的子类
    2、在Thread类的子类中充血Thread类中的run方法，设置线程任务（开启线程要做什么？）
    3、创建Thread的子类对象
    4、调用Thread类中的start方法，开启新的线程，执行线程的run方法

 */
public class Demo1CreatedThread {
    public static void main(String[] args) {
        //创建Thread的子类对象
        MyThread myThread = new MyThread();
        //调用Thread的start方法，开启新的线程执行run方法。
        myThread.start();
        for (int i=0;i<20;i++){
            System.out.println("main:"+i);
        }
    }
}
