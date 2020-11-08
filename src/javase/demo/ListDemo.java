package src.javase.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * List：有序 重复
 */
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add(1);
        // 获取指定位置元素（体现有序）
        System.out.println(list.get(1));
        // 往指定位置插入（体现有序）
        list.set(0, "jiangbaiyan");
        // of(): 生成集合
        System.out.println(List.of(1, 2, 3, 4));
    }
}
