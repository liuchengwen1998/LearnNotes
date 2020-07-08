package Demo5Notify.BaoZITest;

/*
注意：
    包子铺线程和包子线程关系--》通信（互斥）
    必须同时同步技术保证两个线程只有一个执行
    锁对象必须保证唯一，可以使包子对象作为锁对象
    包子铺类和吃货类就需要把包子对象作为参数传递进来
        1、需要在成员位置创建一个包子变量
        2、使用带参数构造方法，为这个包子变量赋值
 */
public class BaoZiPu extends Thread {

    //需要在成员位置创建一个包子变量
    private BaoZI baoZI;

    //使用带参数构造方法，为这个包子变量赋值
    public BaoZiPu(BaoZI baoZI) {
        this.baoZI = baoZI;
    }

    //设置线程任务（run）：生产包子
    @Override
    public void run() {
        //定义一个变量
        int count = 0;
        //让包子铺一直生产包子
        while (true){
            synchronized (baoZI){
                if (baoZI.flag==true){
                    //调用wait方法进入等待状态
                    try {
                        baoZI.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //被唤醒之后执行，包子铺生产包子
                //增加一些趣味性：交替生产两种包子
                if (count%2==0){
                    //生产 薄皮三鲜馅包子
                    baoZI.pi = "薄皮";
                    baoZI.xian = "三鲜馅";
                }else {
                    //生产 冰皮 牛肉大葱馅
                    baoZI.xian = "牛肉大葱馅";
                    baoZI.pi = "薄皮";
                }
                count++;
                System.out.println("包子铺正在生产："+baoZI.pi+baoZI.xian+"包子");

                //生产包子需要三秒
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                //包子铺生产好了包子
                //修改包子的状态为true
                baoZI.flag = true;
                //唤醒吃货线程，让吃货线程吃包子
                baoZI.notify();
                System.out.println("包子铺已经生产好了包子："+baoZI.pi+baoZI.xian+"包子，吃货可以吃了");
        }

        }
    }
}
