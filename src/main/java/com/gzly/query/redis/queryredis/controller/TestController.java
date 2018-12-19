package com.gzly.query.redis.queryredis.controller;

import com.gzly.query.redis.queryredis.entity.Book;
import com.gzly.query.redis.queryredis.redis.QueryRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lzk
 * @date 2018/6/11
 */
@RestController
public class TestController {

    @Autowired
    private QueryRedis queryRedis;

    @GetMapping("/aspect")
    public String aspect(String param) {
        System.out.println("xx");
//        throw new RuntimeException();
        return null;
    }

    @GetMapping("/test")
    public String test() {
        Book book = new Book("spring boot redis","2018");
        queryRedis.set("book",book);
        Book book1 = queryRedis.get("book",Book.class);
        System.out.println(book1.getClass());
        System.out.println(book1);
        return "test success";
    }

    @PostMapping(value = "/test2")
    public String test2(String aa,HttpServletRequest request) {
        System.out.println(aa);

        return "pass";
    }

    @PostMapping("/clear-redis")
    public String clearRedisKey(String key) {
        System.out.println("开始清除redis-key：" + key);
        try {
            queryRedis.set(key, null);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @PostMapping("/get-redis")
    public String getRedisValue(String key) {
        String value = queryRedis.get(key);
        System.out.println("redis-key:" + key + "; 对应的value：" + value);
        return "key: " + key + " \nvalue: " + value;
    }

    @PostMapping("/getBook")
    public String getBook(@RequestBody @Validated Book book) {
        return book.toString();
    }
}
