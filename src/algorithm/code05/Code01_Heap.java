package src.algorithm.code05;

public class Code01_Heap {

    public static class MyMaxHeap {
        public int[] heap;
        public int limit;
        public int heapSize;

        public MyMaxHeap(int limit) {
            this.limit = limit;
            this.heapSize = 0;
            this.heap = new int[limit];
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            this.heap[heapSize] = value;
            this.heapInsert(this.heap, heapSize);
            heapSize++;
        }

        public int pop() {
            // 大根堆第一个就是答案
            int ans = this.heap[0];
            // 维护堆
            swap(this.heap, heapSize - 1, 0);
            heapSize--;
            // 下沉
            heapify(this.heap, 0, heapSize);
            return ans;
        }

        // 用户新加进来的数，目前已经到了index位置，要依次往上移动
        public void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        // 从index往下看，不断下沉，直到两个孩子都比index数大或者没孩子了，停
        public void heapify(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            // 有左孩子的时候，进行循环。但不一定有右孩子，需要判断
            while (left < heapSize) {
                // largest存储较大的那个数的下标
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left; // 比孩子
                largest = arr[largest] > arr[index] ? largest : index; // 孩子较大者和父亲比
                if (largest == index) { // 如果三者比完还是index下标没变化，那么说明该结束了
                    break;
                }
                // 走到这里，index肯定需要挪位置
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
