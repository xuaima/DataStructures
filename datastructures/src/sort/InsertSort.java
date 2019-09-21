package sort;

import java.util.Arrays;

/**
 * @author xuaima
 * @create 2019-09-18 8:25
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr); //调用插入排序算法


        System.out.println(Arrays.toString(arr));


    }

    public static void insertSort(int[] arr) {
        int insertVal;
        int inserIndex;
        for (int i = 1; i < arr.length; i++) {
            inserIndex = i - 1;
            insertVal = arr[i];
            while (inserIndex >= 0 && insertVal < arr[inserIndex]) {
                arr[inserIndex + 1] = arr[inserIndex]; //将insertIndex的数据往后复制一位
                inserIndex--;   //insertIndex下标前移一位，insertVal继续与前一位比较
                // 直到<不成立或跟arr[0]比较完结束循环
            }
            //此时已经比较完，找到了insertVal比他前一个大后一个小的位置
            //注意这时的insertIndex做了--操作，所以插入的位置要加1
            arr[inserIndex + 1] = insertVal;
        }
    }
}