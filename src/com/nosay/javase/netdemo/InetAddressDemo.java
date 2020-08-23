package src.com.nosay.javase.netdemo;

import java.net.InetAddress;

public class InetAddressDemo {
    public static void main(String[] args) throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress xxx = InetAddress.getByName("www.baidu.com");
        System.out.println(xxx);

    }
}
