package src.javase.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {

    public static void main(String[] args) {
        File file = new File("abc.txt");
        // 字节 -> 字符流桥梁，也叫处理流
        // 应用场景：socket网络传输一般都是字节流，所以我们程序中需要使用到字符，所以需要这个处理流做转换
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 文件输出流
            fileOutputStream =  new FileOutputStream(file);
            // 输出流写入器，需要传入一个输出流。这个功能比原本的文件输出流更强大，可以按照字符输出，是字符流与字节流的桥
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(99);
            outputStreamWriter.write("jiangbaiyan");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
