package src.com.nosay.javase.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {
        // 原始实现
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        });
        // lanmbda
        new Thread(() -> {
            System.out.println("running");
        }).start();
        //
        List<String> list = Arrays.asList("java", "php");
        Collections.sort(list, (a, b) -> a.length() - b.length());
        list.forEach(System.out::println);
    }
}
