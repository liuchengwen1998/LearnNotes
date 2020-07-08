package Demo3Thread;

/*
    主线程：执行主方法的线程
    单线程程序：java程序中只有一个线程
    从main方法开始执行，从上到下依次执行
 */
public class Demo1Thread {
    /*
    JVM执行main方法，main方法会进入到栈内存
    JVM会找操作系统开辟一条main方法通向cpu的执行路径
    cpu就可以通过者条路径来执行main方法
    而这个路径有一个名字，就做main（主）线程
     */
    public static void main(String[] args) {
        Person p1 = new Person("小刘");
        p1.run();
        Person p2 = new Person("李四");
        p2.run();
    }
}
