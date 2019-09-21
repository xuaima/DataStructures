package com.atguigu.sparsearray;


import java.util.Scanner;

/**
 * @author xuaima
 * @create 2019-09-14 7:22
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue1 queue = new ArrayQueue1(3);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            String key = scanner.next();
            switch(key){
                case "s":
                    queue.showQueue();
                    break;
                case "a":
                    System.out.println("输入一个数");
                    int num = scanner.nextInt();
                    queue.addQueue(num);
                    break;
                case "g":
                    try {
                        int queue1 = queue.getQueue();
                        System.out.println("取出"+queue1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "h":
                    try {
                        int i = queue.headQueue();
                        System.out.println("头数据是"+i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    flag=false;
                    System.out.println("程序退出");
                    break;
            }
        }
    }
}


//数组模拟队列
class ArrayQueue1 {
    //数组的最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //模拟队列的数组
    private int[] arr;

    public ArrayQueue1(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列尾的位置
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[++rear] = n;//先赋值，在后移
    }

    //获取出队列的数据
    public int getQueue() {
        if (isEmpty()) {
            //因为有返回值不能直接return，用抛异常结束方法
            throw new RuntimeException("队列空");
        }
        return arr[++front];//先后移再取值
    }

    //显示队列中所有的数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("空");
        }
        return arr[front+1];
    }

}























