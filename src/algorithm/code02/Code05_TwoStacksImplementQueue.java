package src.algorithm.code02;

import java.util.Stack;

// 用两个栈实现一个队列
public class Code05_TwoStacksImplementQueue {

    public Stack<Integer> stackPush;

    public Stack<Integer> stackPop;

    public void pushToPop() {
        while (!this.stackPop.isEmpty()) {
            this.stackPop.push(this.stackPush.pop());
        }
    }

    public void enQueue(int num) {
        this.stackPush.push(num);
        this.pushToPop();
    }

    public int deQueue() {
        if (this.stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        int res = this.stackPop.pop();
        this.pushToPop();
        return res;
    }
}
