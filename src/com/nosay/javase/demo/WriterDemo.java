package src.com.nosay.javase.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) {
        File file = new File("writer.txt");
        Writer writer = null;
        try {
             writer = new FileWriter(file);
             writer.write("jiangbaiyan");
             writer.write("蒋佰言");
             writer.flush(); // 如果没有close，必须调用flush写入磁盘
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close(); // close会自动调用flush
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
