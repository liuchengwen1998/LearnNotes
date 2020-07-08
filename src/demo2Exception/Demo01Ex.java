package demo2Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
java.lang.Throwable:类是java语言中所有错误或异常的超类
    Exception:编译期异常，进行编译（写代码）java程序出现的问题
        RuntimeException ：运行期异常，java程序在运行时期出现的问题
    Error：错误
        错误就相当于程序得了一个无法治愈的毛病，必须修改源代码才可以正常运行。


 */
public class Demo01Ex {

    public static void main(String[] args){
        //Exception:编译时期的异常，进行编译（写代码）java程序出现的问题
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//用来格式化日期
        Date date = null;//把字符串格式的日期解析成为data格式的日期。
        try {
            date = sdf.parse("1999-0909");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        System.out.println("后续代码");*/

//        int[] arr = {1,2,3};
////        System.out.println(arr[0]);
//        try {
//            //可能会出现异常的代码
//            System.out.println(arr[3]);
//        }catch (Exception e){
//            System.out.println(e);
//        }

        /*
        Error:错误
        java.lang.OutOfMemoryError：Java heap space
        内存溢出的错误，创建的数组太大了，超出了JVM分配的内存
         */
        int[] a = new int[1024*1024*1024];


        System.out.println("后续代码");
    }


}
