package src.com.nosay.javase.thread_pool;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "running");
    }
}
