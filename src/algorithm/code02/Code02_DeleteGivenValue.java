package src.algorithm.code02;

public class Code02_DeleteGivenValue {

    public static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 删除指定元素, 返回链表头部
    public static Node removeValue(Node head, int num) {
        // 这道题需要注意边界条件, 如果链表头就是num, 那就要一直删
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // head来到第一个不为num的位置, 记录下这个head, 要返回的最终head
        Node cur = head;
        Node pre = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
