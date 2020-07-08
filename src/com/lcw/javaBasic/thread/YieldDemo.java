package com.lcw.javaBasic.thread;

public class YieldDemo {
    public static void main(String[] args) {
        Runnable yieldDemo = new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i <= 10; i++){
                    System.out.println(Thread.currentThread().getName()+" - "+i);
                    if (i == 5){
                        Thread.yield();
                    }
                }
            }
        };

        Thread tA = new Thread(yieldDemo,"A");
        Thread tB = new Thread(yieldDemo,"B");
        Thread tC = new Thread(yieldDemo,"C");
        tA.start();
        tB.start();
//        tC.start();
    }
}
