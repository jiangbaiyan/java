package src.com.nosay.javase.thread.pc;

public class Goods {

    private String brand;

    private String name;

    // 2.0增加一个标志位，默认是false，没商品；如果是true则有商品
    private boolean flag = false;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // 2.0版本：解决了名字对不上的问题，其实锁住goods对象，唤醒等待也是针对goods对象
    // 消费者获取商品
    public synchronized void get() {
        // 没有商品，等待生产者生产商品
        if (!flag) {
            try {
                // 等待（其实是goods对象等待）
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了" + this.getBrand() + "---" + this.getName());
        this.flag = false;
        // 唤醒生产者（其实是唤醒goods对象）生产
        notify();
    }

    // 生产者生产商品
    public synchronized void set(String brand, String name) {
        // 如果已经生产过了，等待消费者取走商品
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 设置品牌和名称必须是原子操作，要么都成功，要么都不成功
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了" + this.getBrand() + "--" + this.getName());
        this.flag = true;
        // 唤醒消费者生产
        notify();
    }
}
