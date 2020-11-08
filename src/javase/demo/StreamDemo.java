package src.javase.demo;

import java.io.*;

public class StreamDemo {

    // IO流永远是相对于程序来说的。要想往程序里读数据，那么是InputStream
    public static void main(String[] args) {
        // 输入流
        InputStream inputStream = null;
        try {
            // 不带缓冲的，一个字节一个字节的读，效率较低：
            inputStream =  new FileInputStream("abc.txt");
            int ret;
            while ((ret = inputStream.read()) != -1) {
                System.out.println((char)ret);
            }
            // 带缓冲区的读，效率高
            byte[] buffer = new byte[1024];
            while ((ret = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, ret));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 输出流
        File file = new File("aaa.txt");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(99);
            outputStream.write("jiangbaiyan".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
