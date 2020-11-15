package src.algorithm.code02;

public class Code01_ReverseList {

    public static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode last;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    // 翻转单链表
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        // 三指针技巧
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 翻转双向链表
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next; // 相比单链表翻转多了这个
            pre = head;
            head = next;
        }
        return pre;
    }
}
