package com.gzly.query.redis.queryredis.controller;

import com.gzly.query.redis.queryredis.entity.Book;
import com.gzly.query.redis.queryredis.redis.QueryRedis;
import com.gzly.query.redis.queryredis.redis.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzk
 * @date 2018/6/11
 */
@RestController
public class TestController {

    @Autowired
    private QueryRedis queryRedis;

    @GetMapping("/test")
    public String test() {
        Book book = new Book("spring boot redis","2018");
        queryRedis.set("book",book);
        Book book1 = queryRedis.get("book",Book.class);
        System.out.println(book1.getClass());
        System.out.println(book1);
        return "test success";
    }
}
