package queue;

/**
 * @author xuaima
 * @create 2019-09-14 21:00
 */
public class CircleArratQueueDemo {

}

class CircleArray {
    //数组最大容量(实际容量=最大容量-1)
    private int maxSize;
    //指向头一个元素
    private int front = 0;
    //指向最后一个元素的后一个
    private int rear = 0;
    //模拟队列的数组，最后一个位置不存数据
    private int[] arr ;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    //展示所有(只遍历有效数据)
    public void showAll(){
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        //i从front开始遍历,遍历个数为实际个数
        for (int i = front; i <front+size(); i++) {
            System.out.println(arr[i]);
        }
    }

    public int size(){
        //当maxSize=3,front=1,rear=2时，实际个数为1个
        //当maxSize=4,front=3,rear=2时，实际个数为3个
        return (rear-front+maxSize)%maxSize;
    }

    public void add(int n){
        if (isFull()) {
            System.out.println("已满");
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }

    public int get(){
        if (isEmpty()) {
            throw new RuntimeException("队列空没得取");
        }
        int n = arr[front];
        front = (front+1)%maxSize;
        return n;
    }

    public int getHead(){
        if (isEmpty()) {
            throw new RuntimeException("队列空没得取");
        }

        return arr[front];
    }










}
