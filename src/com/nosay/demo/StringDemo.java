package JavaSE.src.com.nosay.demo;

/**
 * 常量池在1.7之后移到了堆空间中
 */
public class StringDemo {
    public static void main(String[] args) {
        // 第一种方式
        String str = "abc";
        // 第二种方式
        String str2 = new String("abc");
        // 把字符串加载到常量池中（1.7后为堆）
        System.out.println(str == str2); // false
        // When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object) method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String object is returned.
        // 如果在常量池中有一个字符串字面量一摸一样的，那么intern会返回常量池中的string指针，所以接下来比较都会相等
        str2 = str2.intern();
        System.out.println(str == str2); // true
        System.out.println(str.equals(str2)); // true
    }
}
