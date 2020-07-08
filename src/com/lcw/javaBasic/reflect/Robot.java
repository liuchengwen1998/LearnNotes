package com.lcw.javaBasic.reflect;

public class Robot {
    private String name;

    public void sayHi(String helloSentence){
        System.out.println(helloSentence + "  " + name);
    }

    private String throwHello(String string){
        return "hello: " + string;
    }
}
