package src.com.nosay.javase.pc;

public class Test {

    // 问题：生产者没生产东西消费者就获取了
    // wangzaikuangquanshui 品牌和名字对不上
    public static void main(String[] args) {
        // 只有一个商品
        Goods goods = new Goods();

        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
