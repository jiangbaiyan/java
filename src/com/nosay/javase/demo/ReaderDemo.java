package src.com.nosay.javase.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo {

    // 字符流：对于中文汉字处理不会乱码；而字节流会乱码
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = new FileReader("abc.txt");
            try {
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1) {
                    System.out.println(chars); // 输出字符数组
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
