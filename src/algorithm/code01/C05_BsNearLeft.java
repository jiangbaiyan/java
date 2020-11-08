package src.algorithm.code01;

public class C05_BsNearLeft {

    // 有序数组中，找>=某个数最左侧的位置
    // 如[1, 2, 2, 3, 4] 找到 >= 1的最左位置，即1
    public static int bsNearLeft(int[] arr, int num) {
        if (arr == null) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        int mid;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (num <= arr[mid]) {
                R = mid - 1;
                index = mid;
            } else if (num > arr[mid]) {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4};
        System.out.println(bsNearLeft(arr, 2));
        System.out.println(bsNearLeft(arr, 9));
    }
}
