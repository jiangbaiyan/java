package JavaSE.src.com.nosay.demo;

public enum EventEnum {

    // 构造方法直接定义
    LAUNCH("launch"), PAGEVIEW("pageview"), EVENT("event");

    EventEnum(String name) {
        this.name = name;
    }

    private String name;

    public void show() {
        System.out.println(this.name);
        EventEnum[] ee = values(); // 返回所有枚举值
        for (int i = 0; i < ee.length; i++) {
            System.out.println(ee[i]);
        }
    }
}
