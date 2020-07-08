package com.lcw.javaBasic.thread;

public class CycleWait implements Runnable {
    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        value = "we hava data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread thread = new Thread(cw);
        thread.start();
        while (cw.value == null){
            Thread.currentThread().sleep(100);
        }
        System.out.println("value:"+cw.value);
    }
}
