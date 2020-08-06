package JavaSE.src.com.nosay.demo;

public class StringBufferDemo {

    public static void main(String[] args) {
        // stringBuffer - 线程安全，synchronized修饰方法
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1).append(1.234).append("abc").append(true);
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.length()); // 同go len()
        System.out.println(stringBuffer.capacity()); // 同go cap()

        // stringBuilder - 线程不安全，性能好
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1).append(1.234).append("abc").append(true);
        System.out.println(stringBuilder);
    }
}
