package com.gzly.query.redis.queryredis.jvmtest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lzk
 * @date 2018/8/3
 */
public class Ticket {

    public static int count = 1;

    public static void main(String[] args) throws ParseException {
        String s = "2018-09-17 14:25:15.0";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(s);
//        System.out.println(d);

//        DateTime dateTime = DateTime.parse(s, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(dateTime);
        Date now = new Date();

        System.out.println("d.after(now)===" + d.after(now));
    }
}
