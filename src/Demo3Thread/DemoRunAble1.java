package Demo3Thread;

public class DemoRunAble1 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("helloword："+i);
        }
    }
}
