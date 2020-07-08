package Demo3Thread.createdThread;

//创建一个Thread的子类
/*
获取线程的名称：
    1、使用thread的getname（）方法获取
    2、可以先获取到当前正在执行的线程，使用线程中的getname（）方法获取名称
        static Thread currentThread（）返回当前正在执行的线程对象的引用。

 */
/*
设置线程的名称：
    1、使用线程中的setname方法
    2、创建一个带参数的构造方法，参数传递线程的名称，调用父类的带参构造方法，把线程名称传递给父类，让父类给子线程起一个名字。

 */
public class MyThread extends Thread {
    //重写Thread中的run（）方法，设置线程任务（开启线程要做什么）
    @Override
    public void run() {
        //获取线程的名称
//        String name = getName();
//        System.out.println(name);
        System.out.println(Thread.currentThread().getName());
//        for (int i=0;i<20;i++){
//            System.out.println("run:"+i);
//        }
    }

    public MyThread(){}
    public MyThread(String name){
        super(name);
    }
}
