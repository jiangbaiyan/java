package src;

import JavaSE.src.com.nosay.util.FanxingClass;

public class Main {

    public static void main(String[] args) {
        FanxingClass<String> fxc = new FanxingClass<>("jby", "12");
        fxc.show(123);
        System.out.println(fxc.age);
    }
}
