package Demo3Thread.createdThread;

/*
线程名称：
    主线程：mian
    新线程：Thread-0 Thread-1
 */
public class Demo2getName {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("小刘");
        myThread.start();

        new MyThread("旺财").start();

        System.out.println(Thread.currentThread().getName());
    }
}
