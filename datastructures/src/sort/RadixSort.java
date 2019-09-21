package sort;

import java.util.Arrays;

/**
 * @author xuaima
 * @create 2019-09-18 23:11
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {

        //拿到数组中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //拿到最大数的位数
        int maxLength = (max + "").length();

        //定义一个二维数组，10个桶，每个桶容量都是arr.length
        int[][] buckets = new int[10][arr.length];

        //定义一个储存每个桶里实际数据个数的数组，长度为10
        int[] counts = new int[10];

        //循环先按个位再按十位...
        for (int i = 0; i < maxLength; i++) {

            //把遍历当前数组
            for (int j = 0; j < arr.length; j++) {
                //拿到每个数的个位（或十位、百位...）
                int digit = (int) (arr[j] / Math.pow(10, i) % 10);
                //跟据这个位数放入到对应的桶，并计数在counts数组中（一一对应）
                buckets[digit][counts[digit]] = arr[j];
                counts[digit]++;   //0,1,2...  counts数组中存的形式为{0,1,0,1,2,....}，对应10个桶各自的实际个数
            }

            //数据都存到桶中了，再按顺序拿出到数组中
            int index = 0;
            //从第一个桶开始遍历
            for (int j = 0; j < buckets.length; j++) {
                //对照counts数组，有数据的遍历，没数据的跳过
                if (counts[j] != 0) {
                    //把第j个桶里的数据拿出来
                    for (int k = 0; k < counts[j]; k++) {
                        arr[index++] = buckets[j][k]; //第j个桶的第k个
                    }
                }
                //每次添加完成后，将counts数组清零（不用清零buckets，因为旧数会被覆盖，没被覆盖的counts数组中不会记录）
                counts[j] = 0;
            }
        }
    }
}
