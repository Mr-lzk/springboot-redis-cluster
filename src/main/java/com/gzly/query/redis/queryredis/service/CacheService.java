package com.gzly.query.redis.queryredis.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author lzk
 * @date 2018/8/15
 */
@Service
public class CacheService {

    @Cacheable(cacheNames = "user", key = "'mycache'")
    public String get() {
        System.out.println("================start get==============");
        return "xxxxxxxyyyyyyy";
    }

    @CacheEvict(cacheNames = "user", key = "'mycache'")
    public void del() {
        return;
    }
}
