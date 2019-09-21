package hashtable;
import java.util.Scanner;

/**
 * @author xuaima
 * @create 2019-09-19 21:25
 */
public class Hashtable {

        public static void main(String[] args) {

            //创建哈希表
            HashTab hashTab = new HashTab(7);

            //写一个简单的菜单
            String key = "";
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("add:  添加雇员");
                System.out.println("list: 显示雇员");
                System.out.println("find: 查找雇员");
                System.out.println("exit: 退出系统");

                key = scanner.next();
                switch (key) {
                    case "add":
                        System.out.println("输入id");
                        int id = scanner.nextInt();
                        System.out.println("输入名字");
                        String name = scanner.next();
                        //创建 雇员
                        Emp emp = new Emp(id, name);
                        hashTab.add(emp);
                        break;
                    case "list":
                        hashTab.list();
                        break;
                    case "find":
                        System.out.println("请输入要查找的id");
                        id = scanner.nextInt();
                        hashTab.findEmpById(id);
                        break;
                    case "exit":
                        scanner.close();
                        System.exit(0);
                    default:
                        break;
                }
            }

        }

    }



    //创建HashTab 管理多条链表
    class HashTab {
        private EmpLinkedList[] empLinkedListArray;
        private int size; //表示有多少条链表

        //构造器
        public HashTab(int size) {
            this.size = size;
            //初始化empLinkedListArray
            empLinkedListArray = new EmpLinkedList[size];
            //？留一个坑, 这时要分别初始化每个链表，因为empLinkedListArray[empLinkedListNO]调用了add方法,不能为null
            for(int i = 0; i < size; i++) {
                empLinkedListArray[i] = new EmpLinkedList();
            }
        }


        //编写散列函数, 使用一个简单取模法
        public int hashFun(int id) {
            return id % size;
        }



        //添加雇员
        public void add(Emp emp) {
            //根据员工的id ,得到该员工应当添加到哪条链表
            int empLinkedListNO = hashFun(emp.id);
            //将emp 添加到对应的链表中
            empLinkedListArray[empLinkedListNO].add(emp);

        }
        //遍历所有的链表,遍历hashtab
        public void list() {
            for(int i = 0; i < size; i++) {
                empLinkedListArray[i].list(i);
            }
        }

        //根据输入的id,查找雇员
        public void findEmpById(int id) {
            //使用散列函数确定到哪条链表查找
            int empLinkedListNO = hashFun(id);
            Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
            if(emp != null) {//找到
                System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
            }else{
                System.out.println("在哈希表中，没有找到该雇员~");
            }
        }
    }





    //表示一个雇员(存到哈希表中的一个个对象)
    class Emp {
        public int id;
        public String name;
        public Emp next; //因为是链表存储，设计一个next指针，next 默认为 null（即最后位置的Emp.next指向null）

        //有参构造器
        public Emp(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
    }



    //创建EmpLinkedList ,表示每一条链表
    class EmpLinkedList {
        //头指针，就是第一个Emp
        private Emp head; //默认null

        //添加雇员到链表
        //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
        //   因此我们将该雇员直接加入到本链表的最后即可
        public void add(Emp emp) {
            //如果是添加第一个雇员
            if(head == null) {
                head = emp;
                return;
            }
            //这个head是否为null的判断是必要的，因为下面curEmp.next，记住每次.的时候要想想这个对象是不是null

            //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
            Emp curEmp = head;
            while(true) {
                if(curEmp.next == null) {//说明到链表最后
                    break;				//先判断再后移防止空指针
                }
                curEmp = curEmp.next; //后移
            }
            //退出时，此时的curEmp.next==null,就是最后一个位置，直接将emp 加入链表
            curEmp.next = emp;
        }

        //遍历链表的雇员信息，还是通过辅助指针的后移，curEmp = curEmp.next;(=是指向的意思)
        public void list(int no) {
            if(head == null) { //说明链表为空
                System.out.println("第 "+(no+1)+" 链表为空");
                return;
            }
            System.out.print("第 "+(no+1)+" 链表的信息为");
            Emp curEmp = head; //辅助指针
            while(true) {
                System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);

                if(curEmp.next == null) {//说明curEmp已经是最后结点
                    break;          //先判断再后移，防止空指针
                }
                curEmp = curEmp.next; //后移，遍历
            }
            System.out.println();
        }

        //根据id查找雇员
        //如果查找到，就返回Emp, 如果没有找到，就返回null
        public Emp findEmpById(int id) {
            //判断链表是否为空
            if(head == null) {
                System.out.println("链表为空");
                return null;
            }
            Emp curEmp = head;
            //辅助指针
            while(true) {
                if(curEmp.id == id) {//找到
                    break;//这时curEmp就指向要查找的雇员
                }
                //没找到，判断是不是已经是最后一个
                if(curEmp.next == null) {//找到最后一个还没找到
//                    curEmp = null;
//                    break;
                    return null;
                }
                curEmp = curEmp.next;//后移
            }

            return curEmp;
        }

    }



