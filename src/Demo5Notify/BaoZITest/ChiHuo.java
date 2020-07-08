package Demo5Notify.BaoZITest;

public class ChiHuo extends Thread {

    //需要在成员位置创建一个包子变量
    private BaoZI baoZI;

    public ChiHuo(BaoZI baoZI){
        this.baoZI = baoZI;
    }

    @Override
    public void run() {
        //使用死循环，让吃货一直吃包子
        while (true){
            synchronized (baoZI){
                //对包子的状态进行判断
                if (baoZI.flag == false){
                    //吃货调用wait方法进入等待状态
                    try {
                        baoZI.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //被唤醒之后就是吃包子
                System.out.println("吃货正在吃包子："+baoZI.pi+baoZI.xian+"的包子");
                //吃货吃完包子，修改包子的状态
                baoZI.flag = false;
                //吃货唤醒包子铺线程，生产包子
                baoZI.notify();
                System.out.println("吃货已经把："+baoZI.pi+baoZI.xian+"的包子吃完了，包子铺开始生产包子");
                System.out.println("==============================================================");
            }
        }

    }
}
