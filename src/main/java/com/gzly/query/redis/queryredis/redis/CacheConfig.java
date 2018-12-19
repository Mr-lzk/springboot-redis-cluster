package com.gzly.query.redis.queryredis.redis;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;

import java.util.Collection;

/**
 * @author lzk
 * @date 2018/8/15
 */
@Configuration
@EnableCaching(proxyTargetClass = true)
@DependsOn("redisConfig")
public class CacheConfig{

    @Bean
    public CacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.create(jedisConnectionFactory);
        return redisCacheManager;
    }
}
