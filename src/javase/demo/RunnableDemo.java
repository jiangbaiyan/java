package src.javase.demo;

// 实现Runnable接口
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName() + "----------" + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableDemo()).start();
        // 主线程打印十次
        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName() + "----------" + i);
        }
    }

}
