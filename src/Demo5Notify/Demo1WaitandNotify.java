package Demo5Notify;

/*
等待唤醒案例：线程之间的通信
    创建一个顾客线程（消费者）：告知老板要的包子种类和数量，调用wait方法，放弃cpu的执行权限，进入waitting状态（无限等待）
    创建一个老板线程（生产者）：花了s秒准备包子，准备好之后，调用notify方法，唤醒顾客吃包子
注意：
    顾客和老板的线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行。
    同步使用的锁对象必须是唯一的
    只有锁对象才能够调用wait和notify方法

 */
public class Demo1WaitandNotify {
    public static void main(String[] args) {
        //保证锁对象唯一
        Object o = new Object();

        //创建一个消费者线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //保证等待和唤醒的线程只能有一个在执行，需要使用同步技术
                    synchronized (o){
                        System.out.println("告知老板包子的种类和数量。");
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子已做好。");
                        System.out.println("==============================");
                    }
                }

            }
        }.start();

        //创建一个老板的线程（生产者）
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //程序睡眠5s
                    try {
                        //耗时5s做包子
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o){
                        System.out.println("老板五秒钟之后做好包子，告知顾客包子好了");
                        o.notify();
                    }
                }


            }
        }.start();
    }
}
