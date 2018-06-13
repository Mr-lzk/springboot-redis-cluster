package com.gzly.query.redis.queryredis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


/**
 * redis配置类，自定义redisTemplate的JavaBean
 * @author lzk
 * @date 2018/6/11
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisClusterConfiguration rc = new RedisClusterConfiguration(redisProperties.getNodes());

        //TODO 设置jedis连接池相关参数，例如 最大连接数量。。。。
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        JedisConnectionFactory jf = new JedisConnectionFactory(rc,jedisPoolConfig);
        return jf;
    }

    @Bean
    @Primary
    public RedisTemplate<Object,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setDefaultSerializer(new RedisObjectSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new RedisObjectSerializer());
        return  redisTemplate;
    }

}
