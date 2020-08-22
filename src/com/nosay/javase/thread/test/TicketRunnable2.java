package src.com.nosay.javase.thread.test;

// 线程同步
public class TicketRunnable2 implements Runnable {

    // 共享变量。实现Runnable接口就不需要声明成static
    public int ticket = 5;

    @Override
    public void run() {
        // 加锁，当前线程在执行的时候其他线程不能进来
        for (int i = 0; i < 100; i++) {
            // 睡眠一会，让其他线程能够进来，有机会抢占资源
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 第一种方法：同步代码块：synchronized(共享资源){}
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票");
                }
            }
            // 第二种方法：同步方法
            // this.sale();
        }
    }

    public synchronized void sale() {
        // 睡眠一会，让其他线程能够进来，有机会抢占资源
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 第一种方法：同步代码块：synchronized(共享资源){}
        synchronized (this) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票");
            }
        }
    }

    public static void main(String[] args) {
        TicketRunnable2 ticket = new TicketRunnable2();
        (new Thread(ticket, "A")).start();
        (new Thread(ticket, "B")).start();
        (new Thread(ticket, "C")).start();
        (new Thread(ticket, "D")).start();
    }
}
