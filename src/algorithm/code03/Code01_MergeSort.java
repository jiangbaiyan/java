package src.algorithm.code03;

public class Code01_MergeSort {

    // 归并排序(递归版)
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L; // 左组起点
        int p2 = M + 1; // 右组起点
        int i = 0; // 辅助数组起点
        // 左右都不越界, 谁小拷贝谁
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 右组越界, 左组还有剩余没拷贝
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        // 左组越界, 右组还有剩余没拷贝
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        // 拷贝回原数组
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
