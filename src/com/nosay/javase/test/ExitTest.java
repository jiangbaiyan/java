package src.com.nosay.javase.test;

import java.io.*;

public class ExitTest {
    public static void main(String[] args) {
        // 处理流，做转换
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);

        // 缓冲字符流，读取/写入数据
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        String str = "";
        try { // 或者可以写try(... = new ...)，这样就不用关闭流了
            while (!str.equals("exit")) {
                str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
                inputStreamReader.close();
                outputStreamWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
