package src.algorithm.code04;

public class QuickSort {

    // 快排1.0
    public static void quickSortV1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        processV1(arr, 0, arr.length - 1);
    }

    public static void processV1(int[] arr, int L, int R){
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);
        processV1(arr, L, M - 1);
        processV1(arr, M + 1, R);
    }

    public static int partition(int[] arr, int L, int R) {
        if (L >= R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int less = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, less + 1, R);
                less++;
                index++;
            } else {
                index++;
            }
        }
        swap(arr, less + 1, R);
        return less + 1;
    }


    // 快排2.0
    public static void quickSortV2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        processV2(arr, 0, arr.length - 1);
    }

    public static void processV2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        processV2(arr, L, equalArea[0] - 1);
        processV2(arr, equalArea[1] + 1, R);
    }

    // 荷兰国旗问题划分。<区左边，=区中间，>区右边
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1; // 小于区边界
        int more = R; // 大于区边界。最右边的数作为划分值，直接划到大于区内部，自始至终不用动，所以不取R + 1
        int index = L;
        //  左边界碰到右边界，停
        while (index < more) {
            // 当前数比数组最右边的数小，和小于区下一个数交换，小于区右扩，index跳下一个
            if (arr[index] < arr[R]) {
                swap(arr, less + 1, index);
                less++;
                index++;
            } else if (arr[index] > arr[R]) {
                // 比最右边数大，和大于区前一个数交换，大于区左扩，index不动（因为右边大于区换过来的数还没看过）
                swap(arr, more - 1, index);
                more--;
            } else {
                // 相等，index直接跳下一个
                index++;
            }
        }
        // 别忘了，数组最右边那个数也应该划分到等于区，所以和大于区边界的那个数交换，就等于划分到了等于区，大于区的第一个数挪到了最后一个
        swap(arr, more, R);
        // 返回等于区的左右边界
        return new int[]{less + 1, more};
    }


    // 快排3.0
    public static void processV3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // 只是加了这行代码，将必现的最坏情况转为随机的，求数学期望，从而降低时间复杂度
        swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        processV3(arr, L, equalArea[0] - 1);
        processV3(arr, equalArea[1] + 1, R);
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
