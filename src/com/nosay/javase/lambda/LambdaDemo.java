package src.com.nosay.javase.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        List<String> list = Arrays.asList("java", "php");
        Collections.sort(list, (a, b) -> a.length() - b.length());

        Callable<String> c = () -> "jiangbaiyan";

        list.forEach(System.out::println);

        // stream
        String[] strs = {"a", "b"};
        String str = "abcf";
        IntStream chars = str.chars();
        chars.forEach(System.out::println);

        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(System.out::println);
    }
}
