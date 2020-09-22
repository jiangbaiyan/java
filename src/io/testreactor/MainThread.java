package src.io.testreactor;

// 不做IO和业务的事情
public class MainThread {

    public static void main(String[] args) {
        // 1.创建IO Thread（1个或多个）
        SelectorThreadGroup stg = new SelectorThreadGroup(1);
        // 混杂模式，只有一个线程负责accept，每个都会被分配client，进行读写
        //SelectorThreadGroup stg = new SelectorThreadGroup(3);

        // 2.把监听的server注册到某一个selector上
        stg.bind(9999);
    }
}
