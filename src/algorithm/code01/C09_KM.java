package src.algorithm.code01;

public class C09_KM {

    // 给一个数组, 一个数出现K次, 另一个数出现M次, K<M, 找出这个数
    public static int km(int[] arr, int k, int m) {
        // 1. 准备一个32大小的数组
        int[] t = new int[32];
        // 2. 遍历数组, 把每个位上为1的累加起来, 相当于桶
        for (int item: arr) {
            for (int i = 0; i < 32; i++) {
                // 往右移动i位, 如果结果是1, 那就证明该位为1
                if (((item >> i) & 1) != 0){
                    t[i]++;
                }
            }
        }
        // 3. 处理结果, 如果第i位上的总数模M != 0, 那么这个出现K次的数该位为1, 反之为0
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                // 把每一位都填充好 00000 | 00101 = 00101 相当于把1写进去
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 3, 1, 3, 3, 1, 1, -1};
        int k = 2;
        int m = 3;
        System.out.println(km(arr, 2, 3));
    }
}
