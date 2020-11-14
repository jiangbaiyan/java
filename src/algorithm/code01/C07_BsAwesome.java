package src.algorithm.code01;

public class C07_BsAwesome {

    // 无序数组，局部最小值问题
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        // 边界条件
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[R] < arr[R - 1]) {
            return R;
        }
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return L;
    }
}
