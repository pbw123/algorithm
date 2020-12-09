package main;

import java.util.LinkedList;

public class Linked<T> {

    class Node {
        private T t;
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
//            刚创建出来的结点它的下一个肯定是未知的
            this(t, null);
        }
    }

    private int size;
    private Node head;

    //创建链表
    public Linked() {
        this.head = null;
        size = 0;
    }

    //    链表长度
    public int getSize() {
        return this.size;
    }

    //    链表判断是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    //    清空链表
    public void reset() {
        this.head = null;
        this.size = 0;
    }

    //    遍历链表
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = this.head;
        while (cur != null) {
            sb.append(cur.t + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    //    在链表头部插入结点
    public void addFirst(T t) {
        Node node = new Node(t);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    //    在某个下标插入元素
    public void add(T t, int index) {
        if (index < 0 || index > this.size) {
            try {
                throw new IllegalAccessException("index is error");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (index == 0) {
            addFirst(t);
            return;
        }
//        找到前一个结点
        Node pre = this.head;
        for (int i = 0; i < index - 1; ++i) {
            pre = pre.next;
        }
        Node newNode = new Node(t);
        newNode.next = pre.next;
        pre.next = newNode;
        this.size++;
    }

    //    当我们无法知道一个结点的位于链表的哪个位置时候，只知道要插入在某个元素的前面
    public void addBeforeNode(T newNode, T oldNode) {
//        说明在头结点前插入
        if (this.head.t == oldNode) {
            addFirst(newNode);
            return;
        }
//        找到前一个结点
        Node pre = this.head;
        Node node = new Node(newNode);
        while (pre.next != null) {
            if (pre.next.t.equals(oldNode)) {
                node.next = pre.next;
                pre.next = node;
                this.size++;
                break;
            } else pre = pre.next;
        }
    }

    //    方法二：使用虚拟头结点插入元素,不用考虑是否是在头结点 插入这种情况
    public void addBeforeNode2(T newNode, T oldNode) {
//        创建虚拟头结点并指向head
        Node dummy = new Node(null, this.head);
        Node cur = dummy;
        Node node = new Node(newNode);
        while (cur.next != null) {
            if (cur.next.t.equals(oldNode)) {
                node.next = cur.next;
                cur.next = node;
                this.size++;
                break;
            } else cur = cur.next;
        }
        this.head = dummy.next;

    }

    //    在链表尾部添加结点,方法重载
    public void add(T t) {
        Node cur = this.head;
        if (cur == null) {
            addFirst(t);
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        Node newNode = new Node(t);
        cur.next = newNode;
        this.size++;
    }

    //    在链表尾部添加结点,第二种方式
    public void addLast(T t) {
        this.add(t, this.size);
    }

    //    删除头结点
    public void removeFirst() {
//        将头结点指针指向头结点的下一个结点
        this.head = this.head.next;
        this.size--;
    }

    //    删除结点
    public void remove() {
        Node cur = this.head;
        Node pre = this.head;
        if (cur == null) {
            System.out.println("没有元素可删除");
            return;
        }
//        说明删除的是头结点
        if (cur.next == null) {
            removeFirst();
            return;
        }
//        说明是最后一个结点，找到倒数第二个结点并把它的next设置为null
        while (cur != null && cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        this.size--;
    }

    //    删除指定下标的结点
    public void remove(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("index is error");
        }
//        说明删除的是头结点
        if (index == 0) {
            removeFirst();
            return;
        }
        Node cur = this.head;
        Node pre = this.head;
//        说明是最后一个结点，找到倒数第二个结点并把它的next设置为null
        if (index == this.size - 1) {
            while (cur != null && cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
            this.size--;
            return;
        }
//        找到指定下标结点的前一个结点
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        this.size--;
    }

    //    链表是否包含某个元素
    public boolean isContain(T t) {
        if (this.head == null) {
            System.out.println("空链表");
            return false;
        }
        Node cur = this.head;
        while (cur != null) {
            if (cur.t.equals(t)) {
                return true;
            } else cur = cur.next;
        }
        return false;
    }
//根据下标获取元素
    public T  get(int index){
        if (index < 0 || index > this.getSize() - 1) {
            throw new IllegalArgumentException("index is error");
        }
        Node cur=this.head;
        Node pre=this.head;
        for (int i = 0; i <= index; i++) {
            if (cur.next!=null) {
                pre=cur;
                cur=cur.next;
            }else {
                return cur.t;
            }
        }
        return pre.t;
    }

}
