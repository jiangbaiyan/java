package src.com.nosay.javase.demo;

import src.com.nosay.javase.demo.util.Person;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

// 外部比较器
public class SetDemo implements Comparator<Person> {
    public static void main(String[] args) {
        // set如何保证不重复？（自定义类型通过hashCode和equals方法去比较。先比较hashCode再比较equals）
        // HashSet：由HashMap实现，哈希表实现。增删改查速度快，但是无序
        HashSet set = new HashSet();
        set.add("123");
        set.add("1");
        set.add(true);
        // TreeSet：由TreeMap实现，红黑树实现，有序。树所有节点数据类型必须一样，因为内部需要排序过程，数据类型不一样没法排序
        // 要想排序，有两种方法：内部比较器与外部比较器：
        // 内部比较器：在自定义类中实现实现Comparable接口
        // 外部比较器：在使用的类中实现Comparator泛型接口，并且在TreeSet构造方法中传入比较器对象
        // 如果两者都有，默认优先使用外部比较器
        // 如果有compare之后就不会调用equals去判断了
        TreeSet treeSet = new TreeSet(new SetDemo());
        treeSet.add(new Person("jby", 1));
        treeSet.add(new Person("jby", 3));
        treeSet.add(new Person("jby", 2));
        System.out.println(treeSet); // age排序为：1 2 3
    }

    // 内部比较器，实现compare
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.age, o2.age);
    }
}
