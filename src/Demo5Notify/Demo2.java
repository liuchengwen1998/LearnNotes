package Demo5Notify;

/*

    进入到timewaiting（等待计时）有两种方式
    1、使用sleep（long m）方法,在毫秒值结束之后，线程唤醒之后进入到Runable/Bolcked状态
    2、使用wait（long m），在毫秒值结束之后，还没有背notify唤醒，就会自动醒来，线程唤醒之后进入到Runable/Bolcked状态

    唤醒方法：
        notify唤醒单个线程
        notifyAll唤醒此对象监视器上的所有线程
 */
public class Demo2 {
    public static void main(String[] args) {

        Object o = new Object();

        //创建一个消费者线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //保证等待和唤醒的线程只能有一个在执行，需要使用同步技术
                    synchronized (o){
                        System.out.println("顾客1。告知老板包子的种类和数量。");
                        try {
                            o.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("顾客1。包子已做好。");
                        System.out.println("==============================");
                    }
                }

            }
        }.start();

        //创建一个消费者线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //保证等待和唤醒的线程只能有一个在执行，需要使用同步技术
                    synchronized (o){
                        System.out.println("顾客2。告知老板包子的种类和数量。");
                        try {
                            o.wait(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("顾客1。包子已做好。");
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
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o){
                        System.out.println("老板五秒钟之后做好包子，告知顾客包子好了");
//                        o.notify();
                        o.notifyAll();
                    }

                }


            }
        }.start();
    }
}
