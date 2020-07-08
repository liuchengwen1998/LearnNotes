package Demo4ThreadSafe.Synchronized1;

/*
出现了线程安全的问题
卖出了重复的票和不存在的票

解决线程安全的问题，第二种方案：使用同步方法
    使用步骤：
        1、把访问共享数据的方法的代码抽取出来，放到一个方法中
        2、把方法上添加synchronized修饰符
    格式：定义方法的格式
    修饰符 synchronized 返回值类型 方法名（参数列表）{
        可能出现线程安全的问题的代码块（访问了共享数据的代码）
    }
 */
public class Runableimpl implements Runnable {
    //定一个多线程共享的票源
    private int ticket = 100;

    //创建一个锁对象
    Object object = new Object();

    //设置线程任务
    @Override
    public void run() {
        System.out.println("this:"+this);
        //重复买票，使用死循环
        while (true) {
            payTicket();

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
    public synchronized void payTicket(){
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
