package ObjectClone;

import java.io.*;

public class LowClone {
    public static void main(String[] args) throws CloneNotSupportedException {

    }
}
class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        ParrotChild parrotChild = new ParrotChild();
        parrotChild.name = "小鹦鹉";
        Parrot parrot = new Parrot();
        parrot.name = "大鹦鹉";
        parrot.parrotChild = parrotChild;
        // 克隆
        Parrot parrot2 = (Parrot) parrot.clone();
        parrot2.name = "老鹦鹉";
        parrot2.parrotChild.name = "少鹦鹉";
        System.out.println("parrot name:" + parrot.name);
        System.out.println("parrot child name:" + parrot.parrotChild.name);
        System.out.println("parrot name 2:" + parrot2.name);
        System.out.println("parrot child name 2:" + parrot2.parrotChild.name);
    }
}
class Parrot implements Cloneable {
    public String name;
    public ParrotChild parrotChild;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Parrot bird = (Parrot) super.clone();
        bird.parrotChild = (ParrotChild) parrotChild.clone();
        return bird;
    }
}
class ParrotChild implements Cloneable {
    public String name;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
