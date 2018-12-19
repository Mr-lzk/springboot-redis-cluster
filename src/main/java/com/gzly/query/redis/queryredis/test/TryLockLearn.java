package com.gzly.query.redis.queryredis.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lzk
 * @date 2018/12/19
 */
public class TryLockLearn {

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    private List<String> list = new ArrayList<>();

    public String get(int index) {
        readLock.lock();
        try {
            return list.get(index);
        } finally {
            readLock.unlock();
        }
    }

    public void add(String element) {
        writeLock.lock();
        try {
            list.add(element);
        } finally {
            writeLock.unlock();
        }
    }
}
