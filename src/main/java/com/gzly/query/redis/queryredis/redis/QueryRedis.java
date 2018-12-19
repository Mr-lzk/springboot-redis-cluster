package com.gzly.query.redis.queryredis.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 进一步封装redisTemplate的相关方法
 * @author lzk
 * @date 2018/6/12
 */
@Component
public class QueryRedis {

    @PostConstruct
    public void before() {
        System.out.println("<<<<<<<<<<<<<<----------->>>>>>>>>>>>>>");
        System.out.println("测试init-method========queryredis::before");
        System.out.println("<<<<<<<<<<<<<<----------->>>>>>>>>>>>>>");
    }

    @PreDestroy
    public void after() {
        System.out.println("<<<<<<<<<<<<<<----------->>>>>>>>>>>>>>");
        System.out.println("测试destroy-method==========queryredis::after");
        System.out.println("<<<<<<<<<<<<<<----------->>>>>>>>>>>>>>");
    }

    /**
     * 实际注入的是我们的RedisConfig中的Bean
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 向redis中插入数据
     * @param k
     * @param o
     */
    public void set(String k,Object o) {
//        String v = JSON.toJSONString(o);
        redisTemplate.opsForValue().set(k,o);
    }

    /**
     * 从redis中取出字符串
     * @param key
     * @return
     */
    public String get(String key) {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * 从redis中取出java对象
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        ValueOperations<String,T> valueOperations = redisTemplate.opsForValue();
        T t = valueOperations.get(key);
//        String res = valueOperations.get(key);
//        JSONObject jsonObject = JSONObject.parseObject(res);
//        return jsonObject.toJavaObject(clazz);
        return t;
    }
}
