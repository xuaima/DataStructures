package search;

import java.util.ArrayList;

/**
 * @author xuaima
 * @create 2019-09-19 10:30
 */
public class BinarySearch {
    /**
     * @param arr   数组
     * @param left  左边界
     * @param right 右边界
     * @param find  要找的数
     */
    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int find) {

        //先考虑找不到的情况，不然会死归，可以再加一个判断条件，提高效率
        if (left > right || find < arr[0] || find > arr[arr.length-1]) {
            return null;
        }

        //找到中间那个数的索引值，作为分界点
        int mid = left + (right - left) / 2;

        //如果此时刚好中间值就是要找的find,再向前后多找几个看看有没有多个相等的值
        if (find == arr[mid]) {
            //因为是有序数列，所以与find相等的值一定紧挨在这个值的左右

            //先向左挨个找，直到不等于find,或找到最左边了
            int temp = mid - 1;

            //用集合储存temp值，进这个if再创建，提高效率
            ArrayList<Integer> list = new ArrayList<>();

            while (arr[temp] == find && temp > 0) {
                list.add(temp--);
            }

            //这时记得将mid这个值也放到集合中。位置刚好在中间
            list.add(mid);

            //再向右挨个找
            temp = mid + 1;
            while (arr[temp] == find && temp < arr.length) {
                list.add(temp++);
            }
            return list;

            //中间的值不等于find时，比较大小看向左递归还是向右递归
        } else if (find < arr[mid]) {
            //向左递归，即调用自身方法，调参(当递归方法有返回值的时候，调用递归需要return语句)
            return binarySearch(arr, left, mid - 1, find);
        } else {
            //向右递归
            return binarySearch(arr, mid + 1, right, find);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        ArrayList<Integer> list = binarySearch(arr, 0, arr.length - 1, 1000);
        ArrayList<Integer> list2 = binarySearch(arr, 0, arr.length - 1, 1056645460);
        System.out.println(list);
        System.out.println(list2);
    }

}