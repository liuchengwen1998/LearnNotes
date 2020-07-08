package Demo4ThreadSafe;

import org.omg.CORBA.TRANSACTION_MODE;

public class Runableimpl implements Runnable {
    //定一个多线程共享的票源
    private int ticket = 100;

    //设置线程任务
    @Override
    public void run() {
        //重复买票，使用死循环
        while (true){
            if (ticket>0){
                //提高安全问题出现的概率，让程序睡眠
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //票存在，卖票
                System.out.println(Thread.currentThread().getName()+"--->正在卖第"+ticket+"张票");
                ticket--;
            }
        }


    }
}
