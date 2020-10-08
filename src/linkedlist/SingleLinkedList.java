package linkedlist;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author litblue
 * @version 1.0.0
 * @time 2020/9/22  16:29
 *
 * 单链表的 插入，删除，查询操作
 * 链表中数据以 int 型为例
 *
 */
public class SingleLinkedList implements Serializable {

    /** 头节点 */
    private transient Node head = null;
    /** 链表大小 */
    transient int size = 0;

    /**
     * 结点
     */
    public static class Node {
        private final int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        public int getData(){
            return data;
        }
    }

    /**
     * 创建新结点
     * @param value 值
     * @return 创建好的结点
     */
    public static Node createNode(int value){
        return new Node(value, null);
    }

    /**
     * 1）表头插入
     * 2）逆序插入
     *
     * @param value 插入值
     */
    public void insertToHead(int value){
        Node newNode = createNode(value);
        // 非空链表，
        // 新结点的next指向head，新结点作为头结点
        if (head != null){
            newNode.next = head;
        }
        head = newNode;
    }

    /**
     * 1） 表尾插入
     * 2） 顺序插入
     * @param value 插入值
     */
    public void insertTail(int value){
        Node newNode = createNode(value);

        // 空链表，可以插入新的结点作为head
        if (head == null){
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    /**
     * 根据结点删除
     *
     * @param p  结点
     */
    public void deleteByNode(Node p){
        if (p == null || head == null) {
            throw new NoSuchElementException();
        }
        if (p == head){
            head = head.next;
            return;
        }

        Node q = head;
        // 遍历到p的前一个结点
        while ( q!=null && q.next != p){
            q = q.next;
        }
        q.next = p.next;
    }

    /**
     * 可重复删除指定value值的结点
     * @param value
     */
    public void deleteByValue(Integer value){
       if (head == null){
           throw new NoSuchElementException();
       }

       // 如果头结点就是要删除的值
       if (head.next != null && head.data == value){
           head = head.next;
       }

       Node q = head;
       while (q != null){
           if (q.next.data == value){
                q.next = q.next.next;
           }
           q = q.next;
       }
    }

    /**
     * 判断是不是 回文
     * @return
     */
    public boolean palindrome(){
        if (head == null){
            return false;
        }

        Node p = head;
        Node q = head;
        // 只有一个元素
        if (p.next == null){
            return false;
        }



        return true;
    }

    /**
     * 链表逆转
     */
    public Node reverseLinkedList(Node p){
        Node pre = null;
        Node q = head;
        Node next = null;

        while (q != p){
            next = q.next;

            q.next = pre;
            pre = q;
            q= next;
        }

        q.next = pre;
        return q;
    }

    /**
     * 打印
     */
    public void print(){
        Node p = head;
        while (p != null){
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 主函数
     * @param args args
     */
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        int[] data = new int[]{12,34,45,65,767,67,68,65};

        // 测试添加
        for (int datum : data) {
            singleLinkedList.insertTail(datum);
        }

        // 测试 根据值 重复删除
        singleLinkedList.deleteByValue(65);

        // 打印
        singleLinkedList.print();
    }
}
