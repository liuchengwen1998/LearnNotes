package demo1;

import java.util.Scanner;

public class Demo2Anonymous {


    public static void main(String[] args) {
        //普通使用的方式
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();

        //匿名对象的方式
//        int num = new Scanner(System.in).nextInt();
//        System.out.println("输入的是："+num);

        //使用一般写法传入参数
//        Scanner sc = new Scanner(System.in);
//        methodParam(sc);

        //使用匿名对象传递参数
//        methodParam(new Scanner(System.in));

        Scanner scanner = methodReturn();
        int n1 = scanner.nextInt();
        System.out.println("输入的是："+n1);

    }

    public static void methodParam(Scanner scanner){
        int i = scanner.nextInt();
        System.out.println("输入的是："+i);

    }

    public static Scanner methodReturn(){
        return new Scanner(System.in);
    }


}
