package com.game.botrunningsystem.service.impl;


import com.game.botrunningsystem.service.BotRunningService;
import com.game.botrunningsystem.service.impl.utils.BotPool;
import org.springframework.stereotype.Service;

@Service
public class BotRunningServiceImpl implements BotRunningService {
    public final static BotPool botpool = new BotPool();

    @Override
    public String addBot(Integer userId, String botCode, String input) {
        System.out.println("add bot: " + userId + " " + botCode + " " + input);
        botpool.addBot(userId, botCode, input);
        return "add bot success";
    }
}
