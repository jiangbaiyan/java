package src.javase.demo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    // HashMap: 线程不安全，效率高
    // Hashtable：线程安全
    public static void main(String[] args) {

        // static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
        // HashMap初始容量为2的n次幂，有以下原因：
        // 1. 方便进行&操作，以替代区域操作提高效率
        // 2. 在扩容操作中，只需要看二进制前一位是0或者1即可（16 -> 32只需要看第5位。如果该位为1，则需移动；否则还在原来的位置）
        // 3. 在链地址法长度超过8的时候，这样退化成链表了，会转成红黑树
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        Integer a = map.get("c");
    }
}
