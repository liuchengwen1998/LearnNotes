package Demo3Thread;

public class DemoRunAble  implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("执行："+i);
        }
    }
}
