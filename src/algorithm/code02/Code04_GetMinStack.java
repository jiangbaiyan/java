package src.algorithm.code02;

import java.util.Stack;

public class Code04_GetMinStack {

    // 实现一个最小值栈, 存在getMin方法
    public static class MinStack {

        public Stack<Integer> stackMin; // 最小值栈, 与数据栈同步弹出.
        public Stack<Integer> stackData; // 数据栈, 和普通栈一样

        public MinStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        // 入栈,  但是压入的之后只有比栈顶元素小才压入最小值栈, 否则重新压入栈顶元素
        public void push(int newNum) {
            // 如果最小值栈为空, 直接push
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.stackMin.peek()) { // num小于等于最小值栈顶元素, push这个num, 保证题目约束
                this.stackMin.push(newNum);
            } else {
                // 如果比最小值栈顶大, 那么重复push最小值栈顶元素, 为的就是弹出的时候能够同步
                this.stackMin.push(this.stackMin.peek());
            }
            this.stackData.push(newNum);
        }

        // 出栈, 两个栈同步弹出
        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("栈空, 无法弹出元素");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        // 获取栈中最小值
        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("栈空, 无法弹出元素");
            }
            return this.stackMin.peek();
        }
    }
}
