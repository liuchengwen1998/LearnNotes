package SortDemo;

import java.util.Arrays;

public class Lesson7_4 {

    public static void main(String[] args) {
        // 冒泡排序调用
        int[] bubbleNums = {132, 110, 122, 90, 50};
        System.out.println("排序前：" + Arrays.toString(bubbleNums));
        selectSort(bubbleNums);
        System.out.println("排序后：" + Arrays.toString(bubbleNums));
    }
    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] nums) {
        int temp;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            System.out.print("第" + i + "次排序：");
            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * 选择排序
     */
    private static void selectSort(int[] nums) {
        int index;
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            if (index != i) {
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
            System.out.print("第" + i + "次排序：");
            System.out.println(Arrays.toString(nums));
        }
    }

}
