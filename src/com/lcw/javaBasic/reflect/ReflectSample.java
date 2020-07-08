package com.lcw.javaBasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<Robot> rc = (Class<Robot>) Class.forName("com.lcw.javaBasic.reflect.Robot");
        Robot robot = rc.newInstance();
        System.out.println("Class name is " + rc.getName() );

        /*
        获取对象所有方法和属性的方法（包括private，但不包括继承和实现的）：getDeclaredMethod（）
        如果方法的修饰符为protected/private 请用， getDeclaredMethod 方法，为 public 请用 getMethod 方法 ！
         */
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);
        Object o = getHello.invoke(robot,"Bob");
        System.out.println("getHello result is " + o);

        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(robot,"welcome");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot,"Allie");
        sayHi.invoke(robot,"welcome");


        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
