package src.algorithm.code03;

public class Code02_SmallSum {

    // 最小和问题. 某个位置上左边所有比他小的数都累加起来. 如[3, 1, 4, 3], 返回0, 0, 4, 1
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // 可以把视角转换一下, 某个数左边比他小累加起来, 就是找某个数右边比他大的数有几个, 然后累加自身
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);

        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int help[] = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0; // 拷贝左组的时候产生小和, 小和的数量是R - p2 + 1个小和
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < arr.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
}
