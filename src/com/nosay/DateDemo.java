package src.com.nosay;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date(); // 很多方法都过气了，用Calender类代替了
        System.out.println(date); // Sun Aug 02 19:07:42 CST 2020
        System.out.println(date.getTime()); // 时间戳，相当于php的time()
    }
}
