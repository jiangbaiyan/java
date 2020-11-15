package src.algorithm.code02;

public class Code03_RingArray {

    // 数组实现队列
    public static class MyQueue {

        private int begin;
        private int end;
        private int size;
        private int limit;
        private int[] arr;

        public MyQueue(int limit) {
            this.arr = new int[limit];
            this.begin = 0;
            this.end = 0;
            this.size = 0; // 当前队列拥有元素的数量, 利用size来解耦, 不再使用指针追赶的方法
            this.limit = limit; // 队列容量
        }

        // 获取下一个下标
        public int getNextIndex(int index) {
            return index == limit - 1 ? 0 : ++index;
        }

        // 入队
        public void enQueue(int value) {
            if (size == limit) {
                throw new RuntimeException("队列已满");
            }
            // 队列没满
            this.arr[begin] = value;
            this.begin = this.getNextIndex(begin);
            size++;
        }

        // 出队
        public int deQueue() {
            if (size == 0) {
                throw new RuntimeException("队列已空");
            }
            // 队列不空
            int ans = this.arr[end];
            this.end = this.getNextIndex(end);
            size--;
            return ans;
        }
    }


}
