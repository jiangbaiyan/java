package src.algorithm.code05;

public class Code02_HeapSort {

    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Code01_Heap.MyMaxHeap myMaxHeap = new Code01_Heap.MyMaxHeap(arr.length);
        // 构建堆
        for (int i = arr.length - 1; i >= 0 ; i--) {
            myMaxHeap.heapify(myMaxHeap.heap, i, arr.length);
        }
        int heapSize = arr.length;
        // 最大值被放到--heapSize的位置上，不动了
        swap(arr, 0, --heapSize);
        // 最后一个值被放到0位置上，然后调整堆，再交换，再调整，周而复始
        while (heapSize > 0) {
            myMaxHeap.heapify(myMaxHeap.heap, 0, heapSize);
            swap(myMaxHeap.heap, 0, --heapSize);
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
