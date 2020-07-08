package demo1;



/*
创建对象的标准格式
类名称 对象名 = new 类名称（）


匿名对象，只有右边的对象没有左边的名字和赋值运算符
new 类名称（）

匿名对象只能使用唯一的一次，下次使用只能创建新的对象
使用建议：如果确定有一个对象只需要使用唯一的一次，就可以使用匿名对象。
 */
public class Demo1Anonymous {


    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name="Tony";
        p1.showName();
        System.out.println("================");

        new Person().name = "Lucy";
        new Person().showName();

    }


}
