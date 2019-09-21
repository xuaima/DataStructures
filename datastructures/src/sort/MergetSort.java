package sort;

import java.util.Arrays;

/**
 * @author xuaima
 * @create 2019-09-19 1:00
 */
public class MergetSort {
    //归并的思想，分治法

    /**
     * @param arr   原始数组
     * @param left  左边递归的左边界
     * @param mid   左边递归的右边界
     * @param right 右边递归的右边界
     * @param temp  临时中转数组
     */
    //先写治，即合并
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //左边递归的左边界,作为指针向右一个个移动与右边数组进行比较
        int j = mid + 1;  //右边递归的左边界，作为指针一个个向右移
        int index = 0; //temp的索引位置

        //第一步
        //i和j对应的数进行比较，把左右两边的数据按规则填到temp数组中
        //当有一遍指针走完时，结束循环
        while (i <= mid && j <= right) {
            //两边指针指着的数据比较
            //注意这里是小于等于，这样能保证排序是稳定的，二者相等前面的还在前面
            if (arr[i] <= arr[j]) {
                //将小的那个数加到temp数组的index位置，然后index右移，i指针右移
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
            //用三元运算符写法最简
            //temp[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        //第二步
        //此时有可能一遍走完另一边有剩余，依次全部添加到temp中
        while (i <= mid) {
            temp[index++] = arr[i++];
        }

        while (j <= right) {
            temp[index++] = arr[j++];
        }
        //此时的temp就是一个排好序的数组，下一步复制给arr数组

        //第三步
        //重置index,从0开始
//        index = 0;
//        while (left <= right) {
//            arr[left++] = temp[index++];
//        }

        for (int k = 0; k <index ; k++) {
            arr[left+k] = temp[k];
        }


    }

    //分+合方法

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //左边递归的右边界
        int mid = (left + right) / 2; //这里最好写成left+（right - left）/2,可以防止超过int的最大范围
        //递归的出口（递归头）
        if (left != right) {
            //左边递归到最小
            mergeSort(arr, left, mid, temp);
            //右边递归到最小
            mergeSort(arr, mid + 1, right, temp);
            //调用合并方法
            merge(arr, left, mid, right, temp);
        }
    }

    public static void main(String[] args) {
        int arr[] = {8,-1,2,4, 5, 7, 1, 3, 6};
        //这里提前把temp创建好，不用放到递归中可以提高效率
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
}
