package sort;

import java.util.Arrays;

/**
 * @author xuaima
 * @create 2019-09-18 9:36
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 10, -5, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int insertIndex;
        int insertVal;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                insertIndex = i - gap;
                insertVal = arr[i];
                while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = insertVal;
            }
        }
    }


    public static void shellSort1(int[] arr) {
        int insertIndex;
        int insertVal;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                insertIndex = i - gap;
                insertVal = arr[i];
                while (insertIndex >= 0 && arr[i] < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = insertVal;
            }
        }
    }


    public static void shellSort2(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    //移动
                    arr[j] = arr[j - gap];
                    j -= gap;

                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }
}
