package ObjectClone;

public class CloneMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        // 等号赋值（对象）
        Dog dog = new Dog();
        dog.name = "旺财";
        dog.age = 5;
        Dog dog2 = dog;
        // 修改 dog2 的值
        dog2.name = "大黄";
        dog2.age = 3;

        Dog dog3 = (Dog) dog.clone();
        System.out.println(dog3.name + "，" + dog3.age + "岁");
        dog3.name = "小白";
        dog3.age = 2;
        System.out.println(dog==dog2);
        System.out.println(dog.name + "，" + dog.age + "岁");
        System.out.println(dog2.name + "，" + dog2.age + "岁");
        System.out.println(dog3.name + "，" + dog3.age + "岁");
    }

}

