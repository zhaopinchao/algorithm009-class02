/**
 * @author: zhaopc
 * @date: 2020-05-24 13:57
 * @description
 */
public class MyCircularDeque {

    /**
     * 直接利用双端队列实现
     */
    private int capacity;
    private int size;
    private Node head;
    private Node tail;

    private static class Node {
        private int e;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int e) {
            this.e = e;
        }
    }

    /**
     * Initialize your data structure here. Set the capacity of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.pre = head;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }
        size++;
        Node node = new Node(value);
        node.pre = this.head;
        node.next = this.head.next;

        this.head.next.pre = node;
        this.head.next = node;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }
        size++;
        Node node = new Node(value);
        node.next = this.tail;
        node.pre = this.tail.pre;

        this.tail.pre.next = node;
        this.tail.pre = node;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        Node del = this.head.next;
        this.head.next = del.next;
        this.head.next.pre = this.head;
        del = null;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        Node del = this.tail.pre;
        this.tail.pre.pre.next = this.tail;
        this.tail.pre = del.pre;
        del = null;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return this.head.next.e;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return this.tail.pre.e;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        // 设置容量大小为3
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        // 返回 true
        System.out.println(circularDeque.insertLast(1));
        // 返回 true
        System.out.println(circularDeque.insertLast(2));
        // 返回 true
        System.out.println(circularDeque.insertFront(3));
        // 已经满了，返回 false
        System.out.println(circularDeque.insertFront(4));
        // 返回 2
        System.out.println(circularDeque.getRear());
        // 返回 true
        System.out.println(circularDeque.isFull());
        // 返回 true
        System.out.println(circularDeque.deleteLast());
        // 返回 true
        System.out.println(circularDeque.insertFront(4));
        // 返回 4
        System.out.println(circularDeque.getFront());
    }
}
