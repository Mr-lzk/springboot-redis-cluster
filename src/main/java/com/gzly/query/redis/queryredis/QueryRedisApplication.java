package com.gzly.query.redis.queryredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class QueryRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryRedisApplication.class, args);
	}
}
