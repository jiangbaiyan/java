package src.algorithm.code03;

// 逆序对问题. 比如[4, 1, 3, 1], 0位置上有(4,1)(4,3)(4,1)三个逆序对...以此类推, 找出一共有几个逆序对
public class Code03_ReversePair {

    public static int reversePair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int help[] = new int[R - L + 1];
        int p1 = M;
        int p2 = R;
        int i = help.length - 1;
        int res = 0;
        while (p1 >= L && p2 >= M + 1) {
            res += arr[p1] > arr[p2] ? (p2 - M) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 >= M + 1) {
            help[i--] = arr[p2--];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return res;
    }
}
