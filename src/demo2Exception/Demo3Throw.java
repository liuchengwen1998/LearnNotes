package demo2Exception;

/*
    throw关键字
    作用：
        可以使用throw关键字在指定的方法中抛出指定的异常
    使用格式：
        throw new xxxException（异常产生的原因）
    注意：
        1、throw关键字必须写在方法内部
        2、throw关键字后面的new对象必须是Exception或者Exception的子类对象
        3、throw关键字抛出指定的异常对象，我们就必须处理这个异常对象。
            throw关键字后面创建的是RuntimeException或者是他的子类对象，我们可以不处理，默认交给JVM进行处理（打印异常对象。中断程序）
            throw关键后面创建的是编译异常（写代码时候的异常），我们就必须要处理这个异常，要么throws，要么使用try。。。catch
 */
public class Demo3Throw {

    /*
        定义一个方法，获取数组指定索引处的元素
        参数：
            int[] arr;
            int index;
        以后在工作中，我们必须对传递的参数的合法性进行校验
        如果参数不合法，我们就必须使用抛出异常的方式，告知方法的调用者，传递的参数有问题。

     */
    public static int getElement(int[] arr ,int index){
        /*
        我们对传递过来的数组，进行合法性校验
        如果数组值为null
        那我们就可以抛出空指针异常，告知方法的调用者
        注意：
            NullPointerException是一个运行时期的异常，我们不用处理，默认交给jvm处理
         */
        if (arr==null){
            throw new NullPointerException("传递的数字arr的值为空");
        }
        if (index<0||index>arr.length-1){
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组的范围");
        }
        int ele = arr[index];
        return ele;

    }



    public static void main(String[] args) {
//        int[] arr = null;
        int[] arr = new int[3];
        int num = getElement(arr,3);
        System.out.println(num);

    }
}
