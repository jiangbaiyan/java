package src.algorithm.code01;

public class InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // i从1开始，0~i有序
        // j是有序区最后一个元素，最好情况（全部升序）比选择和冒泡要好
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 2};
        insertSort(arr);
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
