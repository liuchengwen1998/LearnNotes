package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolDemo {
    public static class ThreadA implements Runnable {
        @Override
        public void run() {
            System.out.println("当前线程名称："+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0; i<10; i++) {
            final int index = i;
            System.out.println(index);
            try {
                Thread.sleep(index * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.execute(threadA);
        }
        executor.shutdown();
    }
}
