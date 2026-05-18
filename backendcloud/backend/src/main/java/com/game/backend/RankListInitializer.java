package com.game.backend;

import com.game.backend.mapper.UserMapper;
import com.game.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class RankListInitializer implements CommandLineRunner {

    public static final String RANK_KEY = "rank:user";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void run(String... args) {
        System.out.println("========== 排行榜冷启动开始 ==========");
        try {
            // 1. 清掉旧的 ZSet，避免重启后数据残留导致脏数据
            redisTemplate.delete(RANK_KEY);

            // 2. 从 MySQL 查出所有用户
            List<User> users = userMapper.selectList(null);

            // 3. 逐个灌进 ZSet：member = userId, score = rating
            for (User user : users) {
                redisTemplate.opsForZSet().add(
                        RANK_KEY,
                        user.getId().toString(),
                        user.getRating()
                );
            }

            // 4. 验证：打印 ZSet 里的元素总数
            Long count = redisTemplate.opsForZSet().zCard(RANK_KEY);
            System.out.println(">>> 已灌入用户数: " + count);
            System.out.println("========== 排行榜冷启动完成 ✅ ==========");
        } catch (Exception e) {
            System.out.println("########## 排行榜冷启动失败 ❌ ##########");
            e.printStackTrace();
        }
    }
}