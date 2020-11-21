package src.algorithm.code03;

public class Code04_BiggerThanRightTwice {

    // 数组中找到右边 * 2都比他小的数的个数
    public static int biggerTwice(int[] arr) {
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
        int ans = 0;
        // windowR从M + 1开始, 滑到第一个*2比左边指针小的位置停下, 指针不回退
        int windowR = M + 1;
        for (int i = L; i <= M; i++) {
            // windowR滑到第一个比左边数大的左边停下
            while (windowR <= R && (arr[windowR] << 1) < arr[i]) {
                windowR++;
            }
            ans += (windowR - M + 1);
        }

        int help[] = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int i = 0;
        while (p1 < M && p2 < R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 < M) {
            help[i++] = arr[p1++];
        }
        while (p2 < R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return ans;
    }
}
