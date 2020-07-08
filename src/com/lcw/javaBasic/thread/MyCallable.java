package com.lcw.javaBasic.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.sleep(5000);
        System.out.println("Task done");
        return value;
    }
}