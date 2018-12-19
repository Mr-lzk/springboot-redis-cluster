package com.gzly.query.redis.queryredis.controller;

import com.gzly.query.redis.queryredis.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzk
 * @date 2018/8/15
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/get")
    public String getCache() {
        return cacheService.get();
    }

    @GetMapping("/del")
    public String del() {
        cacheService.del();
        return "";
    }
}
