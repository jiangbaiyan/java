package src.com.nosay.javase.pc2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

    public static void main(String[] args) {

        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

        // 共享一个blockingQueue
        ProducerQueue producerQueue = new ProducerQueue(blockingQueue);
        ConsumerQueue consumerQueue = new ConsumerQueue(blockingQueue);

        new Thread(producerQueue).start();
        new Thread(consumerQueue).start();

    }
}
