package com.game.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConnectionTest implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void run(String... args) {
        System.out.println("========== Redis 连接测试开始 ==========");
        try {
            redisTemplate.opsForValue().set("test:hello", "redis works!");
            String value = redisTemplate.opsForValue().get("test:hello");
            System.out.println(">>> 从 Redis 读到的值: " + value);
            System.out.println("========== Redis 连接成功 ✅ ==========");
        } catch (Exception e) {
            System.out.println("########## Redis 连接失败 ❌ ##########");
            e.printStackTrace();
        }
    }
}