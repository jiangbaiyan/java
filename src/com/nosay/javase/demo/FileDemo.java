package src.com.nosay.javase.demo;

import java.io.File;

public class FileDemo {

    public static void main(String[] args) throws Exception {
        File file = new File("abc.txt");
        file.createNewFile();
        file.canExecute();
        file.canRead();
        file.canWrite();
        file.exists();
        file.getName(); // abc.txt
        file.getAbsolutePath(); // 绝对路径
        file.getParent(); // 父路径名称
        file.getCanonicalPath(); // 返回绝对路径规范格式
        file.isFile();
        file.isDirectory();
        file.listFiles(); // 返回File[]
        file.list(); // 返回String[]
        file.mkdir(); // 创建单级目录
        file.mkdirs(); // 创建多级目录
    }

}
