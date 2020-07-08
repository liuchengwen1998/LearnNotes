package com.lcw.javaBasic.thread;

public class ThreadTest {
    public static void attack(){
        System.out.println("Fight");
        System.out.println("Current Thread is:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
          public void run(){
              attack();
          }
        };

        System.out.println("Current main Thread is:" + Thread.currentThread().getName());

        thread.start();
        thread.join();
        thread.start();
    }
}
