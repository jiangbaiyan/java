package src.javase.demo;

// 继承Thread类
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName() + "----------" + i);
        }
    }

    public static void main(String[] args) {
        // 1. 新生状态（new ThreadDemo）
        // 2. 就绪状态（调用start()之后，所有线程都添加到就绪队列中，去抢占CPU）
        // 3. 运行状态（当前进程获取到CPU资源，就绪队列里所有线程会抢占到CPU，谁抢占到谁是运行态）
        // 4. 死亡状态（运行中的线程正常/异常 执行完所有代码逻辑）
        // 5. 阻塞状态（结束阻塞后会重新进入就绪队列）
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start(); // 启动线程
        // 主线程打印十次
        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName() + "----------" + i);
        }
    }
}
