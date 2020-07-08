package demo2Exception;

/*
    异常产生过程中的解析（分析异常怎么产生的，如何处理异常）

 */
public class Demo2Ex {
    public static void main(String[] args) {
        //创建int类型的数组，并赋值
        int[] arr = {1,2,3};
        int num = 0;
        try {
             num = getElement(arr,3);
            System.out.println(num);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("产生异常："+e);
            System.out.println("数组长度越界");

        }


    }

    /*
        定义一个方法，获取数组指定索引处的元素
        参数：
            int[] arr;
            int index;
     */
    public static int getElement(int[] arr ,int index){
        int ele = 0;

        ele = arr[index];


        return ele;

    }


}
