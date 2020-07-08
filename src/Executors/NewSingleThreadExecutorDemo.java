package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSingleThreadExecutorDemo {
    public static class TaskA implements Runnable{
    @Override
    public void run() {
        System.out.println("AAA");
    }
}

    public static class TaskB implements Runnable{
        @Override
        public void run() {
            System.out.println("BBB");
        }
    }

    public static class TaskC implements Runnable{
        @Override
        public void run() {
            System.out.println("CCC");
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Thread(new TaskA()));
        executor.execute(new Thread(new TaskB()));
        executor.execute(new Thread(new TaskC()));
    }
}
