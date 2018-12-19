package com.gzly.query.redis.queryredis.jvmtest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lzk
 * @date 2018/8/3
 */
public class MulService {

    public static Object o = new Object();

    public String foo(String in) {
//        Lock lock = new ReentrantLock();
//        lock.lock();

        synchronized (o) {
            if (Ticket.count > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Ticket.count--;
                String threadName = Thread.currentThread().getName();
                String res = "线程" + threadName + "消费车票1个------" + "剩余票数：" + Ticket.count;
                System.out.println(res);
            }
        }
//        lock.unlock();

        return "out>" + in;
    }
}
