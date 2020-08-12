package src.com.nosay.javase.demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        // 缓冲流
        // transient关键字：序列化的时候不会序列化该字段
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("abc.txt"));
            int read;
            while ((read = bufferedInputStream.read()) != -1) {
                System.out.println((char)read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
