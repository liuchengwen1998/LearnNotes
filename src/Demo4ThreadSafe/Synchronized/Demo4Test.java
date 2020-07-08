package Demo4ThreadSafe.Synchronized;

/*

模拟卖票
创建多个线程，同时开启，对共享的票进行出售

 */
public class Demo4Test {
    public static void main(String[] args) {

        //创建Runable接口的实现类对象
        Runableimpl runableimpl = new Runableimpl();
        //创建Thread类对象，构造方法中传递runable接口的实现类对象
        Thread thread1 = new Thread(runableimpl);
        Thread thread2 = new Thread(runableimpl);
        Thread thread3 = new Thread(runableimpl);
        Thread thread4 = new Thread(runableimpl);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
