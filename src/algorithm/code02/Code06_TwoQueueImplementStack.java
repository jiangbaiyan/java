package src.algorithm.code02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 两个队列实现一个栈
public class Code06_TwoQueueImplementStack {

    public Queue<Integer> help;

    public Queue<Integer> queue;

    public Code06_TwoQueueImplementStack() {
        this.queue = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public void push(int num) {
        this.queue.offer(num);
    }

    public int pop() {
        // 把queue里的数据倒入到另一个queue中, 只留下最后一个元素, 那就是要弹出的元素
        while (queue.size() > 1) {
            this.help.offer(queue.poll());
        }
        int ans = this.queue.poll();
        // 交换引用
        Queue<Integer> tmp = queue;
        this.queue = this.help;
        this.help = tmp;
        return ans;
    }

}
