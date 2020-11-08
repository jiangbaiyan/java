package src.algorithm.code01;

public class C02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 0 ~ N - 1 第N-1个数排好序
        // 0 ~ N - 2 第N-2个数排好序
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 2};
        bubbleSort(arr);
        for (int v : arr) {
            System.out.println(v);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
