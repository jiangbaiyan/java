package JavaSE.src.com.nosay.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) throws Exception {
        // Date类很多方法都过气了，用Calender类代替了
        Date date = new Date();
        System.out.println(date); // Sun Aug 02 19:07:42 CST 2020
        System.out.println(date.getTime()); // 时间戳，相当于php的time()
        // DateFormat - 日期时间格式化
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
        System.out.println(dateFormat.parse("2020-8-3 18:55:51"));
        // Calendar类 - 常用
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.YEAR));
    }
}