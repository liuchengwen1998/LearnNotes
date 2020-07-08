package Demo4ThreadSafe.Synchronized;

/*
出现了线程安全的问题
卖出了重复的票和不存在的票

解决线程安全的问题，第一种方案：使用同步代码块：
    synchronized(锁对象){
        可能出现线程安全的问题的代码块（访问了共享数据的代码）
    }
    注意：
        同步代码块中的锁对象可以是人意的对象
        但是我们必须保证多个线程使用的锁对象是同一个
        锁对象的作用：
            把同步代码块锁住，只让一个线程在代码块中执行
 */
public class Runableimpl implements Runnable {
    //定一个多线程共享的票源
    private int ticket = 100;

    //创建一个锁对象
    Object object = new Object();

    //设置线程任务
    @Override
    public void run() {
        //重复买票，使用死循环
        while (true) {
            //创建同步代码块
            synchronized (object) {
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


    }
}
