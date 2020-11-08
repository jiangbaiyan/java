package src.algorithm.code01;

public class C04_BsExist {

    // 查找某个元素是否存在，最简单的二分
    public static boolean bsExist(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (num < arr[mid]) {
                R = mid - 1;
            } else if (num > arr[mid]) {
                L = mid + 1;
            } else {
                return true;
            }
        }
        // 只在L<R的时候循环，L=R的时候已经跳出循环了，所以还需要判断一次
        return arr[L] == num;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4};
        System.out.println(bsExist(arr, 1));
        System.out.println(bsExist(arr, 9));
    }
}
