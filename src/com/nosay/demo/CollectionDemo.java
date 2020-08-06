package JavaSE.src.com.nosay.demo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection: 无序 重复
 */
public class CollectionDemo {

    public static void main(String[] args) {
        // ArrayList会初始大小为10，当长度不够会自动进行1.5倍扩容操作，
        Collection collection = new ArrayList();
        // add(): 添加元素，注意隐含自动装箱过程
        collection.add(1);
        collection.add(true);
        System.out.println(collection);
        // add(): 指定索引位置添加元素
        ((ArrayList)collection).add(0, "jiangbaiyan");
        // addAll: 整体添加另一个集合元素
        // clear: 清空集合
        collection.clear();
        // contains(): 是否包含元素
        // containsAll(): 是否整体包含另一集合
        collection.contains("a");
        // isEmpty(): 集合是否为空
        collection.isEmpty();
        // remove(): 删除元素
        collection.remove("e");
        // retainAll(): a与b做交集，结果集赋值给a，如果a被改变返回true，否则返回false
        // size(): 返回当前集合大小
    }
}
