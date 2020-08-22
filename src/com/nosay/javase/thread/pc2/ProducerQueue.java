package src.com.nosay.javase.thread.pc2;

import java.util.concurrent.BlockingQueue;

public class ProducerQueue implements Runnable {

    private BlockingQueue blockingQueue;

    public ProducerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("生产者开始生产商品:" + i);
            try {
                this.blockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
