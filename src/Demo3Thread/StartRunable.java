package Demo3Thread;

public class StartRunable {
    public static void main(String[] args) {
        DemoRunAble r1 = new DemoRunAble();
        DemoRunAble1 runAble1 = new DemoRunAble1();
//        Thread t = new Thread(r1);
        Thread t = new Thread(runAble1);
        t.start();

        for (int i = 1; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
