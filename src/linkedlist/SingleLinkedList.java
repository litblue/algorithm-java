package linkedlist;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
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
        private int data;
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
            head = newNode;
        } else {
            // 若为空链表，则新结点作为头结点
            head = newNode;
        }
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
     * 带头结点的 插入操作
     *
     * @param value 插入值
     */
    public void insertWithHead(int value){
        Node newNode = createNode(value);
        head.data = ++size;
        head.next = newNode;
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
        while ( q!=null && q.next != p){
            q = q.next;
        }

        if (q != null) {
            return;
        } else {
            q.next = q.next.next;
        }
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

        int[] data = new int[]{12,34,45,65,767,67,68};


        for (int datum : data) {
//            singleLinkedList.insertToHead(datum);
            singleLinkedList.insertTail(datum);
        }


        List list = new LinkedList();

        list.add(12);
        singleLinkedList.print();
    }
}
