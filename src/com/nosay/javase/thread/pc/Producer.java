package src.com.nosay.javase.thread.pc;

public class Producer implements Runnable {

    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            // 生产娃哈哈或者矿泉水
            if (i % 2 == 0) {
                this.goods.set("wahaha", "kuangquanshui");
            } else {
                this.goods.set("wangzai", "xiaomantou");
            }
        }
    }
}
