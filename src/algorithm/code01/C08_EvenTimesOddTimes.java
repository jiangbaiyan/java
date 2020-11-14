package src.algorithm.code01;

public class C08_EvenTimesOddTimes {

    // 1. arr中，只有一种数，出现奇数次
    public static void printOddTimesOne(int[] arr) {
        int eor = 0;
        //  异或就是无进位加法, n^n = 0, 所以偶数次异或完都是0, 就剩一个奇数次的数, 即0^eor = eor
        for(int item: arr) {
            eor ^= item;
        }
        System.out.println(eor);
    }

    // 如何把整形的数的最右侧1提取出来 eor & (~eor + 1), 即eor & (-eor)

    // 2. arr中，只有两种数，出现奇数次(假设为a和b)
    public static void printOddTimesTwo(int[] arr) {
        // 1. 得到a^b
        int eor = 0;
        for (int item : arr) {
            eor ^= item; // 结果: a^b
        }
        // 2. 分组, 要从a^b的结果中, 取某一位为1入手(因为a^b必然这一位其中一个为0, 另一个为1, 这样就达到了ab分离的效果), 我们就取最后一位为1
        int _eor = 0; // eor'
        int rightOne = eor & (~eor + 1);
        for (int item: arr) {
            // 只要碰见最后这一位为1的, 就异或; 反之如果这一位为0, 不管
            if ((item & rightOne) != 0) {
                _eor ^= item; // 只剩下b, b=_eor
            }
        }
        int a = eor ^ _eor; // a = (a^b)^b
        System.out.println(a + "" + _eor);
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 2, 3};
        printOddTimesOne(arr);
        printOddTimesTwo(arr);
    }
}
