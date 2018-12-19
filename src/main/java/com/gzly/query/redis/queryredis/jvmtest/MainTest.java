package com.gzly.query.redis.queryredis.jvmtest;

/**
 * @author lzk
 * @date 2018/8/3
 */
public class MainTest {
    public static void main(String[] args) {
        MulService ms1 = new MulService();
        MulService ms2 = new MulService();

        Thread thread1 = new Thread(() -> ms1.foo("线程xxxx1"),"xxxx1");
        Thread thread2 = new Thread(() -> ms2.foo("线程xxxx2"),"xxxx2");

        thread1.start();
        thread2.start();

    }
}
