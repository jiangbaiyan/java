package src.com.nosay.javase.thread.test;

public class TicketRunnable implements Runnable {

    // 共享变量。实现Runnable接口就不需要声明成static
    public int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--)+ "张票");
            }
        }
    }

    public static void main(String[] args) {
        TicketRunnable ticket = new TicketRunnable();
        // 代理模式，Thread（wangpo）代理ticket，实际干活的是ticket类（panjinlian）
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
