package com.gzly.query.redis.queryredis.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 获取配置文件中的redis集群
 * @author lzk
 * @date 2018/6/12
 */
@ConfigurationProperties(prefix = "query.redis")
@Component
public class RedisProperties {

    private List<String> nodes;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
