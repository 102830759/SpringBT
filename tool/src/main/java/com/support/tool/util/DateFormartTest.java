package com.support.tool.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 */

public class DateFormartTest {
    public static void main(String args[]) {
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        String s="2018-12-13 23";
        String formatss = yyyyMMdd.format(s);
        System.out.print(formatss);

        //解析日期
        String dateStr = "2016年10月25日 12时05分33秒";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        System.out.println(date);
        //日期转换为字符串
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss a");
        String nowStr = now.format(format);
        System.out.println(nowStr);

        //ThreadLocal来限制SimpleDateFormat
        System.out.println(dateFormat(new Date()));
    }

    //要在高并发环境下能有比较好的体验，可以使用ThreadLocal来限制SimpleDateFormat只能在线程内共享，这样就避免了多线程导致的线程安全问题。
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String dateFormat(Date date) {
        return threadLocal.get().format(date);
    }

}
