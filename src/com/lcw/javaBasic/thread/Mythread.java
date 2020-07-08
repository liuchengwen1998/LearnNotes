package com.lcw.javaBasic.thread;

public class Mythread extends Thread{
    private String name;
    public Mythread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println("Thread start :"+this.name+",i="+i);
        }
    }
}
