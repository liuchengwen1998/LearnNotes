package demo2Exception;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo4 {


    public static void main(String[] args) {

        ArrCopy();
    }

    public static void ArrCopy(){


        int[] arr1 = {2, 8, 13, 11, 6, 7};
        System.out.println(Arrays.toString(arr1));

        for (int i = 0 ; i < arr1.length;i++){
            for (int j=0;j<arr1.length-i-1;j++){
                if (arr1[j]>arr1[j+1]){
                    int temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(arr1));

        int[] arr = {2, 8, 13, 11, 6, 7};
        System.out.println("排序前：" + Arrays.toString(arr));
        for (int i = 0; i<arr.length;i++){
            int index = i ;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j]<arr[index]){
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            System.out.println("排序中：" + Arrays.toString(arr));
        }
        System.out.println("排序后：" + Arrays.toString(arr));
        int[] arr2 = {1, 3, 4, 5};
// Arrays.binarySearch() 使用二分法查询某值


        int index = Arrays.binarySearch(arr2, 5);
        System.out.println(index);

    }


    public static void test01(){
        Integer[] arr = {2, 3, 6, 7, 9};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
// 方式二：for each
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println("=============");


        for (Integer i : list){
            System.out.println(i);
        }

        System.out.println("=========java8=========");
        Arrays.asList(list).forEach(x -> System.out.println(x));
    }
}
