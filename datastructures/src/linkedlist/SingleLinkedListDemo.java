package linkedlist;


/**
 * @author xuaima
 * @create 2019-09-15 1:36
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
    }
}

//定义 HeroNode节点
class HeroNode {
    public int no;
    public String name;
    //指向下一个链表的next域本质是也是一个node节点，对象关联
    public HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
class SingleLinkedList{
    //定义一个头结点，不存放具体的数据
    private HeroNode head=new HeroNode(0,"");

    public void addByOrder(HeroNode newHero){
        //定义一个中间变量temp,从头结点往后遍历，找到插入位置的上一个节点，
        // 执行插入：temp.next= newHero;
        HeroNode temp = head;
        if (temp.next.no>newHero.no) {

        }

    }
}

