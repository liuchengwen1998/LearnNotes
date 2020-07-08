package Demo5Notify.BaoZITest;

public class DemoTest {
    public static void main(String[] args) {
        //创建包子对象
        BaoZI baoZI = new BaoZI();
        //创建包子铺线程，开始生产包子
        new BaoZiPu(baoZI).start();
        //创建吃货线程，开始吃包子
        new ChiHuo(baoZI).start();

    }
}
