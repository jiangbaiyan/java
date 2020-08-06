package JavaSE.src.com.nosay.demo;

public class IntegerDemo {
    public static void main(String[] args) {
        int a = 10;
        Integer i = new Integer(10); // 装箱
        // valueOf 装箱
        Integer i2 = Integer.valueOf(a);
        // intValue 拆箱
        int i3 = i.intValue();
        System.out.println(a == i); // true

        // 自动装箱 等价于a1 = Integer.valueOf(100)
        Integer a1 = 100;
        Integer a2 = 100;
        Integer a3 = 200;
        Integer a4 = 200;
        System.out.println(a1 == a2); // true -128 ~ 127 缓存 地址相同
        System.out.println(a3 == a4); // false

        Integer m = 10;
        int n = m; // 自动拆箱 等价于 n = Integer.intValue(m)
        System.out.println(m == n); // true
    }
}
