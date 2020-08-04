package JavaSE.src.com.nosay;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // HashSet：由HashMap实现，哈希表实现。增删改查速度快，但是无序
        Set set = new HashSet();
        set.add("123");
        set.add("1");
        set.add(true);
        System.out.println(set);
        // TreeSet：由TreeMap实现，红黑树实现。树所有节点数据类型必须一样，因为内部需要排序过程，数据类型不一样没法排序
        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add("123");
        System.out.println(treeSet);
    }
}
