package com.game.botrunningsystem;

import com.game.botrunningsystem.service.BotRunningService;
import com.game.botrunningsystem.service.impl.BotRunningServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotRunningSystemApplication {
    public static void main(String[] args) {
        BotRunningServiceImpl.botpool.start();
        SpringApplication.run(BotRunningSystemApplication.class, args);
    }
}
