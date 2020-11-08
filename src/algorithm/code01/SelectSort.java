package src.algorithm.code01;

public class SelectSort {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 到数组倒数第二个元素就可以停了，因为0 ~ N - 2已经有序，最后一个肯定有序了
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 2};
        selectSort(arr);
        for (int value : arr) {
            System.out.println(value);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
