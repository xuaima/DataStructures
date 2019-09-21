package test;

import java.util.Arrays;

/**
 * @author xuaima
 * @create 2019-09-19 16:34
 */
public class FibonacciSearch {

    //先写一个方法获取斐波那契数组（非递归方法）
    //定义一个斐波那契数组的长度（可以更改）
    public static int maxSize = 20;

    public static int[] fibArr() {
        int[] F = new int[maxSize];
        F[0] = 1;
        F[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F;
    }


    //斐波那契查找算法,非递归的方法（递归和非递归的区别在于传参）

    /**
     * @param arr  待查找数组
     * @param find 要查找的数
     * @return 找到的在数组中的索引值，如果找不到返回-1
     */
    public static int fibonacciSearch(int[] arr, int find) {
        //跟二分查找一样，定义左边界，右边界，中间边界
        int left = 0;
        int right = arr.length - 1;
        int mid ; //目的是不断更新mid = low + f[k - 1] - 1,要得到k的值
        int k = 0;
        int[] F = fibArr(); //得到一个长度为maxSize的斐波那契数列，如果不够就增大maxSize的值
        int[] temp ; //定义一个临时数组用来存放arr中的数据,temp数组的长度为F[k]-1

        //获取斐波那契分割值k
        //增加k值，直到temp的长度大于等于arr的长度
        while (F[k] -1 < arr.length) {
            k++;
        }

        //利用Arrays工具类把arr中的数据复制到temp中，并将后面的用最大的数补齐
        temp = Arrays.copyOf(arr, F[k]-1);
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        //这时，要查找的数列temp和k值都准备好了，开始写查找方法（同二分类型）

        while (left <= right) {

            //得到mid的值
            mid = left + F[k - 1] - 1;

            //注意因为是用新数组temp进行查找，所以当find == temp[mid]时，要判断这个mid索引
            // 是arr中的还是temp中的，即mid<=right和mid>right
            if (find == temp[mid]) {
                if (mid <= right) {
                    return mid;
                } else {  //即mid>right时，最大就取到right就可以了
                    return right;
                }
            } else if (find < temp[mid]) {
                right = mid - 1;    //向左继续找，左边界不变，重置右边界
                k = k - 1;    //变更k的值即更新mid的值
                            // F[k] = F[k-1] + F[k-2],拿左边，懂得都懂
            } else {
                left = mid + 1;
                k = k - 2;  //F[k] = F[k-1] + F[k-2]，拿右边
            }
        }
        return -1;  //如果不进while循环，即left>right的情况，没找到，返回-1
    }

//    实现方式2：写一个方法获取斐波那契函数
//    public static int F(int n) {
//        if (n == 1) {
//            return 1;
//        } else if (n == 2) {
//            return 1;
//        } else {
//            return F(n - 1) + F(n - 2);
//        }
//    }

    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibonacciSearch(arr,1000));// 0
    }

}
