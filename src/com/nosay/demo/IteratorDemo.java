package JavaSE.src.com.nosay.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add("abc");
        list.add(4);
        // 迭代器循环
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list.remove(1); // 报错，指针错乱
            System.out.println(iterator.next());
        }
        // ListIterator给出了iterator.remove()的实现，能够在迭代的时候删除元素
        // 通过移动lastRet和cursor指针来实现遍历与删除
        // while循环：listIterator作用域更大，不太好，建议用for循环
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.remove();
            System.out.println(listIterator.next());
        }
        // 推荐用for循环，iter作用域更小
        for (ListIterator iter = list.listIterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
        // 增强for循环，常用。只有实现Iterable接口才能使用增强for循环
        for (Object i : list) {
            System.out.println(i);
        }
    }
}
